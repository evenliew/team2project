package com.woniu.team2project.entity;
//县
public class County {
	private Integer county_id;
	private String county_name;
	private Area area;//区
	public County() {
		super();
		// TODO Auto-generated constructor stub
	}
	public County(Integer county_id, String county_name, Area area) {
		super();
		this.county_id = county_id;
		this.county_name = county_name;
		this.area = area;
	}
	public Integer getCounty_id() {
		return county_id;
	}
	public void setCounty_id(Integer county_id) {
		this.county_id = county_id;
	}
	public String getCounty_name() {
		return county_name;
	}
	public void setCounty_name(String county_name) {
		this.county_name = county_name;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "County [county_id=" + county_id + ", county_name=" + county_name + ", area=" + area + "]";
	}
	
}
