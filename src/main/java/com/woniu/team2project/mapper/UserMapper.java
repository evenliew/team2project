package com.woniu.team2project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.User;

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
	
	//查询
	User selectUsernamePassword(String user_loginname,String user_pass);
}
