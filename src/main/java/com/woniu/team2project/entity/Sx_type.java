package com.woniu.team2project.entity;
//事项类型
public class Sx_type {
	private Integer sx_type_id;
	private String sx_type_name;

	public Sx_type() {
		super();
	}

	public Sx_type(Integer sx_type_id, String sx_type_name) {
		super();
		this.sx_type_id = sx_type_id;
		this.sx_type_name = sx_type_name;
	}

	public Integer getSx_type_id() {
		return sx_type_id;
	}

	public void setSx_type_id(Integer sx_type_id) {
		this.sx_type_id = sx_type_id;
	}

	public String getSx_type_name() {
		return sx_type_name;
	}

	public void setSx_type_name(String sx_type_name) {
		this.sx_type_name = sx_type_name;
	}

	@Override
	public String toString() {
		return "Sx_type [sx_type_id=" + sx_type_id + ", sx_type_name=" + sx_type_name + "]";
	}

}
