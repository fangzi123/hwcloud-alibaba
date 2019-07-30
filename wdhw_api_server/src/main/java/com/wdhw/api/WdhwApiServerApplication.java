package com.wdhw.api;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.wdhw.api.config.CustomUrlBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class WdhwApiServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WdhwApiServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
    }
}
