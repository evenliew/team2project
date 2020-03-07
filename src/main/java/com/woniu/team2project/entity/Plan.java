package com.woniu.team2project.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Plan {

	private Integer plan_id;
	private Date plan_time;
	private String plan_content;
	private User plan_founder_id;
	private Integer plan_type_id;
	private Date plan_start_time;
	private Date plan_end_time;
	private Modules module_id;
	private Sx plan_sx_id;
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public Date getPlan_time() {
		return plan_time;
	}
	public void setPlan_time(Date plan_time) {
		this.plan_time = plan_time;
	}
	public String getPlan_content() {
		return plan_content;
	}
	public void setPlan_content(String plan_content) {
		this.plan_content = plan_content;
	}
	public User getPlan_founder_id() {
		return plan_founder_id;
	}
	public void setPlan_founder_id(User plan_founder_id) {
		this.plan_founder_id = plan_founder_id;
	}
	public Integer getPlan_type_id() {
		return plan_type_id;
	}
	public void setPlan_type_id(Integer plan_type_id) {
		this.plan_type_id = plan_type_id;
	}
	public Date getPlan_start_time() {
		return plan_start_time;
	}
	public void setPlan_start_time(Date plan_start_time) {
		this.plan_start_time = plan_start_time;
	}
	public Date getPlan_end_time() {
		return plan_end_time;
	}
	public void setPlan_end_time(Date plan_end_time) {
		this.plan_end_time = plan_end_time;
	}
	public Modules getModule_id() {
		return module_id;
	}
	public void setModule_id(Modules module_id) {
		this.module_id = module_id;
	}
	public Sx getPlan_sx_id() {
		return plan_sx_id;
	}
	public void setPlan_sx_id(Sx plan_sx_id) {
		this.plan_sx_id = plan_sx_id;
	}
	@Override
	public String toString() {
		return "Plan [plan_id=" + plan_id + ", plan_time=" + plan_time + ", plan_content=" + plan_content
				+ ", plan_founder_id=" + plan_founder_id + ", plan_type_id=" + plan_type_id + ", plan_start_time="
				+ plan_start_time + ", plan_end_time=" + plan_end_time + ", module_id=" + module_id + ", plan_sx_id="
				+ plan_sx_id + "]";
	}
	public Plan(Integer plan_id, Date plan_time, String plan_content, User plan_founder_id, Integer plan_type_id,
			Date plan_start_time, Date plan_end_time, Modules module_id, Sx plan_sx_id) {
		super();
		this.plan_id = plan_id;
		this.plan_time = plan_time;
		this.plan_content = plan_content;
		this.plan_founder_id = plan_founder_id;
		this.plan_type_id = plan_type_id;
		this.plan_start_time = plan_start_time;
		this.plan_end_time = plan_end_time;
		this.module_id = module_id;
		this.plan_sx_id = plan_sx_id;
	}
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
