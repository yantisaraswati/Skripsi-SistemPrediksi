package com.yanti.inventorycontroll.domain.service.apriori;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceOutputBean;

public interface AprioriCalculateService {
	public AprioriCalculateServiceOutputBean execute(AprioriCalculateServiceInputBean input);
}
