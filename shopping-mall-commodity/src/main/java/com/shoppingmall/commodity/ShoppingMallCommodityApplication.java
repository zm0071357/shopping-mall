package com.shoppingmall.commodity;

import com.shoppingmall.common.config.FeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@MapperScan("com.shoppingmall.commodity.mapper")
@EnableFeignClients(value = "com.shoppingmall.type.client",defaultConfiguration = FeignConfig.class)   //声明要用的FeignClient
public class ShoppingMallCommodityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallCommodityApplication.class, args);
    }
}