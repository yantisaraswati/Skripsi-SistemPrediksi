package com.yanti.inventorycontroll.domain.dto.movingaverage;

import java.util.List;

import lombok.Data;

@Data
public class MovingAverage {
	private Long movingAverageId;
	private String period;
	private String organization;
	private String itemName;
	private String unit;
	private Integer nMonth;
	private Double forecast;
	private Double mae;
    private Double mse;
    private Double mape;
	private List<MovingAverageDetail> movingAverageDetailList;
}
