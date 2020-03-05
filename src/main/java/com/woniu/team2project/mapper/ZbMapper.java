package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniu.team2project.entity.Zb;

/*
 * 对于专报表的增删改查：CURD，
 * 用户只能修改已发布的专报的状态，只能查询和新增，不能删除，
 */
@Mapper
public interface ZbMapper {
	
	//作为新增专报的操作--用户可操作
	void insertZb(Zb zb);
	
	//作为查询专报的操作--用户可操作
	Zb selectZbByZb_id(String zb_id);
	
	//修改专报的状态。具体几种状态 未定
	void updateZb_state(@Param("zb_id") String zb_id,
			@Param("zb_state_id") Integer zb_state_id);
	
	//查询所有的专报
	List<Zb> selectAllZb();
}
