package com.yanti.inventorycontroll.domain.model.movingaveragedetail;

import java.util.Date;
import lombok.Data;

@Data
public class HMovingAverageDetail {
    private Long movingAverageDetailId;

    private Long movingAverageId;

    private String period;

    private Integer quantity;

    private Double forecast;

    private Double error;

    private Double errorAbsolute;

    private Double errorSquared;

    private Double errorPercentage;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;
}