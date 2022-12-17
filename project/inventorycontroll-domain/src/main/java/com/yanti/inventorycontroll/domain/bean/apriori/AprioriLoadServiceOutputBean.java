package com.yanti.inventorycontroll.domain.bean.apriori;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.apriori.AssociationRule;
import com.yanti.inventorycontroll.domain.dto.apriori.ItemSetSupport;
import com.yanti.inventorycontroll.domain.model.organization.MOrganization;

import lombok.Data;

@Data
public class AprioriLoadServiceOutputBean {
	private List<MOrganization> organizationList;
	private List<ItemSetSupport> itemSetSupportList;
	private List<AssociationRule> associationRuleList;
}
