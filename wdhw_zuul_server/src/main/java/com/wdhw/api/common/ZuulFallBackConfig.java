//package com.wdhw.api.common;
//
//import com.wdhw.api.filter.MySendErrorFilter;
//import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
//import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.client.ClientHttpResponse;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * Created by caicz on 2017/6/26.
// */
//@Configuration
//public class ZuulFallBackConfig implements FallbackProvider {
//
//    @Bean
//    public SendErrorFilter sendErrorFilter() {
//        return new MySendErrorFilter();
//    }
//
//
//    @Override
//    public String getRoute() {
//        return null;
//    }
//
//
//    @Override
//    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
//        InputStream inputStream = new ByteArrayInputStream(new ApiResult<String>(CommonCode.ERROR).toString().getBytes());
//        return new ClientHttpResponse() {
//            @Override
//            public HttpStatus getStatusCode() throws IOException {
//                return HttpStatus.OK;
//            }
//
//            @Override
//            public int getRawStatusCode() throws IOException {
//                return 200;
//            }
//
//            @Override
//            public String getStatusText() throws IOException {
//                return "OK";
//            }
//
//            @Override
//            public void close() {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    this.finalize();
//                } catch (Throwable throwable) {
//                    throwable.printStackTrace();
//                }
//            }
//
//            @Override
//            public InputStream getBody() throws IOException {
//                return inputStream;
//            }
//
//            @Override
//            public HttpHeaders getHeaders() {
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_JSON);
//                return headers;
//            }
//        };
//    }
//
//}
