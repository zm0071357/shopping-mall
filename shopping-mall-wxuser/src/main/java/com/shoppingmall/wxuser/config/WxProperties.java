package com.shoppingmall.wxuser.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序配置文件
 */
@Component
@ConfigurationProperties(prefix = "weixin")
@Data
public class WxProperties {
    /**
     * 登录凭证校验请求地址
     */
    private String jscode2sessionUrl;

    /**
     * 小程序 Appid
     */
    private String appid;

    /**
     * 小程序 密钥
     */
    private String secret;
}
