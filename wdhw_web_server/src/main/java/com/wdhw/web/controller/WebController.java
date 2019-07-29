package com.wdhw.web.controller;

import com.wdhw.web.feginclient.service.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private ApiClient apiClient;

    @GetMapping("/webapi")
    public String test(@RequestParam(value = "param") String param) {
        return apiClient.testapi(param);
    }



    @GetMapping("/test")
    public String test() {
        String result = restTemplate.getForObject("http://wdhw-api-server/testapi?param=didi", String.class);
        return "Return : " + result;
    }

    @GetMapping("/testF")
    public String testF() {
        String result = apiClient.testapi("fegin");
        return "Return testF: " + result;
    }
}
