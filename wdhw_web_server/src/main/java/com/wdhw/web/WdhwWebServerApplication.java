package com.wdhw.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@SpringCloudApplication
public class WdhwWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WdhwWebServerApplication.class, args);
    }

}
