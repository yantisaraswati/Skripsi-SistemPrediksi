package com.yanti.inventorycontroll.domain.repository.apriorisupportitem;

import com.yanti.inventorycontroll.domain.model.apriorisupportitem.HAprioriSupportItem;
import com.yanti.inventorycontroll.domain.model.apriorisupportitem.HAprioriSupportItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HAprioriSupportItemRepository {
    long countByCriteria(HAprioriSupportItemCriteria criteria);

    int deleteByCriteria(HAprioriSupportItemCriteria criteria);

    int deleteByPrimaryKey(Long aprioriSupportItemId);

    int insert(HAprioriSupportItem row);

    int insertSelective(HAprioriSupportItem row);

    List<HAprioriSupportItem> selectByCriteria(HAprioriSupportItemCriteria criteria);

    HAprioriSupportItem selectByPrimaryKey(Long aprioriSupportItemId);

    int updateByCriteriaSelective(@Param("row") HAprioriSupportItem row, @Param("example") HAprioriSupportItemCriteria criteria);

    int updateByCriteria(@Param("row") HAprioriSupportItem row, @Param("example") HAprioriSupportItemCriteria criteria);

    int updateByPrimaryKeySelective(HAprioriSupportItem row);

    int updateByPrimaryKey(HAprioriSupportItem row);
}