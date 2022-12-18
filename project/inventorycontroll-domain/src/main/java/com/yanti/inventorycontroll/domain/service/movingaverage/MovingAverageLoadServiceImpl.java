package com.yanti.inventorycontroll.domain.service.movingaverage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.movingaverage.MovingAverage;
import com.yanti.inventorycontroll.domain.repository.movingaverage.HMovingAverageRepository;
import com.yanti.inventorycontroll.domain.repository.organization.MOrganizationRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovingAverageLoadServiceImpl implements MovingAverageLoadService {

	@Inject
	private MOrganizationRepository organizationRepo;
	@Inject
	private HMovingAverageRepository movingAverageRepo;

	public MovingAverageLoadServiceOutputBean execute(MovingAverageLoadServiceInputBean input) {
		MovingAverageLoadServiceOutputBean output = new MovingAverageLoadServiceOutputBean();
		try {
			String currentPeriod = getCurrentPeriod();
			if (input.getTimeFrame() != null) {
				List<MovingAverage> movingAverageList = movingAverageRepo.selectMovingAverageResult(input.getOrganizationId(), input.getTimeFrame(), currentPeriod);
				if (movingAverageList.isEmpty())
					output.setMessage("Data tidak ditemukan, silahkan proses terlebih dahulu.");
				output.setMovingAverageList(movingAverageList);
			}
			output.setLastPeriod(currentPeriod);
			output.setOrganizationList(organizationRepo.selectByCriteria(null));
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return output;
	}

	private String getCurrentPeriod() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(new Date());
	}
}
