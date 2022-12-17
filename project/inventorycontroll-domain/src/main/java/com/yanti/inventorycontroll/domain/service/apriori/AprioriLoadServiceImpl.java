package com.yanti.inventorycontroll.domain.service.apriori;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.apriori.AssociationRule;
import com.yanti.inventorycontroll.domain.dto.apriori.ItemSetSupport;
import com.yanti.inventorycontroll.domain.model.apriori.HApriori;
import com.yanti.inventorycontroll.domain.model.apriori.HAprioriCriteria;
import com.yanti.inventorycontroll.domain.model.aprioriassociation.HAprioriAssociation;
import com.yanti.inventorycontroll.domain.model.aprioriassociation.HAprioriAssociationCriteria;
import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupport;
import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupportCriteria;
import com.yanti.inventorycontroll.domain.repository.apriori.HAprioriRepository;
import com.yanti.inventorycontroll.domain.repository.aprioriassociation.HAprioriAssociationRepository;
import com.yanti.inventorycontroll.domain.repository.apriorisupport.HAprioriSupportRepository;
import com.yanti.inventorycontroll.domain.repository.apriorisupportitem.HAprioriSupportItemRepository;
import com.yanti.inventorycontroll.domain.repository.organization.MOrganizationRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AprioriLoadServiceImpl implements AprioriLoadService {

	@Inject
	private MOrganizationRepository organizationRepo;
	@Inject
	private HAprioriRepository aprioriRepo;
	@Inject
	private HAprioriSupportRepository aprioriSupportRepo;
	@Inject
	private HAprioriSupportItemRepository aprioriSupportItemRepo;
	@Inject
	private HAprioriAssociationRepository aprioriAssociationRepo;

	public AprioriLoadServiceOutputBean execute(AprioriLoadServiceInputBean input) {
		AprioriLoadServiceOutputBean output = new AprioriLoadServiceOutputBean();
		try {
			if (input.getMinSupport() != null) {
				HApriori apriori = getApriori(input);
				if (apriori != null) {
					output.setItemSetSupportList(getItemSetSupport(apriori));
					output.setAssociationRuleList(getAssociationRule(apriori.getAprioriId()));
					if(output.getAssociationRuleList().isEmpty() || output.getAssociationRuleList().size() > output.getItemSetSupportList().size() * 2)
						output.setMessage("Hasil kemungkinan tidak valid dikarenakan nilai support yang terlalu kecil atau data transaksi yang kurang komprehensif.");
				} else {
					output.setMessage("Data tidak ditemukan, silahkan proses terlebih dahulu.");
				}
			}
			output.setOrganizationList(organizationRepo.selectByCriteria(null));
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return output;
	}

	private List<AssociationRule> getAssociationRule(Long aprioriId) {
		List<AssociationRule> associationRuleList = new ArrayList<>();

		HAprioriAssociationCriteria aprioriAssociationC = new HAprioriAssociationCriteria();
		aprioriAssociationC.createCriteria().andAprioriIdEqualTo(aprioriId);
		aprioriAssociationC.setOrderByClause("apriori_association_id");
		List<HAprioriAssociation> associationList = aprioriAssociationRepo.selectByCriteria(aprioriAssociationC);
		for (HAprioriAssociation association : associationList) {
			AssociationRule rule = new AssociationRule();
			rule.setRules(association.getRules());
			rule.setSupport(association.getSupport());
			rule.setConfidence(association.getConfidence());
			rule.setSuppTimesConfidence(association.getSupportConfidence());
			associationRuleList.add(rule);
		}
		return associationRuleList;
	}

	private List<ItemSetSupport> getItemSetSupport(HApriori apriori) {
		List<ItemSetSupport> itemSetSupportList = new ArrayList<>();

		HAprioriSupportCriteria aprioriSupportC = new HAprioriSupportCriteria();
		aprioriSupportC.createCriteria().andAprioriIdEqualTo(apriori.getAprioriId());
		aprioriSupportC.setOrderByClause("apriori_support_id");
		List<HAprioriSupport> aprioriSupportList = aprioriSupportRepo.selectByCriteria(aprioriSupportC);
		for (HAprioriSupport aprioriSupport : aprioriSupportList) {
			ItemSetSupport itemSupport = new ItemSetSupport();
			itemSupport.setCreatedDate(aprioriSupport.getCreatedDate());
			itemSupport.setOrganization(getOrganizationName(apriori.getOrganizationId()));
			itemSupport.setKItem("K-Item" + aprioriSupport.getKItem());
			itemSupport.setItemName(determineItems(aprioriSupport.getAprioriSupportId()));
			itemSupport.setSupport(aprioriSupport.getSupport());
			itemSetSupportList.add(itemSupport);
		}
		return itemSetSupportList;
	}

	private String determineItems(Long aprioriSupportId) {
		return aprioriSupportItemRepo.concatSupportItems(aprioriSupportId);
	}

	private String getOrganizationName(Long organizationId) {
		return organizationRepo.selectByPrimaryKey(organizationId).getOrganizationName();
	}

	private HApriori getApriori(AprioriLoadServiceInputBean input) {
		HAprioriCriteria aprioriC = new HAprioriCriteria();
		aprioriC.createCriteria().andMinSupportEqualTo(input.getMinSupport()).andMinConfidenceEqualTo(input.getMinConfidence()).andOrganizationIdEqualTo(input.getOrganizationId());
		List<HApriori> aprioriList = aprioriRepo.selectByCriteria(aprioriC);
		return aprioriList.isEmpty() ? null : aprioriList.get(0);
	}
}
