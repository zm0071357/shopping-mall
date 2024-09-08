package com.shoppingmall.wxuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.shoppingmall")   // 扫描组件
@MapperScan("com.shoppingmall.wxuser.mapper")
@SpringBootApplication
public class ShoppingMallWxUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallWxUserApplication.class, args);
    }
}
