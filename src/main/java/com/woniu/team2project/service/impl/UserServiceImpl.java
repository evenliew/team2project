package com.woniu.team2project.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.mapper.UserMapper;
import com.woniu.team2project.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	SxMapper sxMapper;
	
	
	
	User user;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	
	//根据登录以后域属性里面的用户名，查询出所有的用户信息
	@Override
	public User getSelectBm_leader_idByUserName(String name) {
		user = userMapper.selectBm_leader_idByUserName(name);
		return user;
	}

	//根据用户信息里面的单位查询出对应的事项信息
	@Override
	public Sx getSelectSx(Integer office_id) {
		
		return sxMapper.selecttbSx(office_id);
	}
	

	//根据用户里面的单位id查询出领导id，再通过领导id在用户表里面查询出领导的用户信息
	@Override
	public User selectleaderName(String leader_id) {
		
		return userMapper.selectleaderNameByleander_id(leader_id);
	}

	@Override
	public String getSelectPassWordByAccount(String account) {

		return  userMapper.SelectPassWordByAccount(account);
	}
	//查询部门下的员工
	@Override
	public List<User> getUsersByOffice_id(Integer office_id) {
		return userMapper.selectUserByOffice_Id(office_id);
	}

	

	




}
