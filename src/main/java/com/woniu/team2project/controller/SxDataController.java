package com.woniu.team2project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.SxDataService;

@Controller
public class SxDataController {
	
	@Autowired
	SxDataService sxDataService;
	
	//ajax刷 事项类型 下拉框
	@ResponseBody
	@RequestMapping("/allsx_type")
	public List<Sx_type> getAllSxType() {
		List<Sx_type> allSx_type = sxDataService.getAllSx_type();
		return allSx_type;
	}
	//ajax刷 区 下拉框
	@ResponseBody
	@RequestMapping("/allarea")
	public List<Area> getAllArea() {
		List<Area> areas = sxDataService.getAllArea();
		return areas;
	}
	//ajax刷 县 下拉框
	@ResponseBody
	@RequestMapping("/allcounty")
	public List<County> getAllCounty(Integer area_id) {
		List<County> countys = sxDataService.getAllCounty(area_id);
		return countys;
	}
	//ajax刷 行业 下拉框
	@ResponseBody
	@RequestMapping("/allindustry")
	public List<Industry> getAllIndustry() {
		List<Industry> allIndustry = sxDataService.getAllIndustry();
		return allIndustry;
	}
	//ajax刷 单位 下拉框
	@ResponseBody
	@RequestMapping("/alloffice")
	public List<Office> getAllOffice() {
		List<Office> allOffice = sxDataService.getAllOffice();
		return allOffice;
	}
	//ajax刷 紧急程度 下拉框
	@ResponseBody
	@RequestMapping("/allurgency")
	public List<Urgency> getAllUrgency() {
		List<Urgency> allUrgency = sxDataService.getAllUrgency();
		return allUrgency;
	}
	//查领导(根据单位id)
	@ResponseBody
	@RequestMapping("/getLeaderByOffice_id")
	public User getLeaderByOffice_id(Integer office_id) {
		User leader = sxDataService.getLeaderByOffice_id(office_id);
		return leader;
	}
	
}
