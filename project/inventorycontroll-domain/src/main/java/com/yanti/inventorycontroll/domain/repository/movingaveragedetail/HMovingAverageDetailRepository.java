package com.yanti.inventorycontroll.domain.repository.movingaveragedetail;

import com.yanti.inventorycontroll.domain.model.movingaveragedetail.HMovingAverageDetail;
import com.yanti.inventorycontroll.domain.model.movingaveragedetail.HMovingAverageDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HMovingAverageDetailRepository {
    long countByCriteria(HMovingAverageDetailCriteria criteria);

    int deleteByCriteria(HMovingAverageDetailCriteria criteria);

    int deleteByPrimaryKey(Long movingAverageDetailId);

    int insert(HMovingAverageDetail row);

    int insertSelective(HMovingAverageDetail row);

    List<HMovingAverageDetail> selectByCriteria(HMovingAverageDetailCriteria criteria);

    HMovingAverageDetail selectByPrimaryKey(Long movingAverageDetailId);

    int updateByCriteriaSelective(@Param("row") HMovingAverageDetail row, @Param("example") HMovingAverageDetailCriteria criteria);

    int updateByCriteria(@Param("row") HMovingAverageDetail row, @Param("example") HMovingAverageDetailCriteria criteria);

    int updateByPrimaryKeySelective(HMovingAverageDetail row);

    int updateByPrimaryKey(HMovingAverageDetail row);
}