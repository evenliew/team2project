package com.woniu.team2project.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件类
 * @author ABC
 *
 */
public class Papers {
	private String file_id;//文件id
	private Date file_time;//上传时间
	private String file_name;//文件名称
	private User user;//上传人对象
	private Module module;//模块对象
	private Sx sx;//具体对应事项 
	private String file_url;//文件URL
	private PapersType papersType;//文件类型对象
	
	public Papers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Papers(String file_id, Date file_time, String file_name, User user, Module module, Sx sx, String file_url,
			PapersType papersType) {
		super();
		this.file_id = file_id;
		this.file_time = file_time;
		this.file_name = file_name;
		this.user = user;
		this.module = module;
		this.sx = sx;
		this.file_url = file_url;
		this.papersType = papersType;
	}

	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public Date getFile_time() {
		return file_time;
	}

	public void setFile_time(Date file_time) {
		this.file_time = file_time;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Sx getSx() {
		return sx;
	}

	public void setSx(Sx sx) {
		this.sx = sx;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public PapersType getPapersType() {
		return papersType;
	}

	public void setPapersType(PapersType papersType) {
		this.papersType = papersType;
	}

	@Override
	public String toString() {
		return "Papers [file_id=" + file_id + ", file_time=" + file_time + ", file_name=" + file_name + ", user=" + user
				+ ", module=" + module + ", sx=" + sx + ", file_url=" + file_url + ", papersType=" + papersType + "]";
	}

	
}
