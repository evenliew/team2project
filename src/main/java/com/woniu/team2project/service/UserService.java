package com.woniu.team2project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;

@Service
public interface UserService {

	//查询部门下的员工
	List<User>  getUsersByOffice_id(Integer office_id);
	
	User getSelectBm_leader_idByUserName(String name);
	
	Sx getSelectSx(Integer office_id);
	
	User selectleaderName(String leader_id);

	String getSelectPassWordByAccount(String account);
}
