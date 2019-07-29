package com.wdhw.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class WdhwEurekaServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WdhwEurekaServerApplication.class);
	}

	public void run(String... args) {
		log.info("WdhwEurekaServerApplication started...");
	}

}