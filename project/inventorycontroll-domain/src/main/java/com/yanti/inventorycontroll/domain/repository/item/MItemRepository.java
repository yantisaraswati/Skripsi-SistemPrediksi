package com.yanti.inventorycontroll.domain.repository.item;

import com.yanti.inventorycontroll.domain.dto.item.Item;
import com.yanti.inventorycontroll.domain.model.item.MItem;
import com.yanti.inventorycontroll.domain.model.item.MItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MItemRepository {
    long countByCriteria(MItemCriteria criteria);

    int deleteByCriteria(MItemCriteria criteria);

    int deleteByPrimaryKey(Long itemId);

    int insert(MItem row);

    int insertSelective(MItem row);

    List<MItem> selectByCriteria(MItemCriteria criteria);

    MItem selectByPrimaryKey(Long itemId);

    int updateByCriteriaSelective(@Param("row") MItem row, @Param("criteria") MItemCriteria criteria);

    int updateByCriteria(@Param("row") MItem row, @Param("criteria") MItemCriteria criteria);

    int updateByPrimaryKeySelective(MItem row);

    int updateByPrimaryKey(MItem row);

	List<Item> selectAllItemDetail(RowBounds rowBound);
}