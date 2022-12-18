package com.yanti.inventorycontroll.domain.dto.movingaverage;

import lombok.Data;

@Data
public class MovingAverageDetail {
	private String period;
	private Integer quantity;
	private Double forecast;
	private Double error;
	private Double errorAbsolute;
	private Double errorSquared;
	private Double errorPercentage;
}
