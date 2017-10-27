package com.ypy.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserModel {
	private int userid;
	
	@NotBlank(message="用户名不能为空")
	@Size(max=6,min=3,message="用户名长度3-6")
	private String username;
	private String password;
	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
