//package com.wdhw.api.controller;
//
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class ApiRequestHandle {
//    protected static Logger logger = LoggerFactory.getLogger(ApiRequestHandle.class);
//
//    private static final Log msgLogger = LogFactory.getLog("msg");
//
//    private static final Logger performanceLogger = LoggerFactory.getLogger("performance");
//
//    @Autowired
//    private ApiDispatcher apiDispatcher;
//
//    private static void receive(Map msg) {
//        msgLogger.debug(msg);
//    }
//
//    public String  excute(final Map json) {
//        long start = System.currentTimeMillis();
//        performanceLogger.debug("all start time: {}, msg: {}", start, json);
//
//        String ret= apiDispatcher.dispatch(json);
//
//        String time = String.format("%.3f", (float) (System.currentTimeMillis() - start) / 1000);
//        performanceLogger.debug("all end time: {} s, msg: {}", time, json);
//        return ret;
//    }
//    @RequestMapping(value = "/api2", produces = "application/json; charset=utf-8")
//           public String request(HttpServletRequest request,
//                                 @RequestParam(value = "method") String method,
//                                 @RequestParam(value = "data", required = false) String data,
//                                 @RequestParam(value = "sign", required = false) String sign) throws Exception {
//        Map sv=request.getParameterMap();
//        request.getServletContext();
//        System.out.println("par :"+sv);
//        Map para=new HashMap<String,Object>();
//        para.put("method",method);
//        System.out.println("service start .... " +"");
//        receive(para);
//        return excute(para);
//
//    }
//
//    /**
//     * 无加密请求
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/api", produces = "application/json; charset=utf-8")
//    public String requestNoSign(HttpServletRequest request,HttpServletResponse response)
//                          throws Exception {
//        Map parameterMap=ApiRequestHandle.getParameterMap(request);
//        logger.info(" 传入参数：{}", parameterMap);
//
//
//        String method =(String)parameterMap.get("method");
//        logger.info(" 调用接口：method {}", method);
//        receive(parameterMap);
//        return excute(parameterMap);
//
//    }
//    /**
//     * 从request中获得参数Map，并返回可读的Map
//     *
//     * @param request
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public static Map getParameterMap(HttpServletRequest request) {
//
//        // 返回值Map
//        Map returnMap = new HashMap();
//        //得到枚举类型的参数名称，参数名称若有重复的只能得到第一个
//        Enumeration enums=request.getParameterNames();
//       while (enums.hasMoreElements()) {
//            String paramName = (String) enums.nextElement();
//
//         String paramValue =request.getParameter(paramName);
//
//         //形成键值对应的map
//          returnMap.put(paramName, paramValue);
//
//            }
//        return returnMap;
//    }
//
//}
