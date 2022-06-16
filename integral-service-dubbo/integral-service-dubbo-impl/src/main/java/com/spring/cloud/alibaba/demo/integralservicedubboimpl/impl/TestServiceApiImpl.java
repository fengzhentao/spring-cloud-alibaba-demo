package com.spring.cloud.alibaba.demo.integralservicedubboimpl.impl;

import com.spring.cloud.alibaba.demo.integralservicedubboapi.api.TestServiceApi;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestServiceApiImpl implements TestServiceApi {

    @Override
    public String dubboTest(String message) {
        return "我是服务提供者，已收到您的消息：" + message;
    }
}
