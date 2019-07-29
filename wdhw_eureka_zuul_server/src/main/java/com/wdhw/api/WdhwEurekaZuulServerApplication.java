
package com.wdhw.api;

import com.wdhw.api.filter.BeforeRequestFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@ComponentScan(basePackages = "com.wdhw")
@EnableAspectJAutoProxy
@RefreshScope
@EnableZuulProxy
@SpringCloudApplication
public class WdhwEurekaZuulServerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(WdhwEurekaZuulServerApplication.class);
    }

    public void run(String... args) {
        log.info("WdhwEurekaServerApplication started...");
    }
    /*
    请求前拦截，检查Token信息
     */
    /*@Bean
    public BeforeRequestFilter beforeRequestFilter() {
        return new BeforeRequestFilter();
    }*/
    /*
    请求后，对数据进行jsonP输出
     */
 /*   @Bean
    public EndRequestFilter endRequestFilter(){
        return new EndRequestFilter();
    }*/
}
