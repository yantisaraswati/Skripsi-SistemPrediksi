package com.yanti.inventorycontroll.domain.service.unit;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.bean.unit.UnitLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.unit.UnitLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.parameter.Parameter;
import com.yanti.inventorycontroll.domain.model.businessparameter.MBusinessParameterCriteria;
import com.yanti.inventorycontroll.domain.repository.businessparameter.MBusinessParameterRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UnitLoadServiceImpl implements UnitLoadService {
	
	@Inject
	private MBusinessParameterRepository unitRepo;
	
	public UnitLoadServiceOutputBean execute(UnitLoadServiceInputBean input) {
		UnitLoadServiceOutputBean output = new UnitLoadServiceOutputBean();
		try {
			MBusinessParameterCriteria unitC = new MBusinessParameterCriteria();
			unitC.createCriteria().andCategoryEqualTo("UNIT");
			int totalRow = (int) unitRepo.countByCriteria(unitC);
			
			List<Parameter> itemList = getUnitList(input);
			
			output.setTotalCount(totalRow);
			output.setUnitList(itemList);
		} catch (Exception e) {
			log.error("Error ", e);
		}
		return output;
	}

	private List<Parameter> getUnitList(UnitLoadServiceInputBean input) {
		RowBounds rowBound = new RowBounds(input.getPage() * input.getSize(), input.getSize());
		
		return unitRepo.selectParameterDetail("UNIT", rowBound);		
	}
}
