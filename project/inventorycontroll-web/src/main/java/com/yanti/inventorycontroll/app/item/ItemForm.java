package com.yanti.inventorycontroll.app.item;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.item.Item;

import lombok.Data;

@Data
public class ItemForm {

	private List<Item> ItemList;
}
