package com.woniu.team2project.entity;

public class User_role {
	private Integer user_role_id; //角色表主键（没啥意义）
	private String user_id; //用户id
	private Integer role_id; //角色 id 1.局里的领导 2.局里的员工 3.单位领导 4 单位员工
	public User_role(Integer user_role_id, String user_id, Integer role_id) {
		super();
		this.user_role_id = user_role_id;
		this.user_id = user_id;
		this.role_id = role_id;
	}
	public User_role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "User_role [user_role_id=" + user_role_id + ", user_id=" + user_id + ", role_id=" + role_id + "]";
	}
	
	

}
