package com.yanti.inventorycontroll.domain.bean.apriori;

import lombok.Data;

@Data
public class AprioriCalculateServiceInputBean {
	
	private Long userAccountId;
	private Integer minSupport;
	private Integer minConfidence;
	private Long organizationId;
	
}
