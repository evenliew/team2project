package com.woniu.team2project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.Session;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	//三块框架信息
	@RequestMapping("/top")
	public String appTop(Model model) {
		return "system/index/top";
	}
	@RequestMapping("/menu")
	public String appMenu(Model model) {
		return "system/index/menu";
	}
	@RequestMapping("/content")
	public String appContent(Model model) {
		return "system/index/content";
	}
	
	//登录已经请求主页
	@RequestMapping("/user")
	public String selectByleadid(Model model,String account,String password,HttpSession session) {
		User user = userService.getSelectBm_leader_idByUserName(account);
		String loginname = user.getUser_loginname();//登录账号
		String username = user.getUser_name();//昵称
		System.out.println(loginname);
		System.out.println(username);
		if (user!=null) {
			String pass = userService.getSelectPassWordByAccount(account);
			model.addAttribute("ssssss",account);
			if (pass.equals(password)) {
				session.setAttribute("loginname",loginname);
				session.setAttribute("username", username);
				return "system/index/index";
			}else {
				model.addAttribute("msg","您的密码不正确");
				model.addAttribute("u",account);
				return "login";
			}
		}
		return "system/index/index";
	}
	//点击月度计划，进入页面
	@RequestMapping("/userss")
	public String selectPlanAll(Model model) {
		List<Object> listss=new ArrayList<Object>();
		//返回用户的基本信息
		User users = userService.getSelectBm_leader_idByUserName("666");
		//通过用户的单位id查询出对应的事务
//		Integer office_id = users.getOffice().getOffice_id();
//		Sx selectSx = userService.getSelectSx(office_id);
//		//通过用户对应的单位id，查出对应的领导id，再用领导id查询出领导用户的基本信息
//		String leader_id = users.getOffice().getOffice_leader_id();
//		User leanders = userService.selectleaderName(leader_id);
		
		
		listss.add(users);
		//listss.add(selectSx);
		//lists.add(leanders);
		model.addAttribute("listss",listss);
		return "work";
	}
}
