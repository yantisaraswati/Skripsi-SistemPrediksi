package com.yanti.inventorycontroll.domain.repository.requestitem;

import com.yanti.inventorycontroll.domain.model.requestitem.TRequestItem;
import com.yanti.inventorycontroll.domain.model.requestitem.TRequestItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}