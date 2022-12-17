package com.yanti.inventorycontroll.domain.repository.requestitem;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yanti.inventorycontroll.domain.dto.apriori.ItemTransaction;
import com.yanti.inventorycontroll.domain.model.requestitem.TRequestItem;
import com.yanti.inventorycontroll.domain.model.requestitem.TRequestItemCriteria;

public interface TRequestItemRepository {
    long countByCriteria(TRequestItemCriteria criteria);

    int deleteByCriteria(TRequestItemCriteria criteria);

    int deleteByPrimaryKey(Long requestItemId);

    int insert(TRequestItem row);

    int insertSelective(TRequestItem row);

    List<TRequestItem> selectByCriteria(TRequestItemCriteria criteria);

    TRequestItem selectByPrimaryKey(Long requestItemId);

    int updateByCriteriaSelective(@Param("row") TRequestItem row, @Param("criteria") TRequestItemCriteria criteria);

    int updateByCriteria(@Param("row") TRequestItem row, @Param("criteria") TRequestItemCriteria criteria);

    int updateByPrimaryKeySelective(TRequestItem row);

    int updateByPrimaryKey(TRequestItem row);
    
    List<ItemTransaction> selectAllItemTransaction(@Param("organizationId") Long organizationId);
}