package com.wdhw.api.filter;

import com.netflix.zuul.context.RequestContext;
import com.wdhw.api.common.ApiResult;
import com.wdhw.api.common.CommonCode;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

/**
 * Created by admin on 2017/3/9.
 */
public class MySendErrorFilter extends SendErrorFilter {
    private static Logger log = LoggerFactory.getLogger(MySendErrorFilter.class);

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return (ctx.containsKey("error.status_code")
                && !ctx.getBoolean("sendErrorFilter.ran", false))
                || "404".equals(ctx.get("responseStatusCode").toString());
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            if (ctx.getResponseStatusCode() != 200) {
                log.error("responseStatusCode:{},exception:{}", ctx.getResponseStatusCode(), ExceptionUtils.getFullStackTrace((Exception) ctx.get("error.exception")));
                ApiResult result = new ApiResult(CommonCode.ERROR);
                if(ctx.getResponseStatusCode() == 404){
                    result.setMsg("url error 404");
                }else{
                    result.setMsg("error");
                }
                ctx.setSendZuulResponse(false);
                ctx.setResponseBody(result.toString());
                return "";
            }
        }catch (Exception e){
            log.error("MySendErrorFilter run method cause an exception!");
        }
        return null;
    }
}
