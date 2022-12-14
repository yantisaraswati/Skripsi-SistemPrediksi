package com.yanti.inventorycontroll.domain.dto.request;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Request {
	private Long requestId;
	private Date requestDate;
	private String organization;
	private List<RequestItem> requestItems;
}
