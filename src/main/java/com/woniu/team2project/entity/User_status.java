package com.woniu.team2project.entity;

import org.springframework.stereotype.Component;

//用户身份
@Component
public class User_status {
	private Integer user_status_id;
	private String user_status_name;
	public User_status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_status(Integer user_status_id, String user_status_name) {
		super();
		this.user_status_id = user_status_id;
		this.user_status_name = user_status_name;
	}
	public Integer getUser_status_id() {
		return user_status_id;
	}
	public void setUser_status_id(Integer user_status_id) {
		this.user_status_id = user_status_id;
	}
	public String getUser_status_name() {
		return user_status_name;
	}
	public void setUser_status_name(String user_status_name) {
		this.user_status_name = user_status_name;
	}
	@Override
	public String toString() {
		return "User_status [user_status_id=" + user_status_id + ", user_status_name=" + user_status_name + "]";
	}
	
}
