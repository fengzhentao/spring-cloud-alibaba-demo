package com.spring.cloud.alibaba.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class UserServiceApplication {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @GetMapping("/user/{val}")
    public String test(@PathVariable("val") String val) {
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://order-service/order/1", String.class);
//        val = forEntity.getBody();
        val = orderService.test(val);
        return "user-service=" + val;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}

@FeignClient(name = "order-service", fallback = OrderServiceFallback.class, configuration = FeignConfiguration.class)
interface OrderService {

    @GetMapping("/order/{val}")
    String test(@PathVariable("val") String val);
}

class FeignConfiguration {

    @Bean
    public OrderServiceFallback orderServiceFallback() {
        return new OrderServiceFallback();
    }

}

class OrderServiceFallback implements OrderService {

    @Override
    public String test(@PathVariable("val") String val) {
        return "order-service fail";
    }
}
