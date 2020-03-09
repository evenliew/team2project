package com.woniu.team2project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.PageBean;
import com.woniu.team2project.entity.Plan;

@Service
public interface PlanService {

	List<Plan> getPlans(String leader_id);
	PageBean<Plan> pagebeanList(Plan plan,Integer pageIndex,Integer pageSize);
	void removePlanByid(String[] plan_id);
	List<Plan> getAllPlanByoffice(Integer office_id);
	void planAdd(Plan plan);
}
