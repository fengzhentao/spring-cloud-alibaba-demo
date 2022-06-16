package com.spring.cloud.alibaba.demo.order.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XxlJobConfig {

    @Bean
    public XxlJobSpringExecutor xxlJobSpringExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses("http://127.0.0.1:8080/xxl-job-admin");
        xxlJobSpringExecutor.setAppname("xxl-job-executor-sample");
//        xxlJobSpringExecutor.setIp("127.0.0.1");
        xxlJobSpringExecutor.setPort(9031);
////        xxlJobSpringExecutor.setAccessToken("");
        xxlJobSpringExecutor.setLogPath("/Users/wf/springCloudAlibaba/spring-cloud-alibaba-demo/order-service/logs");
//        xxlJobSpringExecutor.setLogRetentionDays(1);
        return xxlJobSpringExecutor;
    }
}
