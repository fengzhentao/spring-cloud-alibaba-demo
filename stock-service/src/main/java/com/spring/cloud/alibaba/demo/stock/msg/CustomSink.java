package com.spring.cloud.alibaba.demo.stock.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomSink {

    @Input("inputChannel")
    SubscribableChannel inputChannel();
}
