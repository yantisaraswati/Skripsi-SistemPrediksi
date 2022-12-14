package com.yanti.inventorycontroll.app.request;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.request.Request;

import lombok.Data;

@Data
public class RequestForm {

	private List<Request> requestList;
}
