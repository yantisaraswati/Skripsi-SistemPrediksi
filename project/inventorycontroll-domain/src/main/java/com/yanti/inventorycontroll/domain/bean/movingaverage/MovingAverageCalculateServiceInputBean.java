package com.yanti.inventorycontroll.domain.bean.movingaverage;

import lombok.Data;

@Data
public class MovingAverageCalculateServiceInputBean {

	private Long userAccountId;
	private Integer timeFrame;
	private Integer predictedMonth;
	private Long organizationId;
}
