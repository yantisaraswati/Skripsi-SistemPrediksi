package com.yanti.inventorycontroll.domain.repository.user;

import com.yanti.inventorycontroll.domain.model.user.MUser;
import com.yanti.inventorycontroll.domain.model.user.MUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MUserRepository {
    long countByCriteria(MUserCriteria criteria);

    int deleteByCriteria(MUserCriteria criteria);

    int deleteByPrimaryKey(Long userId);

    int insert(MUser row);

    int insertSelective(MUser row);

    List<MUser> selectByCriteria(MUserCriteria criteria);

    MUser selectByPrimaryKey(Long userId);

    int updateByCriteriaSelective(@Param("row") MUser row, @Param("criteria") MUserCriteria criteria);

    int updateByCriteria(@Param("row") MUser row, @Param("criteria") MUserCriteria criteria);

    int updateByPrimaryKeySelective(MUser row);

    int updateByPrimaryKey(MUser row);
    
    MUser findOneByUsername(@Param("username") String username);
}