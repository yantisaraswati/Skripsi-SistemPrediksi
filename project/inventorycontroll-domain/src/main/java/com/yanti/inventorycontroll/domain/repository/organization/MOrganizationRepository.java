package com.yanti.inventorycontroll.domain.repository.organization;

import com.yanti.inventorycontroll.domain.model.organization.MOrganization;
import com.yanti.inventorycontroll.domain.model.organization.MOrganizationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MOrganizationRepository {
    long countByCriteria(MOrganizationCriteria criteria);

    int deleteByCriteria(MOrganizationCriteria criteria);

    int deleteByPrimaryKey(Long organizationId);

    int insert(MOrganization row);

    int insertSelective(MOrganization row);

    List<MOrganization> selectByCriteria(MOrganizationCriteria criteria);

    MOrganization selectByPrimaryKey(Long organizationId);

    int updateByCriteriaSelective(@Param("row") MOrganization row, @Param("criteria") MOrganizationCriteria criteria);

    int updateByCriteria(@Param("row") MOrganization row, @Param("criteria") MOrganizationCriteria criteria);

    int updateByPrimaryKeySelective(MOrganization row);

    int updateByPrimaryKey(MOrganization row);
}