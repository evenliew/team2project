package com.woniu.team2project.entity;

import java.util.Date;

/**
 * 公告表:发布公告
 * @author 9468
 *
 */
public class Notice {
	private Integer notice_id;//公告id
	private String notice_title;//公告标题
	private Date notice_time;//公告发布时间
	private String notice_content;//内容
	private User notice_founder;//发布人
	private Module module;//模块id
	public Notice() {
		super();
	}
	public Notice(Integer notice_id, String notice_title, Date notice_time, String notice_content, User notice_founder,
			Module module) {
		super();
		this.notice_id = notice_id;
		this.notice_title = notice_title;
		this.notice_time = notice_time;
		this.notice_content = notice_content;
		this.notice_founder = notice_founder;
		this.module = module;
	}
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public Date getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public User getNotice_founder() {
		return notice_founder;
	}
	public void setNotice_founder(User notice_founder) {
		this.notice_founder = notice_founder;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", notice_title=" + notice_title + ", notice_time=" + notice_time
				+ ", notice_content=" + notice_content + ", notice_founder=" + notice_founder + ", module=" + module
				+ "]";
	}
	
}
