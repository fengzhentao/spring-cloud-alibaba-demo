package com.spring.cloud.alibaba.demo.logistics.controller;

import com.spring.cloud.alibaba.demo.logistics.feigns.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2022-05-31
 **/
@RestController
public class ApiController {

    @Resource
    private UserService userService;

    @GetMapping("/logistics")
    public String logistics() {
        return userService.user("1");
    }
}
