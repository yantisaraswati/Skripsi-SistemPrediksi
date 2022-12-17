package com.yanti.inventorycontroll.domain.dto.apriori;

import java.util.List;

import lombok.Data;

@Data
public class ItemTransaction {
	private Long requestId;
	private List<Long> items;
}
