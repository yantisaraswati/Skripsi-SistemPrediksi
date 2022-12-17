package com.yanti.inventorycontroll.domain.repository.apriorisupport;

import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupport;
import com.yanti.inventorycontroll.domain.model.apriorisupport.HAprioriSupportCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HAprioriSupportRepository {
    long countByCriteria(HAprioriSupportCriteria criteria);

    int deleteByCriteria(HAprioriSupportCriteria criteria);

    int deleteByPrimaryKey(Long aprioriSupportId);

    int insert(HAprioriSupport row);

    int insertSelective(HAprioriSupport row);

    List<HAprioriSupport> selectByCriteria(HAprioriSupportCriteria criteria);

    HAprioriSupport selectByPrimaryKey(Long aprioriSupportId);

    int updateByCriteriaSelective(@Param("row") HAprioriSupport row, @Param("example") HAprioriSupportCriteria criteria);

    int updateByCriteria(@Param("row") HAprioriSupport row, @Param("example") HAprioriSupportCriteria criteria);

    int updateByPrimaryKeySelective(HAprioriSupport row);

    int updateByPrimaryKey(HAprioriSupport row);
}