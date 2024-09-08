package com.shoppingmall.gateway.config;

import cn.dev33.satoken.same.SaSameUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Same-Token默认的自刷新机制，不能做到高并发可用，需要定时刷新
 */
@Configuration
@Slf4j
public class SaSameTokenRefreshTask {

    @ApiOperation("每五分钟刷新一次")
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void refreshToken(){
        SaSameUtil.refreshToken();
        log.info("Same-Token刷新");
    }
}
