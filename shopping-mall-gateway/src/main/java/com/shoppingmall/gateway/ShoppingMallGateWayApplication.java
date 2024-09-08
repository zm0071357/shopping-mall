package com.shoppingmall.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shoppingmall.gateway.mapper")
public class ShoppingMallGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallGateWayApplication.class, args);
    }
}
