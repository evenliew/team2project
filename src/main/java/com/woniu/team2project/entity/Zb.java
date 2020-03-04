package com.woniu.team2project.entity;

import java.util.Date;

/**
 * 专报：人对人，需要修改状态，理解为通知，查看过后可以修改状态
 * 提示在页面的状态--0为未查看，1为已查看
 * @author 9468
 *
 */
public class Zb {
	private String zb_id;//专报id---主键
	private Date zb_sb_time;//发布时间-
	private String zb_content;//具体内容
	private String zb_remark;//备注内容
	private Date zb_ps_time;//该专报批示的时间
	private Zb_state zb_state;//状态id--外键--对应状态表
	private User zb_founder;//创建该专报的用户--外键--对应用户表
	private User zb_recender;//接受该专报的用户--外键--对应用户表
	private Sx zb_sx;//相关事项--外键--对应事项表
	public Zb() {
		super();
	}
	public Zb(String zb_id, Date zb_sb_time, String zb_content, String zb_remark, Date zb_ps_time, Zb_state zb_state,
			User zb_founder, User zb_recender, Sx zb_sx) {
		super();
		this.zb_id = zb_id;
		this.zb_sb_time = zb_sb_time;
		this.zb_content = zb_content;
		this.zb_remark = zb_remark;
		this.zb_ps_time = zb_ps_time;
		this.zb_state = zb_state;
		this.zb_founder = zb_founder;
		this.zb_recender = zb_recender;
		this.zb_sx = zb_sx;
	}
	public String getZb_id() {
		return zb_id;
	}
	public void setZb_id(String zb_id) {
		this.zb_id = zb_id;
	}
	public Date getZb_sb_time() {
		return zb_sb_time;
	}
	public void setZb_sb_time(Date zb_sb_time) {
		this.zb_sb_time = zb_sb_time;
	}
	public String getZb_content() {
		return zb_content;
	}
	public void setZb_content(String zb_content) {
		this.zb_content = zb_content;
	}
	public String getZb_remark() {
		return zb_remark;
	}
	public void setZb_remark(String zb_remark) {
		this.zb_remark = zb_remark;
	}
	public Date getZb_ps_time() {
		return zb_ps_time;
	}
	public void setZb_ps_time(Date zb_ps_time) {
		this.zb_ps_time = zb_ps_time;
	}
	public Zb_state getZb_state() {
		return zb_state;
	}
	public void setZb_state(Zb_state zb_state) {
		this.zb_state = zb_state;
	}
	public User getZb_founder() {
		return zb_founder;
	}
	public void setZb_founder(User zb_founder) {
		this.zb_founder = zb_founder;
	}
	public User getZb_recender() {
		return zb_recender;
	}
	public void setZb_recender(User zb_recender) {
		this.zb_recender = zb_recender;
	}
	public Sx getZb_sx() {
		return zb_sx;
	}
	public void setZb_sx(Sx zb_sx) {
		this.zb_sx = zb_sx;
	}
	@Override
	public String toString() {
		return "Zb [zb_id=" + zb_id + ", zb_sb_time=" + zb_sb_time + ", zb_content=" + zb_content + ", zb_remark="
				+ zb_remark + ", zb_ps_time=" + zb_ps_time + ", zb_state=" + zb_state + ", zb_founder=" + zb_founder
				+ ", zb_recender=" + zb_recender + ", zb_sx=" + zb_sx + "]";
	}
	
	
}
