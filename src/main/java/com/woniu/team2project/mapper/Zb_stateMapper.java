package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Zb_state;

/*
 * 对于专报状态表的增删改查的mapper层：CURD，
 * 用户不能新增、删除，只有管理员权限可以新增、删除。用户可以查询
 */
@Mapper
public interface Zb_stateMapper {
	void insertZb_state(Zb_state zb_state);//作为新增专报状态的操作
	Zb_state selectZb_stateByZb_state_id(Integer zb_state_id);//作为查询专报的操作--用户可操作
	//修改专报的状态。具体几种状态 未定
	List<Zb_state> selectAllZb_state_id();//查询目前所有的状态
}
