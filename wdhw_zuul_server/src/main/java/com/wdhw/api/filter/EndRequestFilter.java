//package com.wdhw.api.filter;
//
//import com.google.common.io.CharStreams;
//import com.netflix.util.Pair;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.io.*;
//import java.util.List;
//
///**
// * Created by admin on 2017/2/21.
// */
//public class EndRequestFilter extends ZuulFilter {
//    private static Logger log = LoggerFactory.getLogger(BeforeRequestFilter.class);
//    private static final String JSON_UTF8="application/json;charset=UTF-8";
//
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        String callback= ctx.getRequest().getParameter("callback");
//        try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
//            //文件类下载
//            if (isFileDownType(ctx) && responseDataStream != null&&StringUtils.isBlank(callback)) {
//                List<Pair<String, String>> listPair = ctx.getZuulResponseHeaders();
//                if (listPair != null && listPair.size() > 0) {
//                    for (Pair<String, String> p : listPair) {
//                        ctx.getResponse().setHeader(p.first().toString(), p.second().toString());
//                    }
//                }
//                InputStream is = responseDataStream;
//                OutputStream out = ctx.getResponse().getOutputStream();
//                try {
//                    BufferedInputStream bis = new BufferedInputStream(is);
//                    BufferedOutputStream bos = new BufferedOutputStream(out);
//                    byte[] buff = new byte[2048];
//                    int bytesRead;
//                    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                        bos.write(buff, 0, bytesRead);
//                    }
//                    bis.close();
//                    bos.close();
//                } catch (final IOException e) {
//                    log.error("dow file error ={}", e);
//                }
//                return null;
//            }
//            else if(StringUtils.isEmpty(callback) && responseDataStream==null){
//                ctx.getResponse().setContentType(JSON_UTF8);
//                ctx.setResponseBody(ctx.getResponseBody());
//                return null;
//            }else if (StringUtils.isNotEmpty(callback)&& responseDataStream==null){
//                ctx.getResponse().setContentType(JSON_UTF8);
//                ctx.setResponseBody(callback + "("+ctx.getResponseBody() + ")");
//                return  null;
//            }else if(StringUtils.isEmpty(callback) && responseDataStream!=null){
//                ctx.getResponse().setContentType(JSON_UTF8);
//                final String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
//                ctx.setResponseBody(responseData);
//            }else if(StringUtils.isNotEmpty(callback) && responseDataStream!=null){
//                ctx.getResponse().setContentType(JSON_UTF8);
//                final String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
//                ctx.setResponseBody(callback+"("+responseData+")");
//            }
//
//        } catch (IOException e) {
//            log.warn("Error reading body",e);
//        }
//        return null;
//    }
//
//    @Override
//    public String filterType() {
//        return "post";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    /**
//     * 判断是否为图片下载
//     * @param ctx
//     * @return TODO 有bug待修复
//     */
//    private boolean isFileDownType(RequestContext ctx){
//        List<Pair<String, String>> listPair= ctx.getZuulResponseHeaders();
//        if (listPair!=null && listPair.size()>0){
//            for (Pair<String, String> pair:listPair){
//                if ("Content-Type".equals(pair.first()) && ("text/html;charset=UTF-8".equals(pair.second()) || "application/json;charset=UTF-8".equals(pair.second()))){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}
