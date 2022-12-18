package com.yanti.inventorycontroll.domain.bean.movingaverage;

import lombok.Data;

@Data
public class MovingAverageLoadServiceInputBean {
	private Integer timeFrame;
	private Integer predictedMonth;
	private Long organizationId;
}
