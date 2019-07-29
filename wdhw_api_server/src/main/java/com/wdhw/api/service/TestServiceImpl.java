package com.wdhw.api.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wdhw.api.util.ExceptionUtil;
import org.springframework.stereotype.Service;

/**
 * @author wangff
 * @date 2019/7/23 16:49
 */
@Service
public class TestServiceImpl implements TestService {
    @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public void test() {

    }
}
