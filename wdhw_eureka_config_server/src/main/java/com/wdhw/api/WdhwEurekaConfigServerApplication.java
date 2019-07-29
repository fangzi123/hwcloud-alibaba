package com.wdhw.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by yang on 2017/1/9.
 */
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class WdhwEurekaConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WdhwEurekaConfigServerApplication.class);
    }
}
