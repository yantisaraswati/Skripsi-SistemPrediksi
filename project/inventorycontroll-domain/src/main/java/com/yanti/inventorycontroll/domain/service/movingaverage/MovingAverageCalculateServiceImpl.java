package com.yanti.inventorycontroll.domain.service.movingaverage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.BusinessException;

import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageCalculateServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageCalculateServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.movingaverage.RequestedItem;
import com.yanti.inventorycontroll.domain.model.movingaverage.HMovingAverage;
import com.yanti.inventorycontroll.domain.model.movingaverage.HMovingAverageCriteria;
import com.yanti.inventorycontroll.domain.model.movingaveragedetail.HMovingAverageDetail;
import com.yanti.inventorycontroll.domain.model.movingaveragedetail.HMovingAverageDetailCriteria;
import com.yanti.inventorycontroll.domain.repository.aprioriassociationitem.HAprioriAssociationItemRepository;
import com.yanti.inventorycontroll.domain.repository.movingaverage.HMovingAverageRepository;
import com.yanti.inventorycontroll.domain.repository.movingaveragedetail.HMovingAverageDetailRepository;
import com.yanti.inventorycontroll.domain.repository.requestitem.TRequestItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovingAverageCalculateServiceImpl implements MovingAverageCalculateService {

	@Inject
	private HAprioriAssociationItemRepository aprioriAssociationItemRepo;
	@Inject
	private TRequestItemRepository requestItemRepo;
	@Inject
	private HMovingAverageRepository movingAverageRepo;
	@Inject
	private HMovingAverageDetailRepository movingAverageDetailRepo;

	private Long userId;
	private Date currentDate;
	private String currentPeriod;
	private Double forecast;
	private Double mae;
	private Double mse;
	private Double mape;

	public MovingAverageCalculateServiceOutputBean execute(MovingAverageCalculateServiceInputBean input) {
		MovingAverageCalculateServiceOutputBean output = new MovingAverageCalculateServiceOutputBean();
		try {
			prepareInitialData(input.getUserAccountId());

			deletePreviousData(input);

			List<Long> itemIds = aprioriAssociationItemRepo.selectProcessedItem(input.getOrganizationId());
			if (itemIds.isEmpty())
				throw new BusinessException("Tidak ada data yang diproses, silahkan lakukan proses apriori terlebih dahulu.");

			List<RequestedItem> requestedItemList = requestItemRepo.selectRequestedItem(input.getOrganizationId(), itemIds);
			int totalSaved = 0;
			for (Long itemId : itemIds) {
				List<RequestedItem> items = filterRequestedItem(itemId, requestedItemList);
				if (items.size() < input.getTimeFrame())
					continue;

				List<HMovingAverageDetail> movingAverageDetailList = calculateMovingAverage(items, input.getTimeFrame());
				Long movingAverageId = saveMovingAverage(itemId, input.getOrganizationId(), input.getTimeFrame());
				saveMovingAverageDetail(movingAverageId, movingAverageDetailList);

				totalSaved++;
			}

			if (totalSaved == 0)
				throw new BusinessException("Tidak ada data yang diproses, karena jumlah permintaan terlalu sedikit.");
			else if (totalSaved < itemIds.size())
				throw new BusinessException("Sebagian data tidak diproses karena jumlah permintaan terlalu sedikit.");
			
			output.setSuccess(true);
		} catch (BusinessException e) {
			log.error("Error ", e);
			output.setMessage(e.getResultMessages().getList().get(0).getText());
			output.setSuccess(false);
		}
		return output;
	}

	private void saveMovingAverageDetail(Long movingAverageId, List<HMovingAverageDetail> movingAverageDetailList) {
		for (HMovingAverageDetail movingAverageDetail : movingAverageDetailList) {
			movingAverageDetail.setMovingAverageId(movingAverageId);
			movingAverageDetail.setCreatedBy(userId);
			movingAverageDetail.setCreatedDate(currentDate);
			movingAverageDetail.setUpdatedBy(userId);
			movingAverageDetail.setUpdatedDate(currentDate);
			movingAverageDetailRepo.insert(movingAverageDetail);
		}
	}

	private Long saveMovingAverage(Long itemId, Long organizationId, Integer timeFrame) {
		HMovingAverage movingAverage = new HMovingAverage();
		movingAverage.setOrganizationId(organizationId);
		movingAverage.setItemId(itemId);
		movingAverage.setPeriod(currentPeriod);
		movingAverage.setNMonth(timeFrame);
		movingAverage.setForecast(forecast);
		movingAverage.setMae(mae);
		movingAverage.setMse(mse);
		movingAverage.setMape(mape);
		movingAverage.setCreatedBy(userId);
		movingAverage.setCreatedDate(currentDate);
		movingAverage.setUpdatedBy(userId);
		movingAverage.setUpdatedDate(currentDate);
		movingAverageRepo.insert(movingAverage);
		return movingAverage.getMovingAverageId();
	}

	private List<HMovingAverageDetail> calculateMovingAverage(List<RequestedItem> items, Integer timeFrame) {
		Double forecast = null;
		double totalErrorAbsolute = 0;
		double totalErrorSquared = 0;
		double totalErrorPercentage = 0;

		List<HMovingAverageDetail> movingAverageDetailList = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			Integer quantity = items.get(i).getQuantity();
			Double error = (i < timeFrame) ? null : quantity - forecast;
			Double errorAbsolute = (i < timeFrame) ? null : Math.abs(error);
			Double errorSquared = (i < timeFrame) ? null : Math.pow(error, 2);
			Double errorPercentage = (i < timeFrame) ? null : (errorAbsolute / quantity) * 100;

			totalErrorAbsolute += (i < timeFrame) ? 0 : errorAbsolute;
			totalErrorSquared += (i < timeFrame) ? 0 : errorSquared;
			totalErrorPercentage += (i < timeFrame) ? 0 : errorPercentage;

			HMovingAverageDetail movingAverageDetail = new HMovingAverageDetail();
			movingAverageDetail.setPeriod(items.get(i).getPeriod());
			movingAverageDetail.setQuantity(quantity);
			movingAverageDetail.setForecast(forecast);
			movingAverageDetail.setError(error);
			movingAverageDetail.setErrorAbsolute(errorAbsolute);
			movingAverageDetail.setErrorSquared(errorSquared);
			movingAverageDetail.setErrorPercentage(errorPercentage);
			movingAverageDetailList.add(movingAverageDetail);

			forecast = calculateForecast(items, timeFrame, i);
		}

		int n = items.size() - timeFrame;
		this.forecast = forecast;
		this.mae = totalErrorAbsolute / (n == 0 ? 1 : n);
		this.mse = totalErrorSquared / (n == 0 ? 1 : n);
		this.mape = totalErrorPercentage / (n == 0 ? 1 : n);
		return movingAverageDetailList;
	}

	private Double calculateForecast(List<RequestedItem> items, Integer timeFrame, int i) {
		if (i - (timeFrame - 1) < 0)
			return null;

		List<RequestedItem> itemInTimeFrame = items.subList(i - (timeFrame - 1), i + 1);
		return itemInTimeFrame.stream().mapToDouble(RequestedItem::getQuantity).sum() / timeFrame;
	}

	private List<RequestedItem> filterRequestedItem(Long itemId, List<RequestedItem> requestedItemList) {
		return requestedItemList.stream().filter(i -> i.getItemId().equals(itemId)).collect(Collectors.toList());
	}

	private String getCurrentPeriod() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(new Date());
	}

	private void deletePreviousData(MovingAverageCalculateServiceInputBean input) {
		HMovingAverageCriteria movingAverageC = new HMovingAverageCriteria();
		movingAverageC.createCriteria().andOrganizationIdEqualTo(input.getOrganizationId()).andNMonthEqualTo(input.getTimeFrame()).andPeriodEqualTo(currentPeriod);
		List<HMovingAverage> movingAverageList = movingAverageRepo.selectByCriteria(movingAverageC);
		for (HMovingAverage movingAverage : movingAverageList) {

			HMovingAverageDetailCriteria movingAverageDetailC = new HMovingAverageDetailCriteria();
			movingAverageDetailC.createCriteria().andMovingAverageIdEqualTo(movingAverage.getMovingAverageId());
			movingAverageDetailRepo.deleteByCriteria(movingAverageDetailC);
		}
		movingAverageRepo.deleteByCriteria(movingAverageC);
	}

	private void prepareInitialData(Long userAccountId) {
		this.userId = userAccountId;
		this.currentDate = new Date();
		this.currentPeriod = getCurrentPeriod();
	}
}
