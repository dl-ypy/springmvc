springmvc  maven管理注解方式

pom.xml配置jar包管理
web.xml配置核心控制器
创建并配置springmvc的配置文件：springmvc-servlet.xml
在web.xml中加入springmvc-servlet.xml的路径
配置action

modelAndView测试：http://localhost:8686/Springmvc_day01_2/user/query.do
服务器跳转测试：http://localhost:8686/Springmvc_day01_2/user/update.do
获取页面传来的值（包括date类型）测试：http://localhost:8686/Springmvc_day01_2/user/save.do?id=999&name=sssss&username=ooo&list=lol&list=2k&birthday=2000-11-12
	配置转换时间类型方法一：（注意格式大小写）
		在action中配置：
			@InitBinder
			public void initBinder(ServletRequestDataBinder binder) {
				binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
			}
	配置转换时间类型方法二：
		自己写转换类DateUtil.java
		在springmvc-servlet.xml中配置与springmvc连接
获取web对象测试：http://localhost:8686/Springmvc_day01_2/user/delete.do
向前端页面传值测试：http://localhost:8686/Springmvc_day01_2/user/add.do