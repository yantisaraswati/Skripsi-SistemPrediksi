package com.yanti.inventorycontroll.domain.dto.apriori;

import lombok.Data;

@Data
public class AssociationRule {
	private String rules;
	private Integer support;
	private Integer confidence;
	private Integer suppTimesConfidence;
}
