package com.yanti.inventorycontroll.app.movingaverage;

import lombok.Data;

@Data
public class MovingAverageForm {

	private String lastPeriod;
	private Integer timeFrame;
	private Integer predictedMonth;
	private Long organizationId;
	
}
