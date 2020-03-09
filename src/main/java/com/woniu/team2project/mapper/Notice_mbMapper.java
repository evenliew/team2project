package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Notice_mb;

@Mapper
public interface Notice_mbMapper {
	Notice_mb selectNotice_mbByNotice_mb_id(Integer notice_mb_id);
	List<Notice_mb> selectAllNotice_mb();
}
