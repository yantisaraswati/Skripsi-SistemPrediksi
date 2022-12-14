package com.yanti.inventorycontroll.domain.dto.parameter;

import java.util.Date;

import lombok.Data;

@Data
public class Parameter {
	private String param;
	private Date createdDate;
	private String createdBy;
}
