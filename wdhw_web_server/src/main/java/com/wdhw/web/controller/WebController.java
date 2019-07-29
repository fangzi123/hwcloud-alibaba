package com.wdhw.web.controller;

import com.wdhw.web.feginclient.service.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private ApiClient apiClient;

    @GetMapping("/webapi")
    public String test(@RequestParam(value = "param") String param) {
        return apiClient.testapi(param);
    }
}
