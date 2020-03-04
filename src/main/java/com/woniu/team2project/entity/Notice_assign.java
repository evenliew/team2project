package com.woniu.team2project.entity;
/*
 * 个人通知分派：发送给个人的通知分派信息
 */
public class Notice_assign {
	private Integer notice_assign_id;//个人通知分派表--主键
	private User recender;//接受者id--外键
	private Notice notice;//对应接受的通告id--外键
	public Notice_assign() {
		super();
	}
	public Notice_assign(Integer notice_assign_id, User recender, Notice notice) {
		super();
		this.notice_assign_id = notice_assign_id;
		this.recender = recender;
		this.notice = notice;
	}
	public Integer getNotice_assign_id() {
		return notice_assign_id;
	}
	public void setNotice_assign_id(Integer notice_assign_id) {
		this.notice_assign_id = notice_assign_id;
	}
	public User getRecender() {
		return recender;
	}
	public void setRecender(User recender) {
		this.recender = recender;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	@Override
	public String toString() {
		return "Notice_assign [notice_assign_id=" + notice_assign_id + ", recender=" + recender + ", notice=" + notice
				+ "]";
	}
	
}
