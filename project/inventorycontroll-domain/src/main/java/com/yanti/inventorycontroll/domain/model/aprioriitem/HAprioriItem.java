package com.yanti.inventorycontroll.domain.model.aprioriitem;

import java.util.Date;

public class HAprioriItem {
    private Long aprioriItemId;

    private Long aprioriId;

    private Long itemId;

    private Long createdBy;

    private Date createdDate;

    private Long updatedBy;

    private Date updatedDate;

    public Long getAprioriItemId() {
        return aprioriItemId;
    }

    public void setAprioriItemId(Long aprioriItemId) {
        this.aprioriItemId = aprioriItemId;
    }

    public Long getAprioriId() {
        return aprioriId;
    }

    public void setAprioriId(Long aprioriId) {
        this.aprioriId = aprioriId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}