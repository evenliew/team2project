package com.woniu.team2project.entity;

/**
 * 文件类型类
 * 
 * @author ABC
 *
 */
public class PapersType {
	private Integer file_type_id;// id
	private String type_name;// 文件类型
	
	public PapersType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PapersType(Integer file_type_id, String type_name) {
		super();
		this.file_type_id = file_type_id;
		this.type_name = type_name;
	}

	public Integer getFile_type_id() {
		return file_type_id;
	}

	public void setFile_type_id(Integer file_type_id) {
		this.file_type_id = file_type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	@Override
	public String toString() {
		return "PapersType [file_type_id=" + file_type_id + ", type_name=" + type_name + "]";
	}

	
	

}
