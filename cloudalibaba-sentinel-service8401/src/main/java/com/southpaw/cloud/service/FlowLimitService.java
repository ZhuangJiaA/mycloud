package com.southpaw.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @auther zzyy
 * @create 2023-05-26 18:40
 */
@Service
public class FlowLimitService {
    @SentinelResource(value = "southpaw")
    public void common() {
        System.out.println("------FlowLimitService come in");
    }
}