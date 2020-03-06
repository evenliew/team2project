package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Tb;

/*
 * 对于通报表的增删改查：CURD，
 * 用户不能修改已发布的通告，也不能删除，只能查询和新增
 */
@Mapper
public interface TbMapper {
	void insertTb(Tb tb);//作为新增通报的操作--用户可操作
	
	Tb selectTbByTb_id(String tb_id);//作为查询通报的操作--用户可操作
	
	List<Tb> selectAllTbs();//查询所有通报。
	
	List<Tb> selectByCondition(Tb tb);//根据条件查询所有通报
	
	void deleteTb(String tb_id);//删除通报
	
}
