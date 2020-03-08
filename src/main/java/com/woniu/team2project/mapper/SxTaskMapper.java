package com.woniu.team2project.mapper;

import java.util.List;

import com.woniu.team2project.entity.Sx_task;
import com.woniu.team2project.entity.User;

//事项子任务
public interface SxTaskMapper {
	//新建子任务
	void insertTask(Sx_task sx_task);
	
	//修改子任务
	void updateTask(Sx_task sx_task);
	
	//删除子任务
	void deleteTask(String sx_task_id);
	
	//根据子任务id查询子任务
	Sx_task selectTaskByTask_id(String sx_task_id);
	
	//根据事项id查询子任务
	List<Sx_task> selectTask(String sx_id);
	
	//根据用户查子任务
	List<Sx_task> selectTaskByUser_id(String user_id);
	
	//根据用户查单位id。。。。没得usermapper就写这里了
	Integer selectOffice_idByUser_id(String user_id);
	
	//查登录用户单位所有子任务
	List<Sx_task> selectTaskByOffice_id(Integer office_id);
	
	//查所有子任务
	List<Sx_task> selectAllTask();
	
	//根据单位查所有用户
	List<User> selectAllUserByOffice_id(Integer office_id);
	
}
