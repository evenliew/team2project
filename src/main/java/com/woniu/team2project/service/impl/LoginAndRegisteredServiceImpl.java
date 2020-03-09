package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.mapper.LoginAndRegisteredMapper;
import com.woniu.team2project.service.LoginAndRegisteredService;

@Service
public class LoginAndRegisteredServiceImpl implements LoginAndRegisteredService{

	@Autowired
	LoginAndRegisteredMapper res;
	
	//验证昵称是否被注册
	@Override
	public User getAllUser(String userName) {
		
		return res.selectAllUser(userName);
	}
	//验证用户名是否被注册
	@Override
	public User getAllUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return res.selectAllUserByLoginName(loginName);
	}
	//验证密码是否被注册
	@Override
	public User getAllUserByPassWord(String user_pass) {
		return res.selectAllUserByPassWord(user_pass);
	}
	//验证号码是否被注册
	@Override
	public User getAllUserByPhone(String user_phone) {
		// TODO Auto-generated method stub
		return res.selectAllUserByphone(user_phone);
	}
	//查询所有单位。回显到注册页面
	@Override
	public List<Office> getAllOffice() {

		return res.selectAllOffice();
	}
	@Override
	public void addUser(User user) {

		res.insertUser(user);
	}

	
}
