package com.spring.cloud.alibaba.demo.stock.service;

public interface StockService {

    /**
     * 减库存
     * @param shopId 商品ID
     * @param shopNum 销售数量
     */
    public boolean minusStock(String shopId, int shopNum);
}
