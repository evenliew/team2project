package com.woniu.team2project.entity;
/*
 * 个人通知分派：发送给个人的通知分派信息
 */
public class Notice_assign {
	private Integer notice_assign_id;//个人通知分派表--主键
	private String recender_id;//接受者id--外键对应表的主键
	private String notice_id;//对应接受的通告id--外键对应表的主键
	
	private User recender;//接受者id--外键
	private Tb notice;//对应接受的通告id--外键
	public Notice_assign() {
		super();
	}
	
	public Notice_assign(Integer notice_assign_id, String recender_id, String notice_id) {
		super();
		this.notice_assign_id = notice_assign_id;
		this.recender_id = recender_id;
		this.notice_id = notice_id;
	}

	public Integer getNotice_assign_id() {
		return notice_assign_id;
	}
	public void setNotice_assign_id(Integer notice_assign_id) {
		this.notice_assign_id = notice_assign_id;
	}
	public String getRecender_id() {
		return recender_id;
	}
	public void setRecender_id(String recender_id) {
		this.recender_id = recender_id;
	}
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public User getRecender() {
		return recender;
	}
	public void setRecender(User recender) {
		this.recender = recender;
	}
	public Tb getNotice() {
		return notice;
	}
	public void setNotice(Tb notice) {
		this.notice = notice;
	}
	@Override
	public String toString() {
		return "Notice_assign [notice_assign_id=" + notice_assign_id + ", recender=" + recender + ", notice=" + notice
				+ "]";
	}
	
	
}
