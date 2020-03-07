package com.woniu.team2project.entity;

import org.springframework.stereotype.Component;

//单位
@Component
public class Office {
	private Integer office_id;
	private String office_name;
	private String office_leader_id;//单位领导编号
	public Integer getOffice_id() {
		return office_id;
	}
	public void setOffice_id(Integer office_id) {
		this.office_id = office_id;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getOffice_leader_id() {
		return office_leader_id;
	}
	public void setOffice_leader_id(String office_leader_id) {
		this.office_leader_id = office_leader_id;
	}
	@Override
	public String toString() {
		return "Office [office_id=" + office_id + ", office_name=" + office_name + ", office_leader_id="
				+ office_leader_id + "]";
	}
	public Office(Integer office_id, String office_name, String office_leader_id) {
		super();
		this.office_id = office_id;
		this.office_name = office_name;
		this.office_leader_id = office_leader_id;
	}
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
