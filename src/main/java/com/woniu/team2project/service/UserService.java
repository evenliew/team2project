package com.woniu.team2project.service;

import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_role;

@Service
public interface UserService {

	/*
	 * User getSelectBm_leader_idByUserName(String name);
	 * 
	 * Sx getSelectSx(Integer office_id);
	 * 
	 * User selectleaderName(String leader_id);
	 * 
	 * String getSelectPassWordByAccount(String account);
	 */

	//新写的登录
	User login(String user_loginname, String user_pass);
	
	//拿User的角色
	User_role getUser_roleByUser_id(String user_id);
}
