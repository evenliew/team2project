package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx_status;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.mapper.SxDataMapper;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.service.SxDataService;


@Service
public class SxDataServiceImpl implements SxDataService{

	@Autowired
	SxMapper sxMapper;
	
	@Autowired
	SxDataMapper sxDataMapper;
	//@Transactional
	//@Override
	//方法写这里
	
	//查事项类型
	public List<Sx_type> getAllSx_type() {
		List<Sx_type> types = sxDataMapper.selectSx_type();
		return types;
	}
	//查询所有区
	public List<Area> getAllArea() {
		List<Area> areas=sxDataMapper.selectArea();
		return areas;
	}
	//查询所有县(根据区id)
	public List<County> getAllCounty(Integer area_id) {
		List<County> countys = sxDataMapper.selectCountyByArea_id(area_id);
		return countys;
	}
	//查询所有行业
	public List<Industry> getAllIndustry() {
		List<Industry> industrys = sxDataMapper.selectIndustry();
		return industrys;
	}
	//查询所有单位
	public List<Office> getAllOffice() {
		List<Office> offices = sxDataMapper.selectOffice();
		return offices;
	}

	//查询所有紧急程度
	public List<Urgency> getAllUrgency() {
		List<Urgency> urgencys = sxDataMapper.selectUrgency();
		return urgencys;
	}
	//查领导(根据单位id)
	public User getLeaderByOffice_id(Integer office_id) {
		User leader = sxDataMapper.selectLeaderByOffice_id(office_id);
		return leader;
	}
	//查询所有进度
		@Override
		public List<Sx_status> getAllSx_status() {
			List<Sx_status> statuses = sxDataMapper.selectSx_status();
			return statuses;
		}
}
