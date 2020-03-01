package com.woniu.team2project.entity;
//区
public class Area {
	private Integer area_id;
	private String area_name;
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Area(Integer area_id, String area_name) {
		super();
		this.area_id = area_id;
		this.area_name = area_name;
	}
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	@Override
	public String toString() {
		return "Area [area_id=" + area_id + ", area_name=" + area_name + "]";
	}
	
}
