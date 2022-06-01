package com.spring.cloud.alibaba.demo.user.service.feign;

import com.spring.cloud.alibaba.demo.user.service.fallback.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "${feignClient.orderServiceName}", fallback = OrderServiceFallback.class)
public interface OrderService {

    @GetMapping("/order/{val}")
    public String test(@PathVariable("val") String val);
}

