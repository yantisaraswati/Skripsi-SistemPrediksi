package com.yanti.inventorycontroll.domain.service.movingaverage;

import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageLoadServiceOutputBean;

public interface MovingAverageLoadService {
	public MovingAverageLoadServiceOutputBean execute(MovingAverageLoadServiceInputBean input);
}
