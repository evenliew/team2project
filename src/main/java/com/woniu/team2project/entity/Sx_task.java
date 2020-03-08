package com.woniu.team2project.entity;

import java.util.Date;

public class Sx_task {
	private String sx_task_id;//子任务id
	private String sx_task_name;//子任务名字
	private String sx_task_content;//子任务内容
	private User worker;//子任务接收者
	private Date sx_task_time;//子任务开始时间
	private Integer sx_task_status_id;//子任务状态（假删除）
	private Sx sx;//关联的事项id
	public Sx_task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sx_task(String sx_task_id, String sx_task_name, String sx_task_content, User worker, Date sx_task_time,
			Integer sx_task_status_id, Sx sx) {
		super();
		this.sx_task_id = sx_task_id;
		this.sx_task_name = sx_task_name;
		this.sx_task_content = sx_task_content;
		this.worker = worker;
		this.sx_task_time = sx_task_time;
		this.sx_task_status_id = sx_task_status_id;
		this.sx = sx;
	}
	public String getSx_task_id() {
		return sx_task_id;
	}
	public void setSx_task_id(String sx_task_id) {
		this.sx_task_id = sx_task_id;
	}
	public String getSx_task_name() {
		return sx_task_name;
	}
	public void setSx_task_name(String sx_task_name) {
		this.sx_task_name = sx_task_name;
	}
	public String getSx_task_content() {
		return sx_task_content;
	}
	public void setSx_task_content(String sx_task_content) {
		this.sx_task_content = sx_task_content;
	}
	public User getWorker() {
		return worker;
	}
	public void setWorker(User worker) {
		this.worker = worker;
	}
	public Date getSx_task_time() {
		return sx_task_time;
	}
	public void setSx_task_time(Date sx_task_time) {
		this.sx_task_time = sx_task_time;
	}
	public Integer getSx_task_status_id() {
		return sx_task_status_id;
	}
	public void setSx_task_status_id(Integer sx_task_status_id) {
		this.sx_task_status_id = sx_task_status_id;
	}
	public Sx getSx() {
		return sx;
	}
	public void setSx(Sx sx) {
		this.sx = sx;
	}
	@Override
	public String toString() {
		return "Sx_task [sx_task_id=" + sx_task_id + ", sx_task_name=" + sx_task_name + ", sx_task_content="
				+ sx_task_content + ", worker=" + worker + ", sx_task_time=" + sx_task_time + ", sx_task_status_id="
				+ sx_task_status_id + ", sx=" + sx + "]";
	}
	
	
}
