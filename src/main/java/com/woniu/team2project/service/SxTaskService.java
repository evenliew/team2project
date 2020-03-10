package com.woniu.team2project.service;

import java.util.List;

import com.woniu.team2project.entity.Sx_task;
import com.woniu.team2project.entity.User;

public interface SxTaskService {
	//查询我的子任务
	List<Sx_task> getMyTask(User user);
	
	//根据用户id查单位id
	Integer getOffice_idByUser_id(String user_id);

	//查询单位所有子任务
	List<Sx_task> getMyOfficeTask(Integer office_id);

	//查询所有子任务
	List<Sx_task> getAllTask();
	
	//根据子任务id查询子任务
	Sx_task getSx_taskBySx_task_id(String sx_task_id);

	//根据单位查所有user
	List<User> getallUserByOffice_id(Integer office_id);
	
	//更改子任务
	void modifyTask(Sx_task sx_task);
	
	//删除子任务
	void removeTask(String sx_task_id);

	//新建子任务
	void addTask(Sx_task sx_task);
}
