package com.ypy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor{
	
	private String name;
	
	public Interceptor() {
		super();
	}
	
	public Interceptor(String name) {
		this.name = name;
	}

	
	/**
	 * 此方法只会在当前interceptor的preHandle方法返回true时才执行。
	 * 此方法在请求后执行，也就是在DispatcherServlet进行视图渲染之后调用，用于清理资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("-------afterCompletion--------"+name);
		
	}

	/**
	 * 此方法只会在当前interceptor的preHandle方法返回true时才执行。
	 * 在controller之后执行。
	 * 在DispatcherServlet进行视图渲染之前调用，可以对ModelAndView进行操作。
	 * 先进行拦截的interceptor后调用此方法
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("---------postHandle-----------"+name);
		
	}

	/**
	 * 进行拦截的方法，在controller之前执行
	 * 是链式的，可有多个interceptor，会根据声明顺序，一个接一个执行
	 * true表示放过，false表示拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("-------------进行拦截-------------"+name);
		return true;  
	}

}
