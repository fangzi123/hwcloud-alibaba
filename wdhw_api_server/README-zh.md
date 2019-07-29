## springcloud 基础服务

### API项目架构
* sentinel 限流
* 参考https://github.com/alibaba/spring-cloud-alibaba
* 运行sentinel-dashboard.jar

            
    <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
       <version>0.9.0.RELEASE</version>
    </dependency>
    
    spring:
        cloud:
            sentinel:
              eager: true
              #      transport:
              #        dashboard: localhost:8080
              datasource:
                ds1:
                    file:
                      file: 'classpath: flowrule.json'
                      data-type: json
                      rule-type: flow
                      
    flowrule.json 文件定义限流规则
    
    @SentinelResource 对一般方法限流 ExceptionUtil 自定义异常输出
    
    CustomUrlBlockHandler 对controller限流 自定义异常输出
      
      
