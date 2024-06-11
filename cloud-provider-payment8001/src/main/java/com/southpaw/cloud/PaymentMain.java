package com.southpaw.cloud;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.southpaw.cloud.mapper")
@EnableDiscoveryClient //服务注册和发现
@RefreshScope // 动态刷新
public class PaymentMain {
    public static void main(String[] args)
    {
        SpringApplication.run(PaymentMain.class,args);
    }
}