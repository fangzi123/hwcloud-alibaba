package com.wdhw.api.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yang on 2017/1/9.
 */
public class AccessFilter  extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
//    pre：可以在请求被路由之前调用
//    routing：在路由请求时候被调用
//    post：在routing和error过滤器之后被调用
//    error：处理请求时发生错误时被调用
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        return null;
    }
}