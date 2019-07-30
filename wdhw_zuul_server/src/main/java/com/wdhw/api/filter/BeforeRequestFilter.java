package com.wdhw.api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.wdhw.api.common.ApiResult;
import com.wdhw.api.common.CommonCode;
import com.wdhw.api.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yang on 2017/1/9.
 */
public class BeforeRequestFilter extends ZuulFilter {



    final  String DEFALT_TOEKN="5d81db99484c0019cab240b3d04e9a4a";
    private static Logger log = LoggerFactory.getLogger(BeforeRequestFilter.class);
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object app_id = request.getParameter("app_id");
        if(StringUtil.IsNullOrEmpty(app_id)) {
            log.warn("app_id is empty");
            ctx.setSendZuulResponse(false);
            ApiResult result=new ApiResult(CommonCode.ERROR);
            result.setCodeMsg(CommonCode.PARAMETER_LOSE);
            result.setMsg("app_id is empty");
            result.setData(null);
            ctx.setResponseBody(result.toString());
            return  "";
        }else if(!app_id.equals(DEFALT_TOEKN))
        {
            log.warn("app_id is  invalid");
            ctx.setSendZuulResponse(false);
            ApiResult result=new ApiResult(CommonCode.ERROR);
            result.setCodeMsg(CommonCode.PARAMETER_INVALID);
            result.setMsg("app_id is  invalid");
            result.setData(null);
            ctx.setResponseBody(result.toString());
            return  "";
        }

        log.info("app_id is ok");

        return null;
    }
}