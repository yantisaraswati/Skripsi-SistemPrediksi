package com.yanti.inventorycontroll.app.item;

import javax.inject.Inject;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanti.inventorycontroll.domain.bean.item.ItemLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.item.ItemLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.item.Item;
import com.yanti.inventorycontroll.domain.service.item.ItemLoadService;

@Controller
@RequestMapping("item")
public class ItemController {

	@Inject
	private ItemLoadService itemLoadService;
	
	@RequestMapping(value = "load", method = { RequestMethod.GET })
	public String load(ItemForm form, Model model, @PageableDefault(size = 10) Pageable pageable) {
		ItemLoadServiceInputBean input = new ItemLoadServiceInputBean();
		input.setPage(pageable.getPageNumber());
		input.setSize(pageable.getPageSize());
		ItemLoadServiceOutputBean output = itemLoadService.execute(input);
		form.setItemList(output.getItemList());
		model.addAttribute("totalCount", output.getTotalCount());
		model.addAttribute("pagination", new PageImpl<Item>(form.getItemList(), pageable, (Integer) model.asMap().get("totalCount")));
		return "item/item";
	}
}
