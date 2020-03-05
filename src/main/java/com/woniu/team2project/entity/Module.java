package com.woniu.team2project.entity;

public class Module {
	private Integer module_id;//模块id
	private String module_name;//模块名称
	private Module parent_id;//父模块
	public Module() {
		super();
	}
	public Module(Integer module_id, String module_name, Module parent_id) {
		super();
		this.module_id = module_id;
		this.module_name = module_name;
		this.parent_id = parent_id;
	}
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
	public Module getParent_id() {
		return parent_id;
	}
	public void setParent_id(Module parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public String toString() {
		return "Module [module_id=" + module_id + ", module_name=" + module_name + ", parent_id=" + parent_id + "]";
	}
	
}
