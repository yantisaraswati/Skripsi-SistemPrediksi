package com.yanti.inventorycontroll.domain.service.apriori;

import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceOutputBean;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AprioriLoadServiceImpl implements AprioriLoadService {
	
	
	public AprioriLoadServiceOutputBean execute(AprioriLoadServiceInputBean input) {
		AprioriLoadServiceOutputBean output = new AprioriLoadServiceOutputBean();
		try {
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return output;
	}
}
