package com.ypy.pojo;

import java.util.Date;
import java.util.List;

public class UserModel {
	private int id;
	private String username;
	private List<Object> list;
	private Date birthday;
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", list=" + list +", birthday="+birthday+"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
