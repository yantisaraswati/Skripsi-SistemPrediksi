package com.yanti.inventorycontroll.domain.bean.request;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.request.Request;

import lombok.Data;

@Data
public class RequestLoadServiceOutputBean {
	private List<Request> requestList;
	private Integer totalCount;
}
