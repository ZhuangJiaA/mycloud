package com.southpaw.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.southpaw.cloud.mapper")
public class PaymentMain {
    public static void main(String[] args)
    {
        SpringApplication.run(PaymentMain.class,args);
    }
}