package com.spring.cloud.alibaba.demo.order.service;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2022-06-02
 **/
public interface OrderService {

    /**
     * 生成订单
     * @param shopId 商品ID
     * @param shopNum 商品数量
     */
    public String createOrder(String shopId, int shopNum);
}
