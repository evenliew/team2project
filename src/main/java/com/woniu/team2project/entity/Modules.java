package com.woniu.team2project.entity;

public class Modules {

	private Integer module_id;
	private String module_name;
	private Integer parent_id;
	public Integer getModule_id() {
		return module_id;
	}
	public void setModule_id(Integer module_id) {
		this.module_id = module_id;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public String toString() {
		return "Modules [module_id=" + module_id + ", module_name=" + module_name + ", parent_id=" + parent_id + "]";
	}
	public Modules(Integer module_id, String module_name, Integer parent_id) {
		super();
		this.module_id = module_id;
		this.module_name = module_name;
		this.parent_id = parent_id;
	}
	public Modules() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
