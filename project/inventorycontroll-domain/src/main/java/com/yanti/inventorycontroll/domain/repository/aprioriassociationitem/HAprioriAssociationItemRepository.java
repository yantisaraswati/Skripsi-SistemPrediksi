package com.yanti.inventorycontroll.domain.repository.aprioriassociationitem;

import com.yanti.inventorycontroll.domain.model.aprioriassociationitem.HAprioriAssociationItem;
import com.yanti.inventorycontroll.domain.model.aprioriassociationitem.HAprioriAssociationItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HAprioriAssociationItemRepository {
    long countByCriteria(HAprioriAssociationItemCriteria criteria);

    int deleteByCriteria(HAprioriAssociationItemCriteria criteria);

    int deleteByPrimaryKey(Long aprioriAssociationItemId);

    int insert(HAprioriAssociationItem row);

    int insertSelective(HAprioriAssociationItem row);

    List<HAprioriAssociationItem> selectByCriteria(HAprioriAssociationItemCriteria criteria);

    HAprioriAssociationItem selectByPrimaryKey(Long aprioriAssociationItemId);

    int updateByCriteriaSelective(@Param("row") HAprioriAssociationItem row, @Param("example") HAprioriAssociationItemCriteria criteria);

    int updateByCriteria(@Param("row") HAprioriAssociationItem row, @Param("example") HAprioriAssociationItemCriteria criteria);

    int updateByPrimaryKeySelective(HAprioriAssociationItem row);

    int updateByPrimaryKey(HAprioriAssociationItem row);

	List<Long> selectProcessedItem(@Param("organizationId") Long organizationId);
}