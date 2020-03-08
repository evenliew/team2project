package com.woniu.team2project.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.PageBean;
import com.woniu.team2project.entity.Plan;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_status;
import com.woniu.team2project.service.LoginAndRegisteredService;
import com.woniu.team2project.service.PlanService;

@Controller
public class PlanDelAndAddAndUpdaColltrollet {

	@Autowired
	PlanService planService;

	@Autowired
	LoginAndRegisteredService res;
	
	@RequestMapping("/delect")
	public String planDelect(String[] plan_id, Plan plan, Integer pageIndex, Model model) {
		planService.removePlanByid(plan_id);
		Integer pageSize = 3;
		PageBean<Plan> pb = planService.pagebeanList(plan, pageIndex, pageSize);
		model.addAttribute("pb", pb);
		return "work";

	}

	// 新增前置方法
	@RequestMapping("/addplan")
	public String selectAllPlanByPage(Plan plan,
			HttpSession session,Integer pageIndex, Model model, String realName) {
		List<Office> offs = res.getAllOffice();
		Integer pageSize=3;
		Object officeid = session.getAttribute("officeid");
		PageBean<Plan> pb = planService.pagebeanList(plan, pageIndex, pageSize);
		model.addAttribute("offs", offs);
		model.addAttribute("pb", pb);
		return "noticeAdd";

	}

	@RequestMapping("/planadds")
	public String addPlan(Model model, Plan plan,
			String plan_founder_id,String plan_sx_id,HttpServletRequest req) {
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("loginname"));
		System.out.println(session.getAttribute("username"));
		
		System.out.println(plan);
		return "login";
	}

}
