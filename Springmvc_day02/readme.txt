springmvc

动态参数：在action中配置
测试：

接收json格式：
配置：pom.xml配置导包， 在springmvc-servlet.xml中配置，在action中添加注解
测试：http://localhost:8686/Springmvc_day02/user/save.do

拦截器
配置：编写Interceptor类，在springmvc-servlet.xml中进行配置，在web.xml中配置资源文件不被拦截的配置

验证
配置：pom.xml配置导包， 在springmvc-servlet.xml中配置，在model和action中添加注解
测试：http://localhost:8686/Springmvc_day02/user/update.do?username=11

文件上传
配置：pom.xml配置导包， 在springmvc-servlet.xml中配置，在action中配置，编写前台jsp。
测试：http://localhost:8686/Springmvc_day02/index.jsp