package com.yanti.inventorycontroll.domain.dto.movingaverage;

import lombok.Data;

@Data
public class RequestedItem {
	private String period;
	private Long itemId;
	private String itemName;
	private Integer quantity;
}
