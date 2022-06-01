package com.spring.cloud.alibaba.demo.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.spring.cloud.alibaba.demo.user.service.feign.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @SentinelResource注解使用帮助文档
 * https://blog.csdn.net/zhang33565417/article/details/122788422
 */
@RestController
public class ApiController {

    private static final String ORDER_SERVICE_URL = "http://order-service/order/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderService orderService;

    @GetMapping("/user")
    @SentinelResource(value = "user" , blockHandler = "blockHandlerTest")
    public String user(@RequestParam String val) {
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(ORDER_SERVICE_URL + val, String.class);
        String test = orderService.test(val);
        return "user-service=" + test;
    }

    public String blockHandlerTest(String val, BlockException blockException) {
        return "user-service blockHandlerTest error=" + blockException.getMessage();
    }
}
