package com.shoppingmall.type;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.shoppingmall.type.mapper")
@SpringBootApplication
public class ShoppingMallTypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallTypeApplication.class, args);
    }

}
