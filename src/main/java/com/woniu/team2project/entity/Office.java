package com.woniu.team2project.entity;

import org.springframework.stereotype.Component;

//单位
@Component
public class Office {
	private Integer office_id;
	private String office_name;
	private User office_leader;//单位领导
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
	
	
	public User getOffice_leader() {
		return office_leader;
	}
	public void setOffice_leader(User office_leader) {
		this.office_leader = office_leader;
	}
	public Office(Integer office_id, String office_name, User office_leader) {
		super();
		this.office_id = office_id;
		this.office_name = office_name;
		this.office_leader = office_leader;
	}
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
