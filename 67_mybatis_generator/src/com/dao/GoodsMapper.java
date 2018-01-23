package com.dao;

import com.entity.Goods;
import java.math.BigDecimal;

public interface GoodsMapper {
    int deleteByPrimaryKey(BigDecimal goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(BigDecimal goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}