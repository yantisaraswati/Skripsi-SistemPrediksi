package com.yanti.inventorycontroll.domain.model.aprioriassociationitem;

import java.util.Date;
import lombok.Data;

@Data
public class HAprioriAssociationItem {
    private Long aprioriAssociationItemId;

    private Long aprioriAssociationId;

    private Long itemId;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;
}