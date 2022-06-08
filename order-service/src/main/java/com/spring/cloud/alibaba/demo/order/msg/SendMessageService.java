package com.spring.cloud.alibaba.demo.order.msg;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SendMessageService {

    @Resource
    private CustomSource customSource;

    public String sendMessage() {
        String payload = "order-rocketMq-message";
        customSource.outputChannel().send(MessageBuilder.withPayload(payload).build());
        return payload;
    }
}
