## springcloud 基础服务

### 项目架构
* JDK 11, Maven 3.2+, IDEA 2018+
* Springboot 2.0.6.RELEASE
* SpringCloud Finchley.RELEASE
* eureka :注册中心
* zuul :网关
* config : 配置中心 依赖git，rabbitmq
       
       http://127.0.0.1:8888/wdhw-lms-server/dev
       http://127.0.0.1:8888/wdhw-lms-server/stable
* spring-config-resp :config的git仓库 与config一起使用
* turbine :聚合hystrix.stream 
        
      访问http://127.0.0.1:11400/hystrix 
      监控http://192.168.8.236:11400/turbine.stream
* admin 服务监控
    http://192.168.8.236:11500/#/applications

### 备注
* 1.启动 eureka http://127.0.0.1:11100/
* 2.启动 config http://127.0.0.1:8888/wdhw-lms-server/dev
* 3 启动 zuul http://127.0.0.1:11200/lms/+URI
* 3.修改完spring-config-resp云配置文件，对应的微服务需要重启才能生效
    http://{configServer}:8888/actuator/bus-refresh不太健全
* 4.启动各个微服务 需要mq.否则执行/actuator/bus-refresh无效。
* 5.http://127.0.0.1:11300/hystrix 
     单机监控http://127.0.0.1:11300/actuator/hystrix.stream
