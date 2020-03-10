package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx_status;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.exception.SxDataException;
import com.woniu.team2project.exception.SxException;
import com.woniu.team2project.mapper.SxDataMapper;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.service.SxDataService;


@Service
public class SxDataServiceImpl implements SxDataService{

	@Autowired
	SxMapper sxMapper;
	
	@Autowired
	SxDataMapper sxDataMapper;
	
	//查事项类型
	public List<Sx_type> getAllSx_type() {
		try {
			List<Sx_type> types = sxDataMapper.selectSx_type();
			return types;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}
	
	//查询所有区
	public List<Area> getAllArea() {
		try {
			List<Area> areas=sxDataMapper.selectArea();
			return areas;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}
	
	//查询所有县(根据区id)
	public List<County> getAllCounty(Integer area_id) {
		try {
			List<County> countys = sxDataMapper.selectCountyByArea_id(area_id);
			return countys;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}
	
	//查询所有行业
	public List<Industry> getAllIndustry() {
		try {
			List<Industry> industrys = sxDataMapper.selectIndustry();
			return industrys;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}
	
	//查询所有单位
	public List<Office> getAllOffice() {
		try {
			List<Office> offices = sxDataMapper.selectOffice();
			return offices;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}

	//查询所有紧急程度
	public List<Urgency> getAllUrgency() {
		try {
			List<Urgency> urgencys = sxDataMapper.selectUrgency();
			return urgencys;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}
	//查领导(根据单位id)
	public User getLeaderByOffice_id(Integer office_id) {
		try {
			User leader = sxDataMapper.selectLeaderByOffice_id(office_id);
			return leader;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}
	//查询所有进度
	@Override
	public List<Sx_status> getAllSx_status() {
		try {
			List<Sx_status> statuses = sxDataMapper.selectSx_status();
			return statuses;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxDataException("系统维护中");
		}
	}
}
