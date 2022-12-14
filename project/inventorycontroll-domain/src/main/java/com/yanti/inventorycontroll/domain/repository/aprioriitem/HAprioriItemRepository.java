package com.yanti.inventorycontroll.domain.repository.aprioriitem;

import com.yanti.inventorycontroll.domain.model.aprioriitem.HAprioriItem;
import com.yanti.inventorycontroll.domain.model.aprioriitem.HAprioriItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HAprioriItemRepository {
    long countByCriteria(HAprioriItemCriteria criteria);

    int deleteByCriteria(HAprioriItemCriteria criteria);

    int deleteByPrimaryKey(Long aprioriItemId);

    int insert(HAprioriItem row);

    int insertSelective(HAprioriItem row);

    List<HAprioriItem> selectByCriteria(HAprioriItemCriteria criteria);

    HAprioriItem selectByPrimaryKey(Long aprioriItemId);

    int updateByCriteriaSelective(@Param("row") HAprioriItem row, @Param("criteria") HAprioriItemCriteria criteria);

    int updateByCriteria(@Param("row") HAprioriItem row, @Param("criteria") HAprioriItemCriteria criteria);

    int updateByPrimaryKeySelective(HAprioriItem row);

    int updateByPrimaryKey(HAprioriItem row);
}