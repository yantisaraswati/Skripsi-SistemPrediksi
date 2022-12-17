package com.yanti.inventorycontroll.domain.service.apriori;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.repository.organization.MOrganizationRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AprioriLoadServiceImpl implements AprioriLoadService {
	
	@Inject
	private MOrganizationRepository organizationRepo;
	
	public AprioriLoadServiceOutputBean execute(AprioriLoadServiceInputBean input) {
		AprioriLoadServiceOutputBean output = new AprioriLoadServiceOutputBean();
		try {
			output.setOrganizationList(organizationRepo.selectByCriteria(null));
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return output;
	}
}
