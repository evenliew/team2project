package com.woniu.team2project.entity;
//行业
public class Industry {
	private Integer industry_id;
	private String industry_name;
	public Industry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Industry(Integer industry_id, String industry_name) {
		super();
		this.industry_id = industry_id;
		this.industry_name = industry_name;
	}
	public Integer getIndustry_id() {
		return industry_id;
	}
	public void setIndustry_id(Integer industry_id) {
		this.industry_id = industry_id;
	}
	public String getIndustry_name() {
		return industry_name;
	}
	public void setIndustry_name(String industry_name) {
		this.industry_name = industry_name;
	}
	@Override
	public String toString() {
		return "Industry [industry_id=" + industry_id + ", industry_name=" + industry_name + "]";
	}
	
}
