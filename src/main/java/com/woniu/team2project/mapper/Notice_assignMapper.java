package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Notice_assign;

/*
 * 对于个人通知分派表表的CURD，
 * 用户不能修改也不能删除，只能查询，新增操作交给了领导新建通告时指定人物的时候生成。
 */
@Mapper
public interface Notice_assignMapper {
	
	//作为新增通报的操作--用户不可单独操作
	void insertNotice_assign(Notice_assign notice_assign);
	
	//作为查询通报的操作--用户不可操作
	Notice_assign selectNotice_assignByNotice_assign_id(
			Integer notice_assign_id);
	
	//通过用户来查询该用户所有的分派通告
	List<Notice_assign> selectNotice_assignByRecender_id(String recender_id);
}
