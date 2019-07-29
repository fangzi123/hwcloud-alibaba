package com.wdhw.api.feginclient.service;

import com.wdhw.api.feginclient.service.impl.WebClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "wdhw-web-server", fallback = WebClientHystrix.class)
public interface WebClient {

    @GetMapping(value = "/webapi")
    String testapi(@RequestParam(value = "param") String param);

}
