package com.yanti.inventorycontroll.domain.model.movingaverage;

import java.util.Date;
import lombok.Data;

@Data
public class HMovingAverage {
    private Long movingAverageId;

    private Long organizationId;

    private Long itemId;

    private String period;

    private Integer nMonth;

    private Double forecast;

    private Double mae;

    private Double mse;

    private Double mape;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;
}