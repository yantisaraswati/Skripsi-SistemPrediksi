package com.yanti.inventorycontroll.domain.bean.apriori;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.parameter.Parameter;

import lombok.Data;

@Data
public class AprioriLoadServiceOutputBean {
	private List<Parameter> unitList;
	private Integer totalCount;
}
