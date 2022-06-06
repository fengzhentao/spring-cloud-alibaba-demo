package com.spring.cloud.alibaba.demo.order.service.impl;

import com.spring.cloud.alibaba.demo.order.service.OrderService;
import com.spring.cloud.alibaba.demo.order.service.clients.StockFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private StockFeign stockFeign;

    @Override
    @GlobalTransactional
    public String createOrder(String shopId, int shopNum) {
        String orderId = UUID.randomUUID().toString();
        int update = jdbcTemplate.update("INSERT INTO `t_order`(`order_id`, `shop_id`) VALUES ( ?, ?)", new Object[]{orderId, shopId});
        if (update == 1) {
            String s = stockFeign.minusStock(shopId, shopNum);
            System.out.println(s);
            return orderId;
        }
        return "生成订单失败";
    }
}
