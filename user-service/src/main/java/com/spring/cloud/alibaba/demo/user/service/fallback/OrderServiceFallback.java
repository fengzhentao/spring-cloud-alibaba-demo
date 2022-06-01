package com.spring.cloud.alibaba.demo.user.service.fallback;

import com.spring.cloud.alibaba.demo.user.service.feign.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallback implements OrderService {

    @Override
    public String test(String val) {
        return "订单降级方法";
    }
}
