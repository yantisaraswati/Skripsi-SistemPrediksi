package com.yanti.inventorycontroll.domain.dto.item;

import java.util.Date;

import lombok.Data;

@Data
public class Item {
	private String itemName;
	private String unit;
	private Date createdDate;
	private String createdBy;
}
