package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Sx;

@Mapper
public interface SxMapper {
	void insertSx(Sx sx);//新建事项
	//
	Sx selecttbSx(Integer officeId);
}
