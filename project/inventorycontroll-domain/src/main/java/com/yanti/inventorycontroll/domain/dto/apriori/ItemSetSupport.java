package com.yanti.inventorycontroll.domain.dto.apriori;

import java.util.Date;

import lombok.Data;

@Data
public class ItemSetSupport {
	private String itemName;
	private String unit;
	private Date createdDate;
	private String createdBy;
}
