package com.woniu.team2project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.User;

@Service
public interface LoginAndRegisteredService {

	User getAllUser(String userName);

	User getAllUserByLoginName(String loginName);

	User getAllUserByPassWord(String user_pass);

	User getAllUserByPhone(String user_phone);

	List<Office> getAllOffice();
	
	void addUser(User user);
}
