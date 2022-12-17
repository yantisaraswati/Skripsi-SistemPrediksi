package com.yanti.inventorycontroll.domain.model.apriorisupport;

import java.util.Date;
import lombok.Data;

@Data
public class HAprioriSupport {
    private Long aprioriSupportId;

    private Long aprioriId;

    private Integer kItem;

    private Integer support;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;
}