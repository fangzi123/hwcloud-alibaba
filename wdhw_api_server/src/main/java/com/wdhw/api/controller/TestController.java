package com.wdhw.api.controller;

import com.wdhw.api.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RefreshScope
@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @GetMapping("/testapi")
    public String testapi(@RequestParam("param") String param){
        return param;
    }
    @GetMapping("/test")
    public String test(@RequestParam("param") String param){
        testService.test();
        return param;
    }

}
