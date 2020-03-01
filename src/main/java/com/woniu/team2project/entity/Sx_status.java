package com.woniu.team2project.entity;

//事项状态
public class Sx_status {
	private Integer sx_status_id;
	private String sx_status_name;
	public Sx_status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sx_status(Integer sx_status_id, String sx_status_name) {
		super();
		this.sx_status_id = sx_status_id;
		this.sx_status_name = sx_status_name;
	}
	public Integer getSx_status_id() {
		return sx_status_id;
	}
	public void setSx_status_id(Integer sx_status_id) {
		this.sx_status_id = sx_status_id;
	}
	public String getSx_status_name() {
		return sx_status_name;
	}
	public void setSx_status_name(String sx_status_name) {
		this.sx_status_name = sx_status_name;
	}
	@Override
	public String toString() {
		return "Sx_state [sx_status_id=" + sx_status_id + ", sx_status_name=" + sx_status_name + "]";
	}
	
}
