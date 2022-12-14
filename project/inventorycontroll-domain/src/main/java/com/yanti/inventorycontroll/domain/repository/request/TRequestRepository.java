package com.yanti.inventorycontroll.domain.repository.request;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.yanti.inventorycontroll.domain.dto.request.Request;
import com.yanti.inventorycontroll.domain.model.request.TRequest;
import com.yanti.inventorycontroll.domain.model.request.TRequestCriteria;

public interface TRequestRepository {
    long countByCriteria(TRequestCriteria criteria);

    int deleteByCriteria(TRequestCriteria criteria);

    int deleteByPrimaryKey(Long requestId);

    int insert(TRequest row);

    int insertSelective(TRequest row);

    List<TRequest> selectByCriteria(TRequestCriteria criteria);
    List<TRequest> selectByCriteria(TRequestCriteria criteria, RowBounds rowBound);
    
    TRequest selectByPrimaryKey(Long requestId);

    int updateByCriteriaSelective(@Param("row") TRequest row, @Param("criteria") TRequestCriteria criteria);

    int updateByCriteria(@Param("row") TRequest row, @Param("criteria") TRequestCriteria criteria);

    int updateByPrimaryKeySelective(TRequest row);

    int updateByPrimaryKey(TRequest row);

	List<Request> selectAllRequestDetail(@Param("requestIds") List<Long> requestIds);
}