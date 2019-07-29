package com.wdhw.web.feginclient.service.impl;

import com.wdhw.web.feginclient.service.ApiClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class ApiClientHystrix implements ApiClient {

    public String testapi(@RequestParam(value = "param") String param){
        return "熔断API";
    }

}
