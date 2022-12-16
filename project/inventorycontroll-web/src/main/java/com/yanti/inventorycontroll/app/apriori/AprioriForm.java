package com.yanti.inventorycontroll.app.apriori;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.apriori.AssociationRule;
import com.yanti.inventorycontroll.domain.dto.apriori.ItemSetSupport;

import lombok.Data;

@Data
public class AprioriForm {

	private Integer minSupport;
	private Integer minConfidence;
	private Long organizationId;
	
	private List<ItemSetSupport> itemSetSupportList;
	private List<AssociationRule> associationRuleList;
}
