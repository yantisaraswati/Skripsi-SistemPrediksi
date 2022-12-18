package com.yanti.inventorycontroll.domain.bean.movingaverage;

import java.util.List;

import com.yanti.inventorycontroll.domain.dto.movingaverage.MovingAverage;
import com.yanti.inventorycontroll.domain.model.organization.MOrganization;

import lombok.Data;

@Data
public class MovingAverageLoadServiceOutputBean {
	private String lastPeriod;
	private List<MOrganization> organizationList;
	private List<MovingAverage> movingAverageList;
	private String message;
}
