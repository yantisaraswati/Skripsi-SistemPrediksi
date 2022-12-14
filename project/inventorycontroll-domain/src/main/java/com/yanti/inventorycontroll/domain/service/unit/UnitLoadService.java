package com.yanti.inventorycontroll.domain.service.unit;

import com.yanti.inventorycontroll.domain.bean.unit.UnitLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.unit.UnitLoadServiceOutputBean;

public interface UnitLoadService {
	public UnitLoadServiceOutputBean execute(UnitLoadServiceInputBean input);
}
