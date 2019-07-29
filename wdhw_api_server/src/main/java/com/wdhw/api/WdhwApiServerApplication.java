package com.wdhw.api;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.wdhw.api.config.CustomUrlBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
@Slf4j
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@SpringCloudApplication
public class WdhwApiServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WdhwApiServerApplication.class, args);
    }

    public void run(String... args) throws Exception {
        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
    }
}
