package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_role;

@Mapper
public interface UserMapper {
	
	/*
	 * User selectBm_leader_idByUserName(String name);
	 * 
	 * User selectleaderNameByleander_id(String leader_id);
	 * 
	 * String SelectPassWordByAccount(String account);
	 */
	
	//   以下是重新写的登录。。。。。。。。。。。。。。。。。。。。
	
	//主键查询用户
	User selectUserByUser_id(String user_id);
	
	//查询
	User selectUsernamePassword(String user_loginname,String user_pass);
	
	//查询同一个部门下面的所有员工
	List<User> selectUserByOffice_Id(Integer office_id);
	
	//查询用户角色
	User_role selectUser_roleByUser_id(String user_id);
}
	