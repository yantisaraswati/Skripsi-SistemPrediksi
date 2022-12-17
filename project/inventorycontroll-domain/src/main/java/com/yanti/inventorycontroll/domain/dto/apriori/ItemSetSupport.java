package com.yanti.inventorycontroll.domain.dto.apriori;

import java.util.Date;

import lombok.Data;

@Data
public class ItemSetSupport {
	private Date createdDate;
	private String organization;
	private String kItem;
	private String itemName;
	private Integer support;
}
