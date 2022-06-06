package com.spring.cloud.alibaba.demo.stock.service.impl;

import com.spring.cloud.alibaba.demo.stock.service.StockService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(rollbackFor = Exception.class)
public class StockServiceImpl implements StockService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean minusStock(String shopId, int shopNum) {
        int update = jdbcTemplate.update("UPDATE t_stock t set t.shop_num = (t.shop_num - " + shopNum + ") WHERE t.shop_id = ?",
                new Object[]{shopId});
//        try {
//            TimeUnit.SECONDS.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return update == 1;
    }
}
