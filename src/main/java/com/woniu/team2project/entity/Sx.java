package com.woniu.team2project.entity;

import java.util.Date;

//事项实体 
public class Sx {
	private String sx_id;//事项id
	private String sx_name;//事项名称
	private Sx_type sx_type;//事项类型
	private Sx_status sx_status;//事项状态
	private Date sx_time;//事项开始时间
	private User founder;//发起人
	private String sx_content;//事项内容
	private String sx_remark;//事项备注
	private Urgency urgency;//紧急程度
	//新加一个地区（地区>区县）
	private Area area; //所属地区
	private County county;//所属区县
	private Industry industry;//所属行业
	//后面加的
	private Date sx_end_time;//事项结束时间
	private Office office;//单位的id
	//后来加的
	
	
	public Sx(String sx_id, String sx_name, Sx_type sx_type, Sx_status sx_status, Date sx_time, User founder,
			String sx_content, String sx_remark, Urgency urgency, Area area, County county, Industry industry,
			Date sx_end_time, Office office) {
		super();
		this.sx_id = sx_id;
		this.sx_name = sx_name;
		this.sx_type = sx_type;
		this.sx_status = sx_status;
		this.sx_time = sx_time;
		this.founder = founder;
		this.sx_content = sx_content;
		this.sx_remark = sx_remark;
		this.urgency = urgency;
		this.area = area;
		this.county = county;
		this.industry = industry;
		this.sx_end_time = sx_end_time;
		this.office = office;
	}
	public String getSx_id() {
		return sx_id;
	}
	public void setSx_id(String sx_id) {
		this.sx_id = sx_id;
	}
	public String getSx_name() {
		return sx_name;
	}
	public void setSx_name(String sx_name) {
		this.sx_name = sx_name;
	}
	public Sx_type getSx_type() {
		return sx_type;
	}
	public void setSx_type(Sx_type sx_type) {
		this.sx_type = sx_type;
	}
	public Sx_status getSx_status() {
		return sx_status;
	}
	public void setSx_status(Sx_status sx_status) {
		this.sx_status = sx_status;
	}
	public Date getSx_time() {
		return sx_time;
	}
	public void setSx_time(Date sx_time) {
		this.sx_time = sx_time;
	}
	public User getFounder() {
		return founder;
	}
	public void setFounder(User founder) {
		this.founder = founder;
	}
	public String getSx_content() {
		return sx_content;
	}
	public void setSx_content(String sx_content) {
		this.sx_content = sx_content;
	}
	public String getSx_remark() {
		return sx_remark;
	}
	public void setSx_remark(String sx_remark) {
		this.sx_remark = sx_remark;
	}
	public Urgency getUrgency() {
		return urgency;
	}
	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public County getCounty() {
		return county;
	}
	public void setCounty(County county) {
		this.county = county;
	}
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public Date getSx_end_time() {
		return sx_end_time;
	}
	public void setSx_end_time(Date sx_end_time) {
		this.sx_end_time = sx_end_time;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	@Override
	public String toString() {
		return "Sx [sx_id=" + sx_id + ", sx_name=" + sx_name + ", sx_type=" + sx_type + ", sx_status=" + sx_status
				+ ", sx_time=" + sx_time + ", founder=" + founder + ", sx_content=" + sx_content + ", sx_remark="
				+ sx_remark + ", urgency=" + urgency + ", county=" + county + ", industry=" + industry
				+ ", sx_end_time=" + sx_end_time + ", office=" + office + "]";

	}
	public Sx(String sx_id, String sx_name, Sx_type sx_type, Sx_status sx_status, Date sx_time, User founder,
			String sx_content, String sx_remark, Urgency urgency, County county, Industry industry, Date sx_end_time,
			Office office) {
		super();
		this.sx_id = sx_id;
		this.sx_name = sx_name;
		this.sx_type = sx_type;
		this.sx_status = sx_status;
		this.sx_time = sx_time;
		this.founder = founder;
		this.sx_content = sx_content;
		this.sx_remark = sx_remark;
		this.urgency = urgency;
		this.county = county;
		this.industry = industry;
		this.sx_end_time = sx_end_time;
		this.office = office;
	}
	public Sx() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
 