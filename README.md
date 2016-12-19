# Irelandlight


####2016年12月18日提交记录：

* 修改了Interceptor的注册方式，新的版本中将Interceptor的注册放在了spring-web.xml
* 加入了对于中文乱码的处理，在web.xml中的filter中进行
* 在com.irelandlight.interceptor包下增加了一个Interceptor示例
    1. 编写Interceptor
    2. 将Interceptor注册进controller链路
    3. 在SpringMVC配置文件中设置拦截规则
* 暂时还不知道WebMvcConfigurerAdapter能否对普通的Spring项目进行注册
* 暂时无法解决向github提交代码时没有contribution的问题

####2016年12月20日提交记录

* 在spring-web.xml中加入了对com.irelandlight.model的包扫描
因为HostHolder类需要在controller层之前的Interceptor中被调用。
* 在LoginTicketManager中加入了验证ticket的算法。
* 调整了MD5Util类的部分逻辑。