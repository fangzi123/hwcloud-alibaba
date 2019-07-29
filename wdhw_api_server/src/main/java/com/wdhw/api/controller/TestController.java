package com.wdhw.api.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wdhw.api.feginclient.service.WebClient;
import com.wdhw.api.service.TestService;
import com.wdhw.api.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RefreshScope
@RestController
public class TestController {

    @Value("${testUrl:default}")
    private String testUrl;
    @Value("${testUrl1:default}")
    private String testUrl1;

    @Autowired
    private WebClient webClient;
    @Autowired
    private TestService testService;
    @GetMapping("/testapi")
    public String testapi(@RequestParam("param") String param){
        log.info("testUrl=={}",testUrl);
        log.info("testUrl1=={}",testUrl1);
        return param;
    }
    @GetMapping("/test")
    public String test(@RequestParam("param") String param){
        testService.test();
        return param;
    }

    @GetMapping("/testapi1")
    public String test1(@RequestParam("param") String param){
        return webClient.testapi(param);
    }

}
