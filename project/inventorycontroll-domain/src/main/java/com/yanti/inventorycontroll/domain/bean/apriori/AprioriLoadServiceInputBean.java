package com.yanti.inventorycontroll.domain.bean.apriori;

import lombok.Data;

@Data
public class AprioriLoadServiceInputBean {
	private Integer minSupport;
	private Integer minConfidence;
	private Long organizationId;
}
