package com.entity;

import java.math.BigDecimal;

public class Goods {
    private BigDecimal goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    public BigDecimal getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigDecimal goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}