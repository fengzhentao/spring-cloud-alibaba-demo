package com.spring.cloud.alibaba.demo.stock.controller;

import com.spring.cloud.alibaba.demo.stock.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockService stockService;

    @GetMapping("/minusStock")
    public String minusStock(@RequestParam String shopId, @RequestParam int shopNum) {
        boolean b = stockService.minusStock(shopId, shopNum);
        if (b) {
            return "扣除库存成功";
        }
        return "扣除库存失败";
    }
}
