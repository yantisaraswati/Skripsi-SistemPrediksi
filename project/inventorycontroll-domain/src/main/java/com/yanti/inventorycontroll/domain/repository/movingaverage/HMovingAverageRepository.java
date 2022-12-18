package com.yanti.inventorycontroll.domain.repository.movingaverage;

import com.yanti.inventorycontroll.domain.dto.movingaverage.MovingAverage;
import com.yanti.inventorycontroll.domain.model.movingaverage.HMovingAverage;
import com.yanti.inventorycontroll.domain.model.movingaverage.HMovingAverageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HMovingAverageRepository {
    long countByCriteria(HMovingAverageCriteria criteria);

    int deleteByCriteria(HMovingAverageCriteria criteria);

    int deleteByPrimaryKey(Long movingAverageId);

    int insert(HMovingAverage row);

    int insertSelective(HMovingAverage row);

    List<HMovingAverage> selectByCriteria(HMovingAverageCriteria criteria);

    HMovingAverage selectByPrimaryKey(Long movingAverageId);

    int updateByCriteriaSelective(@Param("row") HMovingAverage row, @Param("example") HMovingAverageCriteria criteria);

    int updateByCriteria(@Param("row") HMovingAverage row, @Param("example") HMovingAverageCriteria criteria);

    int updateByPrimaryKeySelective(HMovingAverage row);

    int updateByPrimaryKey(HMovingAverage row);

	List<MovingAverage> selectMovingAverageResult(@Param("organizationId") Long organizationId, @Param("timeFrame") Integer timeFrame, @Param("period") String currentPeriod);
}