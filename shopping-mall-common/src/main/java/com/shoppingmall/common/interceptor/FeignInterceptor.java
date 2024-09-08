package com.shoppingmall.common.interceptor;

import cn.dev33.satoken.same.SaSameUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * feign拦截器, 在feign请求发出之前添加请求头Same-Token
 * 在一个服务调用另一个服务的接口，也需要添加Same-Token作为身份凭证
 */
@Component
@Slf4j
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("当前用户的Same-Token:{}",SaSameUtil.getToken());
        requestTemplate.header(SaSameUtil.SAME_TOKEN, SaSameUtil.getToken());
        // 如果希望被调用方有会话状态，此处就还需要将 satoken 添加到请求头中
        // requestTemplate.header(StpUtil.getTokenName(), StpUtil.getTokenValue());
    }
}

