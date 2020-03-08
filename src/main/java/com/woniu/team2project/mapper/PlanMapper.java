package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniu.team2project.entity.Plan;
import com.woniu.team2project.entity.Sx;

@Mapper
public interface PlanMapper {
	
	List<Plan> seleListplans(String leader_id);
	
	//分页数据
	List<Plan> selectAllPlansByPage(@Param("plan") Plan plan,@Param("pageIndex")
	Integer pageIndex,@Param("pageSize") Integer pageSize);
	Integer selectAllPlanByPageCount(@Param("plan") Plan plan);

	void delectPlanByid(String string);
	
	List<Plan> selectAllPlanByoffice(Integer office_id); 
	
}
