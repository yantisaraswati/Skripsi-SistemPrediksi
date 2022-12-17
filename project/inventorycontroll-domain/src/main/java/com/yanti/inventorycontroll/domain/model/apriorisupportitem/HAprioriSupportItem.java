package com.yanti.inventorycontroll.domain.model.apriorisupportitem;

import java.util.Date;
import lombok.Data;

@Data
public class HAprioriSupportItem {
    private Long aprioriSupportItemId;

    private Long aprioriSupportId;

    private Long itemId;

    private Integer seq;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;
}