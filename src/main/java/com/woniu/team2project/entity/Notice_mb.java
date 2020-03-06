package com.woniu.team2project.entity;

public class Notice_mb {
	private Integer notice_mb_id;
	private String notice_mb_name;
	private String notice_mb_content;
	public Notice_mb() {
		super();
	}
	
	public Notice_mb(Integer notice_mb_id, String notice_mb_name, String notice_mb_content) {
		super();
		this.notice_mb_id = notice_mb_id;
		this.notice_mb_name = notice_mb_name;
		this.notice_mb_content = notice_mb_content;
	}

	public Integer getNotice_mb_id() {
		return notice_mb_id;
	}

	public void setNotice_mb_id(Integer notice_mb_id) {
		this.notice_mb_id = notice_mb_id;
	}

	public String getNotice_mb_name() {
		return notice_mb_name;
	}
	public void setNotice_mb_name(String notice_mb_name) {
		this.notice_mb_name = notice_mb_name;
	}
	public String getNotice_mb_content() {
		return notice_mb_content;
	}
	public void setNotice_mb_content(String notice_mb_content) {
		this.notice_mb_content = notice_mb_content;
	}

	@Override
	public String toString() {
		return "Notice_mb [notice_mb_id=" + notice_mb_id + ", notice_mb_name=" + notice_mb_name + ", notice_mb_content="
				+ notice_mb_content + "]";
	}
	
}
