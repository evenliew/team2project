
package com.woniu.team2project.entity;

import java.util.Date;

/*
 * 通报表，作用：新建的事项要送给部门的消息
 */
public class Tb {
	
	private String tb_id;//通报的id
	private	Date tb_time;//通知发布的时间
	private Office tb_office;//对应接受部门的ID--外键
	private User  tb_author;//作者的id--外键
	private Sx tb_sx;//相关对应事项的id--外键
	private String tb_content;//通知的内容
	public Tb() {
		super();
	}
	public Tb(String tb_id, Date tb_time, Office tb_office, User tb_author, Sx tb_sx, String tb_content) {
		super();
		this.tb_id = tb_id;
		this.tb_time = tb_time;
		this.tb_office = tb_office;
		this.tb_author = tb_author;
		this.tb_sx = tb_sx;
		this.tb_content = tb_content;
	}
	public String getTb_id() {
		return tb_id;
	}
	public void setTb_id(String tb_id) {
		this.tb_id = tb_id;
	}
	public Date getTb_time() {
		return tb_time;
	}
	public void setTb_time(Date tb_time) {
		this.tb_time = tb_time;
	}
	public Office getTb_office() {
		return tb_office;
	}
	public void setTb_office(Office tb_office) {
		this.tb_office = tb_office;
	}
	public User getTb_author() {
		return tb_author;
	}
	public void setTb_author(User tb_author) {
		this.tb_author = tb_author;
	}
	public Sx getTb_sx() {
		return tb_sx;
	}
	public void setTb_sx(Sx tb_sx) {
		this.tb_sx = tb_sx;
	}
	public String getTb_content() {
		return tb_content;
	}
	public void setTb_content(String tb_content) {
		this.tb_content = tb_content;
	}
	@Override
	public String toString() {
		return "Tb [tb_id=" + tb_id + ", tb_time=" + tb_time + ", tb_office=" + tb_office + ", tb_author=" + tb_author
				+ ", tb_sx=" + tb_sx + ", tb_content=" + tb_content + "]";
	}
	
	
}
