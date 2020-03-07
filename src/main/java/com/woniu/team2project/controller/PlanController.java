package com.woniu.team2project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.team2project.entity.PageBean;
import com.woniu.team2project.entity.Plan;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.PlanService;
import com.woniu.team2project.service.UserService;

@Controller
public class PlanController {

	@Autowired
	PlanService planService;
	@Autowired
	UserService userService;
	//点击月度计划，进入页面
//	@RequestMapping("/users")
//	public String selectPlanAll(Model model) {
//		List<Object> listss=new ArrayList<Object>();
//		//返回用户的基本信息
//		User users = userService.getSelectBm_leader_idByUserName("666");
//		String leader_id = users.getOffice().getOffice_leader_id();
//		List<Plan> plans = planService.getPlans(leader_id);
//		//listss.add(selectSx);
//		//lists.add(leanders);
//		model.addAttribute("plans",plans);
//		return "work";
//	}
	//主页查询所有的计划信息并分页
	@RequestMapping("/users")
	public String selectAllPlanByPage(Plan plan,Integer 
			pageIndex,Model model,String realName) {
		Integer pageSize=3;
		PageBean<Plan> pb = planService.pagebeanList(plan, pageIndex, pageSize);
		System.out.println(pb);
		model.addAttribute("pb",pb);
		return "work";
		
	}
	///根据条件查询
	@RequestMapping("/like")
	public String selectAllPlanBy(Integer 
			pageIndex,Model model,String realName) {
		
		 Integer pageSize=10;
	
		Plan plan=new Plan();
		plan.setPlan_content(realName);
		
		PageBean<Plan> pb = planService.pagebeanList(plan, pageIndex, pageSize);
		System.out.println(pb);
		model.addAttribute("pb",pb);
		return "work2";
		
	}
	
	//根据计划id查询
	
	 
	 
}
