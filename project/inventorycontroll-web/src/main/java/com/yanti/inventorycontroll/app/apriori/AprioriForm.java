package com.yanti.inventorycontroll.app.apriori;

import lombok.Data;

@Data
public class AprioriForm {

	private Integer minSupport;
	private Integer minConfidence;
	private Long organizationId;
	
}
