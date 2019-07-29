start  "EUREKA http://127.0.0.1:11100/"  cmd /c java -jar wdhw_eureka_server\target\wdhw_eureka_server.jar
choice /T 10 /C ync /CS /D y /n
start  "CONFIG http://127.0.0.1:8888/"  cmd /c java -jar wdhw_eureka_config_server\target\wdhw_eureka_config_server.jar
start  "ZUUL http://127.0.0.1:11200/"    cmd /c java -jar wdhw_eureka_zuul_server\target\wdhw_eureka_zuul_server.jar
