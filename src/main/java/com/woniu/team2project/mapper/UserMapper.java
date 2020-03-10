package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.woniu.team2project.entity.User;

@Mapper
public interface UserMapper {
	
	
	
	User selectBm_leader_idByUserName(String name);
	User selectleaderNameByleander_id(String leader_id);
	String SelectPassWordByAccount(String account);
}
