package com.yanti.inventorycontroll.domain.model.aprioriassociation;

import java.util.Date;
import lombok.Data;

@Data
public class HAprioriAssociation {
    private Long aprioriAssociationId;

    private Long aprioriId;

    private String rules;

    private Integer support;

    private Integer confidence;

    private Integer supportConfidence;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;
}