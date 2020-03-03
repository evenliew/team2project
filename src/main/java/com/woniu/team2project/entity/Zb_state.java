package com.woniu.team2project.entity;
/**
 * 这是专报的状态表--专报的外键依赖
 * @author 59255
 *
 */
public class Zb_state {
	private Integer zb_state_id;//状态id--主键
	private String zb_state_name;//状态的信息
	public Zb_state() {
		super();
	}
	public Zb_state(Integer zb_state_id, String zb_state_name) {
		super();
		this.zb_state_id = zb_state_id;
		this.zb_state_name = zb_state_name;
	}
	public Integer getZb_state_id() {
		return zb_state_id;
	}
	public void setZb_state_id(Integer zb_state_id) {
		this.zb_state_id = zb_state_id;
	}
	public String getZb_state_name() {
		return zb_state_name;
	}
	public void setZb_state_name(String zb_state_name) {
		this.zb_state_name = zb_state_name;
	}
	@Override
	public String toString() {
		return "Zb_state [zb_state_id=" + zb_state_id + ", zb_state_name=" + zb_state_name + "]";
	}
	
}
