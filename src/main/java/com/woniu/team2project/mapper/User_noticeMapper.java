package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.User_notice;

/*
 * 对于个人通告表的增删改查：CURD，
 * 用户只能查询新增，不能删除更改
 */
@Mapper
public interface User_noticeMapper {
	
	//作为新增个人通告的操作--可操作
	void insertUser_notice(User_notice user_notice);
	
	//作为查询个人通告的操作--用户可操作
	User_notice selectUser_noticeByUser_notice_id(Integer User_nt_id);
	
	//查询所有的个人通告---管理员或者领导课操作
	List<User_notice> selectAllUser_notice();
}
