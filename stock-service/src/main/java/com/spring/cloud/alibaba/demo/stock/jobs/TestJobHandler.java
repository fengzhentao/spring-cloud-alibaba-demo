package com.spring.cloud.alibaba.demo.stock.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.util.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class TestJobHandler {

    @XxlJob("sampleJobHandler")
    public ReturnT<String> sampleJobHandler(String param) {
        log.info("sampleJobHandler hello world");
        return ReturnT.SUCCESS;
    }

    // 模拟数据库
    private final List<Integer> agentList = new ArrayList<>();

    public TestJobHandler() {
        for (int i = 0; i < 6; i++) {
            agentList.add(i+1);
        }
    }

    @XxlJob("shardingJobHandler")
    public ReturnT<String> shardingJobHandler(String param) {
        ShardingUtil.ShardingVO shardingVo = ShardingUtil.getShardingVo();
        log.info("分片参数：当前分片序号 = {} , 总分片数 = {}", shardingVo.getIndex(), shardingVo.getTotal());
        for (Integer integer : agentList) {
            if (integer % shardingVo.getTotal() == shardingVo.getIndex()) {
                log.info("第 {} 片，命中分片开始处理 {}", shardingVo.getIndex(), integer);
            }
        }
        return ReturnT.SUCCESS;
    }
}
