package com.wdhw.api.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class CustomUrlBlockHandler implements UrlBlockHandler {

    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("message","Blocked by Sentinel (flow limiting)");
        log.info(json.toJSONString());

        PrintWriter out = httpServletResponse.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
