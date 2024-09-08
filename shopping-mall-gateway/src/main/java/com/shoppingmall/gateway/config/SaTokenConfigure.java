package com.shoppingmall.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


/**
 * 全局过滤器 配置各模块的权限认证
 */
@Configuration
public class SaTokenConfigure {

    @Bean
    public SaReactorFilter getSaReactorFilter() {
        // 注册 Sa-Token全局过滤器
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                // 开放地址
                .addExclude("/wxuser")
                // 鉴权方法，每次访问进入
                .setAuth(obj -> {
                    // 拦截所有路由 除了微信用户登录
                    SaRouter.match("/**", "/wxuser/login", r -> StpUtil.checkLogin());
                    // 权限认证
                    SaRouter.match("/commodity/**", r -> StpUtil.checkRoleOr("common","admin"));
                    SaRouter.match("/comment/**", r -> StpUtil.checkRoleOr("common","admin"));
                    SaRouter.match("/type/**", r -> StpUtil.checkRoleOr("common","admin"));
                })
                // 异常处理
                .setError(e -> SaResult.error(e.getMessage()));
    }
}
