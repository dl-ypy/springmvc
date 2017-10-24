package com.ypy.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ypy.pojo.UserModel;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@RequestMapping("/query.do")
	public ModelAndView query() {
		ModelAndView model = new ModelAndView();
		System.out.println("query");
		model.addObject("msg", "测试数据");
		model.setViewName("/index.jsp");
		return model;
	}
	
	@RequestMapping(value="/save.do", method=RequestMethod.GET)   //表示只接收get方法传过来的值
	public String save(@RequestParam(defaultValue="10") Integer id, String name, UserModel user) {   /*直接在参数中获取页面传来的值*/
		System.out.println("save"+":"+name+","+id + "," + user);   /*设置默认值*/
		return "/index.jsp";        /*当属性参数与模型参数中的属性名相同时，都会赋值*/
									/*可在model中通过集合来接收相同名的多个属性，如爱好*/
	}
	
	@RequestMapping("/update.do")
	public String update() {
		System.out.println("update");
		return "redirect:query.do";      /*服务器跳转*/
	}
	
	@RequestMapping("/delete.do")   /*直接使用web对象*/
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete");
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/add.do")
	public String add(Map map, Model model, ModelMap mm) {
		map.put("msg", "map传值");
		model.addAttribute("model","model传值");
		mm.addAttribute("mm", "modelmap传值");
		System.out.println("add");
		return "/index.jsp";      /*服务器跳转*/
	}
	
	/**
	 * 将string类型转化为Date
	 * @param binder
	 */
	/*@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}*/
}
