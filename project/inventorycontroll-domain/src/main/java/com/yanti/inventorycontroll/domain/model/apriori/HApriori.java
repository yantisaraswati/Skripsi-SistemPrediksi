package com.yanti.inventorycontroll.domain.model.apriori;

import java.util.Date;
import lombok.Data;

@Data
public class HApriori {
    private Long aprioriId;

    private Long organizationId;

    private Integer minSupport;

    private Integer minConfidence;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;
}