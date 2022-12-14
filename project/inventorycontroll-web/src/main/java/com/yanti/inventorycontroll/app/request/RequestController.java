package com.yanti.inventorycontroll.app.request;

import javax.inject.Inject;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanti.inventorycontroll.domain.bean.request.RequestLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.request.RequestLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.request.Request;
import com.yanti.inventorycontroll.domain.service.request.RequestLoadService;

@Controller
@RequestMapping("request")
public class RequestController {

	@Inject
	private RequestLoadService requestLoadService;
	
	@RequestMapping(value = "load", method = { RequestMethod.GET })
	public String load(RequestForm form, Model model, @PageableDefault(size = 10) Pageable pageable) {
		RequestLoadServiceInputBean input = new RequestLoadServiceInputBean();
		input.setPage(pageable.getPageNumber());
		input.setSize(pageable.getPageSize());
		RequestLoadServiceOutputBean output = requestLoadService.execute(input);
		form.setRequestList(output.getRequestList());
		model.addAttribute("totalCount", output.getTotalCount());
		model.addAttribute("pagination", new PageImpl<Request>(form.getRequestList(), pageable, (Integer) model.asMap().get("totalCount")));
		return "request/request";
	}
}
