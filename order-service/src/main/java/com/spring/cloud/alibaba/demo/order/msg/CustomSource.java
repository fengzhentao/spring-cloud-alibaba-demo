package com.spring.cloud.alibaba.demo.order.msg;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {

    @Output("outputChannel")
    MessageChannel outputChannel();
}
