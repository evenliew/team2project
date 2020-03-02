package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniu.team2project.entity.Sx;

public interface SxMapper {
	//新建事项
	void insertSx(Sx sx);
	
	//条件查询事项
	List<Sx> selectSxByConditionPage(Sx sx);
}