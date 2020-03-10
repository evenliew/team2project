package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.woniu.team2project.entity.User;

@Mapper
public interface UserMapper {
	//查询同一个部门下面的所有员工
	List<User> selectUserByOffice_Id(Integer office_id);
	
	User selectBm_leader_idByUserName(String name);
	User selectleaderNameByleander_id(String leader_id);
	String SelectPassWordByAccount(String account);
}
