package com.yanti.inventorycontroll.domain.repository.businessparameter;

import com.yanti.inventorycontroll.domain.dto.parameter.Parameter;
import com.yanti.inventorycontroll.domain.model.businessparameter.MBusinessParameter;
import com.yanti.inventorycontroll.domain.model.businessparameter.MBusinessParameterCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MBusinessParameterRepository {
    long countByCriteria(MBusinessParameterCriteria criteria);

    int deleteByCriteria(MBusinessParameterCriteria criteria);

    int deleteByPrimaryKey(Long businessParameterId);

    int insert(MBusinessParameter row);

    int insertSelective(MBusinessParameter row);

    List<MBusinessParameter> selectByCriteria(MBusinessParameterCriteria criteria);

    MBusinessParameter selectByPrimaryKey(Long businessParameterId);

    int updateByCriteriaSelective(@Param("row") MBusinessParameter row, @Param("criteria") MBusinessParameterCriteria criteria);

    int updateByCriteria(@Param("row") MBusinessParameter row, @Param("criteria") MBusinessParameterCriteria criteria);

    int updateByPrimaryKeySelective(MBusinessParameter row);

    int updateByPrimaryKey(MBusinessParameter row);

	List<Parameter> selectParameterDetail(@Param("category") String category, RowBounds rowBound);
}