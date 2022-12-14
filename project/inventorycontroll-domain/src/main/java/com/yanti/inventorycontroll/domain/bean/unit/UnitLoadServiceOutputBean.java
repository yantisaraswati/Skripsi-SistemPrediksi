package com.yanti.inventorycontroll.domain.bean.unit;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.parameter.Parameter;

import lombok.Data;

@Data
public class UnitLoadServiceOutputBean {
	private List<Parameter> unitList;
	private Integer totalCount;
}
