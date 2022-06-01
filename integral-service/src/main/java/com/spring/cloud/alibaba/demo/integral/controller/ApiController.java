package com.spring.cloud.alibaba.demo.integral.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ApiController {

    @RequestMapping("/get")
    public String getConfig() {
        return "";
    }
}
