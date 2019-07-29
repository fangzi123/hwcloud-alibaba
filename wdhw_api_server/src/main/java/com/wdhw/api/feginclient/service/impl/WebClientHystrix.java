package com.wdhw.api.feginclient.service.impl;

import com.wdhw.api.feginclient.service.WebClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class WebClientHystrix implements WebClient {

    public String testapi(@RequestParam(value = "param") String param){
        return "熔断web";
    }

}
