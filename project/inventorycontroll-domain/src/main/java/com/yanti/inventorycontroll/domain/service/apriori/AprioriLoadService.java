package com.yanti.inventorycontroll.domain.service.apriori;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceOutputBean;

public interface AprioriLoadService {
	public AprioriLoadServiceOutputBean execute(AprioriLoadServiceInputBean input);
}
