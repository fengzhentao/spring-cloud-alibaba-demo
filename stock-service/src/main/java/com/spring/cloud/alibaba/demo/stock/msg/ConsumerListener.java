package com.spring.cloud.alibaba.demo.stock.msg;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @StreamListener("inputChannel")
    public void inputConsumer(String message) {
        System.out.println("stock result message: " + message);
    }

    @StreamListener("inputChannel")
    public void inputConsumerMessage(Message<String> message) {
        System.out.println(message.toString());
    }
}
