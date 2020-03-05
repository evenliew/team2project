package com.woniu.team2project.service;

import java.util.List;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;

public interface SxDataService {
	// 查询所有事项类型
	List<Sx_type> getAllSx_type();

	// 查询所有区
	List<Area> getAllArea();

	// 查询所有县(根据区)
	List<County> getAllCounty(Integer area_id);

	// 查询所有行业
	List<Industry> getAllIndustry();

	// 查询所有单位
	List<Office> getAllOffice();

	// 查询所有紧急程度
	List<Urgency> getAllUrgency();

	//查领导(根据单位id)
	User getLeaderByOffice_id(Integer office_id);
}
