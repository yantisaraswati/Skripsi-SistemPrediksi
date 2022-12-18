package com.yanti.inventorycontroll.domain.service.movingaverage;

import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageCalculateServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageCalculateServiceOutputBean;

public interface MovingAverageCalculateService {
	public MovingAverageCalculateServiceOutputBean execute(MovingAverageCalculateServiceInputBean input);
}
