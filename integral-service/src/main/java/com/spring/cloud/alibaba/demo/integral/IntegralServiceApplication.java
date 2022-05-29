package com.spring.cloud.alibaba.demo.integral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IntegralServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegralServiceApplication.class, args);
    }

}
