package com.yanti.inventorycontroll.domain.repository.apriori;

import com.yanti.inventorycontroll.domain.model.apriori.HApriori;
import com.yanti.inventorycontroll.domain.model.apriori.HAprioriCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HAprioriRepository {
    long countByCriteria(HAprioriCriteria criteria);

    int deleteByCriteria(HAprioriCriteria criteria);

    int deleteByPrimaryKey(Long aprioriId);

    int insert(HApriori row);

    int insertSelective(HApriori row);

    List<HApriori> selectByCriteria(HAprioriCriteria criteria);

    HApriori selectByPrimaryKey(Long aprioriId);

    int updateByCriteriaSelective(@Param("row") HApriori row, @Param("example") HAprioriCriteria criteria);

    int updateByCriteria(@Param("row") HApriori row, @Param("example") HAprioriCriteria criteria);

    int updateByPrimaryKeySelective(HApriori row);

    int updateByPrimaryKey(HApriori row);
}