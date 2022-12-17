package com.yanti.inventorycontroll.domain.repository.aprioriassociation;

import com.yanti.inventorycontroll.domain.model.aprioriassociation.HAprioriAssociation;
import com.yanti.inventorycontroll.domain.model.aprioriassociation.HAprioriAssociationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HAprioriAssociationRepository {
    long countByCriteria(HAprioriAssociationCriteria criteria);

    int deleteByCriteria(HAprioriAssociationCriteria criteria);

    int deleteByPrimaryKey(Long aprioriAssociationId);

    int insert(HAprioriAssociation row);

    int insertSelective(HAprioriAssociation row);

    List<HAprioriAssociation> selectByCriteria(HAprioriAssociationCriteria criteria);

    HAprioriAssociation selectByPrimaryKey(Long aprioriAssociationId);

    int updateByCriteriaSelective(@Param("row") HAprioriAssociation row, @Param("example") HAprioriAssociationCriteria criteria);

    int updateByCriteria(@Param("row") HAprioriAssociation row, @Param("example") HAprioriAssociationCriteria criteria);

    int updateByPrimaryKeySelective(HAprioriAssociation row);

    int updateByPrimaryKey(HAprioriAssociation row);
}