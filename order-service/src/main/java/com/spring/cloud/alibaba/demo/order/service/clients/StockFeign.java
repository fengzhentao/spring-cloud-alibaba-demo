package com.spring.cloud.alibaba.demo.order.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "stock-service")
public interface StockFeign {

    @GetMapping("/stock/minusStock")
    public String minusStock(@RequestParam String shopId, @RequestParam int shopNum);
}
