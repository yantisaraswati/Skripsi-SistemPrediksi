package com.yanti.inventorycontroll.domain.service.item;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.item.ItemLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.item.ItemLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.item.Item;
import com.yanti.inventorycontroll.domain.repository.item.MItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemLoadServiceImpl implements ItemLoadService {
	
	@Inject
	private MItemRepository itemRepo;
	
	public ItemLoadServiceOutputBean execute(ItemLoadServiceInputBean input) {
		ItemLoadServiceOutputBean output = new ItemLoadServiceOutputBean();
		try {
			int totalRow = (int) itemRepo.countByCriteria(null);
			
			List<Item> itemList = getItemList(input);
			
			output.setTotalCount(totalRow);
			output.setItemList(itemList);
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return output;
	}

	private List<Item> getItemList(ItemLoadServiceInputBean input) {
		RowBounds rowBound = new RowBounds(input.getPage() * input.getSize(), input.getSize());
		
		return itemRepo.selectAllItemDetail(rowBound);		
	}
}
