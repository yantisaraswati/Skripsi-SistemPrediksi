package com.yanti.inventorycontroll.domain.dto.apriori;

import java.util.List;

import lombok.Data;

@Data
public class ItemTransaction {
	private Long requestId; // 2
	private List<Long> items; // [1], [1,2], [1,...,10]
}
