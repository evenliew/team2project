package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.PageBean;
import com.woniu.team2project.entity.Plan;
import com.woniu.team2project.mapper.PlanMapper;
import com.woniu.team2project.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	PlanMapper planMapper;
	
	
	@Override
	public List<Plan> getPlans(String leader_id) {
		
		return planMapper.seleListplans(leader_id);
	}

	@Override
	public PageBean<Plan> pagebeanList(Plan plan, Integer pageIndex, Integer pageSize) {
	
		
		Integer totalRecord = planMapper.selectAllPlanByPageCount(plan);
		List<Plan> beanlist = 
					planMapper.selectAllPlansByPage(plan, (pageIndex-1)*pageSize, pageSize);
		
		PageBean<Plan> pb=new PageBean<Plan>();
		Integer totalPage=(totalRecord%pageSize==0)?totalRecord/pageSize:totalRecord/pageSize+1;
		pb.setTotalPage(totalPage);
		pb.setBeanList(beanlist);
		pb.setTotalRecord(totalRecord);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		return pb;
	}
}
