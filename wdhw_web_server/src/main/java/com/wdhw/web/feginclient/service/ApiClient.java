package com.wdhw.web.feginclient.service;

import com.wdhw.web.feginclient.service.impl.ApiClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "wdhw-api-server", fallback = ApiClientHystrix.class)
public interface ApiClient {

    @GetMapping(value = "/testapi")
    String testapi(@RequestParam(value = "param") String param);

}
