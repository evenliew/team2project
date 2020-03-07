package com.woniu.team2project.entity;

import org.springframework.stereotype.Component;

//用户表
@Component
public class User {
	private String user_id;
	private String user_name;
	private String user_pass;
	private String user_loginname;
	private String user_phone;
	private User_status user_status;
	private Area area;
	private Office office;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_loginname() {
		return user_loginname;
	}
	public void setUser_loginname(String user_loginname) {
		this.user_loginname = user_loginname;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public User_status getUser_status() {
		return user_status;
	}
	public void setUser_status(User_status user_status) {
		this.user_status = user_status;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pass=" + user_pass
				+ ", user_loginname=" + user_loginname + ", user_phone=" + user_phone + ", user_status=" + user_status
				+ ", area=" + area + ", office=" + office + "]";
	}
	public User(String user_id, String user_name, String user_pass, String user_loginname, String user_phone,
			User_status user_status, Area area, Office office) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.user_loginname = user_loginname;
		this.user_phone = user_phone;
		this.user_status = user_status;
		this.area = area;
		this.office = office;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
