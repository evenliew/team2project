package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.User;

@Mapper
public interface LoginAndRegisteredMapper {
	//验证昵称是否被注册
	User selectAllUser(String userName);
	//验证用户名是否被注册
	User selectAllUserByLoginName(String loginName);
	//验证密码是否被注册
	User selectAllUserByPassWord(String user_pass);
	//验证号码是否被注册
	User selectAllUserByphone(String user_phone);
	//查询所有单位。回显到注册页面
	List<Office> selectAllOffice();
	//注册成功添加用户
	void insertUser(User user);
}
