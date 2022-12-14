package com.yanti.inventorycontroll.app.unit;

import javax.inject.Inject;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanti.inventorycontroll.domain.bean.unit.UnitLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.unit.UnitLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.parameter.Parameter;
import com.yanti.inventorycontroll.domain.service.unit.UnitLoadService;

@Controller
@RequestMapping("unit")
public class UnitController {

	@Inject
	private UnitLoadService unitLoadService;
	
	@RequestMapping(value = "load", method = { RequestMethod.GET })
	public String load(UnitForm form, Model model, @PageableDefault(size = 10) Pageable pageable) {
		UnitLoadServiceInputBean input = new UnitLoadServiceInputBean();
		input.setPage(pageable.getPageNumber());
		input.setSize(pageable.getPageSize());
		UnitLoadServiceOutputBean output = unitLoadService.execute(input);
		form.setUnitList(output.getUnitList());
		model.addAttribute("totalCount", output.getTotalCount());
		model.addAttribute("pagination", new PageImpl<Parameter>(form.getUnitList(), pageable, (Integer) model.asMap().get("totalCount")));
		return "unit/unit";
	}
}
