package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_notice;

/*
 * 对于个人通告表的增删改查：CURD，
 * 用户只能查询新增，不能删除更改
 */
@Mapper
public interface User_noticeMapper {
	//事项成立，或者事项审批之后发送通告
	void sendUser_notice(Sx sx,Integer mb_id);
	//作为新增个人通告的操作--可操作
	void insertUser_notice(User_notice user_notice);
	
	//查询当前登录用户的发布的个人通告
	List<User_notice> selectUser_noticeByUserFb(String user_id);
	
	//查询当前登录用户的发布的个人通告
	List<User_notice> selectUser_noticeByUserRe(String user_id);
	
	//作为查询个人通告的操作--用户可操作
	User_notice selectUser_noticeByUser_notice_id(Integer User_nt_id);
	
	//查询所有的个人通告---管理员或者领导课操作
	List<User_notice> selectAllUser_notice();
	
	//根据条件查询个人通告
	List<User_notice> selectUser_noticeByCondition(User_notice notice);
	
	//删除个人通告表
	void deleteUser_notice(Integer user_nt_id);
}
