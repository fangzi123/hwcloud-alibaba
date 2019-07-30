package com.wdhw.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Controller
public class ApiDispatcher implements ApplicationContextAware {
    protected static Logger log = LoggerFactory.getLogger(ApiDispatcher.class);
    private static final Logger msgLogger = LoggerFactory.getLogger("msg");

    private Map<String, ApiProcessor> processors = new ConcurrentHashMap<String, ApiProcessor>();




    /**
     * 调用该方法以调用相应的处理逻辑
     */
    public String dispatch(Map params) {
      //  JSONObject msg = (JSONObject) JSON.parse(params);

             ApiProcessor processor;

            processor = processors.get(params.get("method"));

        if (processor != null) {
            try {
                return processor.process(params);

            } catch (Exception e) {
                log.error("unexpected error. message is " + params, e);
            }
        } else {
            log.warn("该消息没有对应的MsgProcessor: {}", params);
        }
        return"";
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ApiProcessor> processorMap = applicationContext.getBeansOfType(ApiProcessor.class);
        for (ApiProcessor processor: processorMap.values()) {

                processors.put(processor.getApiType(), processor);

        }
        msgLogger.info("processors prepared: {}", getProcessorsList(processors));

    }

    public static String getProcessorsList(Map<String, ApiProcessor> processors) {
        List<String> names = new ArrayList<String>(processors.size());
        for(Map.Entry<String, ApiProcessor> processor : processors.entrySet()) {
            names.add(processor.getValue().getClass().getSimpleName());
        }
        return names.toString();
    }
}
