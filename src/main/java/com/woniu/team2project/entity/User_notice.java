package com.woniu.team2project.entity;

import java.util.Date;

/*
 * 个人通告表:个人的通告表，每个人得到的通告的详细信息
 */
public class User_notice {
	private Integer user_nt_id;//个人得到的通告id---主键
	private String user_nt_title;//通告标题
	private String user_nt_content;//内容
	private Date user_nt_time;//发送时间
	private User user_nt_founder;//发布者--查询得到---外键
	private User user_nt_recender;//接受者---外键
	private Sx user_nt_sx;//事项id--外键
	private Notice_mb user_nt_mb;//通告模板
	public User_notice() {
		super();
	}
	
	public User_notice(Integer user_nt_id, String user_nt_title, String user_nt_content, Date user_nt_time,
			User user_nt_founder, User user_nt_recender, Sx user_nt_sx, Notice_mb user_nt_mb) {
		super();
		this.user_nt_id = user_nt_id;
		this.user_nt_title = user_nt_title;
		this.user_nt_content = user_nt_content;
		this.user_nt_time = user_nt_time;
		this.user_nt_founder = user_nt_founder;
		this.user_nt_recender = user_nt_recender;
		this.user_nt_sx = user_nt_sx;
		this.user_nt_mb = user_nt_mb;
	}

	public Integer getUser_nt_id() {
		return user_nt_id;
	}
	public void setUser_nt_id(Integer user_nt_id) {
		this.user_nt_id = user_nt_id;
	}
	public String getUser_nt_title() {
		return user_nt_title;
	}
	public void setUser_nt_title(String user_nt_title) {
		this.user_nt_title = user_nt_title;
	}
	public String getUser_nt_content() {
		return user_nt_content;
	}
	public void setUser_nt_content(String user_nt_content) {
		this.user_nt_content = user_nt_content;
	}
	public Date getUser_nt_time() {
		return user_nt_time;
	}
	public void setUser_nt_time(Date user_nt_time) {
		this.user_nt_time = user_nt_time;
	}
	public User getUser_nt_founder() {
		return user_nt_founder;
	}
	public void setUser_nt_founder(User user_nt_founder) {
		this.user_nt_founder = user_nt_founder;
	}
	public User getUser_nt_recender() {
		return user_nt_recender;
	}
	public void setUser_nt_recender(User user_nt_recender) {
		this.user_nt_recender = user_nt_recender;
	}
	public Sx getUser_nt_sx() {
		return user_nt_sx;
	}
	public void setUser_nt_sx(Sx user_nt_sx) {
		this.user_nt_sx = user_nt_sx;
	}
	
	public Notice_mb getUser_nt_mb() {
		return user_nt_mb;
	}

	public void setUser_nt_mb(Notice_mb user_nt_mb) {
		this.user_nt_mb = user_nt_mb;
	}

	@Override
	public String toString() {
		return "User_notice [user_nt_id=" + user_nt_id + ", user_nt_title=" + user_nt_title + ", user_nt_content="
				+ user_nt_content + ", user_nt_time=" + user_nt_time + ", user_nt_founder=" + user_nt_founder
				+ ", user_nt_recender=" + user_nt_recender + ", user_nt_sx=" + user_nt_sx + ", user_nt_mb=" + user_nt_mb
				+ "]";
	}
	
}
