package com.yanti.inventorycontroll.app.apriori;

import javax.inject.Inject;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.service.apriori.AprioriLoadService;

@Controller
@RequestMapping("apriori")
public class AprioriController {

	@Inject
	private AprioriLoadService aprioriLoadService;
	
	@RequestMapping(value = "load", method = { RequestMethod.GET })
	public String load(AprioriForm form, Model model, @PageableDefault(size = 10) Pageable pageable) {
		AprioriLoadServiceInputBean input = new AprioriLoadServiceInputBean();
		input.setPage(pageable.getPageNumber());
		input.setSize(pageable.getPageSize());
		AprioriLoadServiceOutputBean output = aprioriLoadService.execute(input);
		return "apriori/apriori";
	}
}
