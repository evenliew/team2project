package com.woniu.team2project.entity;
//紧急程度
public class Urgency {
	private Integer urgency_id;
	private String urgency_name;
	public Urgency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Urgency(Integer urgency_id, String urgency_name) {
		super();
		this.urgency_id = urgency_id;
		this.urgency_name = urgency_name;
	}
	public Integer getUrgency_id() {
		return urgency_id;
	}
	public void setUrgency_id(Integer urgency_id) {
		this.urgency_id = urgency_id;
	}
	public String getUrgency_name() {
		return urgency_name;
	}
	public void setUrgency_name(String urgency_name) {
		this.urgency_name = urgency_name;
	}
	@Override
	public String toString() {
		return "Urgency [urgency_id=" + urgency_id + ", urgency_name=" + urgency_name + "]";
	}
	
}
