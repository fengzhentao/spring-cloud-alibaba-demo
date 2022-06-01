package com.spring.cloud.alibaba.demo.logistics.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: Mr.FZT
 * @create: 2022-05-31
 **/
@FeignClient("user-service")
public interface UserService {

    @GetMapping("/user")
    public String user(@RequestParam String val);
}
