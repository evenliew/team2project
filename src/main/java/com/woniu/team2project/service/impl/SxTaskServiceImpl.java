package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Sx_task;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.mapper.SxTaskMapper;
import com.woniu.team2project.service.SxTaskService;

@Service
public class SxTaskServiceImpl implements SxTaskService{
	@Autowired
	SxTaskMapper sxTaskMapper;

	//查询用户的子任务
	public List<Sx_task> getMyTask(User user) {
		List<Sx_task> tasks = sxTaskMapper.selectTaskByUser_id(user.getUser_id());
		return tasks;
	}
	
	//根据用户id查单位id
	public Integer getOffice_idByUser_id(String user_id) {
		Integer office_id = sxTaskMapper.selectOffice_idByUser_id(user_id);
		return office_id;
	}

	//查询单位所有子任务
	public List<Sx_task> getMyOfficeTask(Integer office_id) {
		List<Sx_task> tasks = sxTaskMapper.selectTaskByOffice_id(office_id);
		return tasks;
	}

	//查询所有子任务
	public List<Sx_task> getAllTask() {
		List<Sx_task> alltask = sxTaskMapper.selectAllTask();
		return alltask;
	}

	//根据子任务id查询子任务
	public Sx_task getSx_taskBySx_task_id(String sx_task_id) {
		Sx_task task = sxTaskMapper.selectTaskByTask_id(sx_task_id);
		return task;
	}
	
	//根据单位查所有user
	public List<User> getallUserByOffice_id(Integer office_id) {
		List<User> users = sxTaskMapper.selectAllUserByOffice_id(office_id);
		return users;
	}

	//更改子任务
	public void modifyTask(Sx_task sx_task) {
		sxTaskMapper.updateTask(sx_task);
	}

	//删除子任务
	public void removeTask(String sx_task_id) {
		sxTaskMapper.deleteTask(sx_task_id);
	}
	
}
