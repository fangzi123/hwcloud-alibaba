package com.wdhw.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringCloudApplication
@EnableHystrixDashboard
@EnableTurbine
@EnableHystrix
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}