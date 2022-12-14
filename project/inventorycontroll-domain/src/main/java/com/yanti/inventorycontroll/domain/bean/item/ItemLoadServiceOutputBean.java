package com.yanti.inventorycontroll.domain.bean.item;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.item.Item;

import lombok.Data;

@Data
public class ItemLoadServiceOutputBean {
	private List<Item> itemList;
	private Integer totalCount;
}
