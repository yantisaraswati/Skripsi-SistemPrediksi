package com.yanti.inventorycontroll.domain.service.item;

import com.yanti.inventorycontroll.domain.bean.item.ItemLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.item.ItemLoadServiceOutputBean;

public interface ItemLoadService {
	public ItemLoadServiceOutputBean execute(ItemLoadServiceInputBean input);
}
