package com.woniu.team2project.entity;
/**
 * 使用ajax时打回页面的
 * @author Administrator
 *
 */
public class ResponseInfo {

	private int state;
	private Object data;
	private String msg;
	public ResponseInfo(int state, Object data) {
		super();
		this.state = state;
		this.data = data;
	}
	public ResponseInfo(int state, String msg) {
		super();
		this.state = state;
		this.msg = msg;
	}
	public ResponseInfo() {
		super();
	}
	public int getState() {
		return state;
	}
	public Object getData() {
		return data;
	}
	public String getMsg() {
		return msg;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ResponseInfo [state=" + state + ", data=" + data + ", msg=" + msg + "]";
	}
	
	
}
