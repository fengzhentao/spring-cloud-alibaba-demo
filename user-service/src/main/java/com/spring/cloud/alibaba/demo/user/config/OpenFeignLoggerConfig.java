package com.spring.cloud.alibaba.demo.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignLoggerConfig {

    @Bean
    public Logger.Level openFeignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
