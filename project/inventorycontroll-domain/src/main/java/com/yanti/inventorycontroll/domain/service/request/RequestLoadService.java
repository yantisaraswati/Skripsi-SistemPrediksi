package com.yanti.inventorycontroll.domain.service.request;

import com.yanti.inventorycontroll.domain.bean.request.RequestLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.request.RequestLoadServiceOutputBean;

public interface RequestLoadService {
	public RequestLoadServiceOutputBean execute(RequestLoadServiceInputBean input);
}
