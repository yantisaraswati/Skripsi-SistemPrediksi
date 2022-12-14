package com.yanti.inventorycontroll.domain.service.request;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.request.RequestLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.request.RequestLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.request.Request;
import com.yanti.inventorycontroll.domain.model.request.TRequest;
import com.yanti.inventorycontroll.domain.model.request.TRequestCriteria;
import com.yanti.inventorycontroll.domain.repository.request.TRequestRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RequestLoadServiceImpl implements RequestLoadService {
	
	@Inject
	private TRequestRepository requestRepo;
	
	public RequestLoadServiceOutputBean execute(RequestLoadServiceInputBean input) {
		RequestLoadServiceOutputBean output = new RequestLoadServiceOutputBean();
		try {
			int totalRow = (int) requestRepo.countByCriteria(null);
			
			List<Long> requestIds = getIdsPerPage(input);
			
			List<Request> requestList = requestRepo.selectAllRequestDetail(requestIds);
			
			output.setTotalCount(totalRow);
			output.setRequestList(requestList);
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return output;
	}

	private List<Long> getIdsPerPage(RequestLoadServiceInputBean input) {
		RowBounds rowBound = new RowBounds(input.getPage() * input.getSize(), input.getSize());
		
		TRequestCriteria requestC = new TRequestCriteria();
		requestC.setOrderByClause("created_date desc");
		List<TRequest> requestList = requestRepo.selectByCriteria(requestC, rowBound);
		
		return requestList.stream().map(TRequest::getRequestId).collect(Collectors.toList());
	}
}
