package com.ypy.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ypy.model.UserModel;

@Controller
@RequestMapping("/user")
public class UserAction {
	@RequestMapping("/query.do/{id}/{name}")   //动态参数
	public String query(@PathVariable Integer id, @PathVariable String name) {
		System.out.println("---------->"+id+","+name);
		return "/index.jsp";
	}
	
	@RequestMapping("/save.do")  //返回json格式
	@ResponseBody
	public UserModel save() {
		UserModel user = new UserModel();
		user.setUserid(1);
		user.setUsername("aaa");
		user.setPassword("11111");
		return user;
	}
	
	@RequestMapping("/update.do")  //验证
	@ResponseBody     //这里必须配置json格式
	public UserModel update(@Validated UserModel user, BindingResult result) {
		List<ObjectError> list = result.getAllErrors();
		for (ObjectError err : list) {
			System.out.println(err.getDefaultMessage());
		}
		return user;
	}
	
	@RequestMapping("/upload.do")  //文件上传
	public String upload(MultipartFile upload, HttpServletRequest request) throws IllegalStateException, IOException {
		//获取原来文件的名称
		String fileName = upload.getOriginalFilename();
		System.out.println(fileName);
		
		File path = new File("e:/upload");
		if (!path.isDirectory()) {
			path.mkdir();
		}
		File newFile = new File(path+"/"+fileName);
		upload.transferTo(newFile);
		return "/index.jsp";
	}
}
