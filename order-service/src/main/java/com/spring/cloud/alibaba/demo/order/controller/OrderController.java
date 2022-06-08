package com.spring.cloud.alibaba.demo.order.controller;

import com.spring.cloud.alibaba.demo.order.msg.SendMessageService;
import com.spring.cloud.alibaba.demo.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private SendMessageService sendMessageService;

    /**
     * 测试分布式事物地址
     * localhost:9030/order/createOrder?shopId=shop1&shopNum=1
     * @param shopId
     * @param shopNum
     * @return
     */
    @GetMapping("/createOrder")
    public String minusStock(@RequestParam String shopId, @RequestParam int shopNum) {
        return orderService.createOrder(shopId, shopNum);
    }

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return sendMessageService.sendMessage();
    }


}
