package com.woniu.team2project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	/*
	 * @Autowired UserService userService;
	 * 
	 * //三块框架信息
	 * 
	 * @RequestMapping("/top") public String appTop(Model model) { return
	 * "system/index/top"; }
	 * 
	 * @RequestMapping("/menu") public String appMenu(Model model) { return
	 * "system/index/menu"; }
	 * 
	 * @RequestMapping("/content") public String appContent(Model model) { return
	 * "system/index/content"; }
	 * 
	 * //登录已经请求主页
	 * 
	 * @RequestMapping("/user") public String selectByleadid(Model model,String
	 * account,String password,HttpSession session) { User user =
	 * userService.getSelectBm_leader_idByUserName(account);//通过账号
	 * System.out.println(user+"111222"); String loginname = null; String username =
	 * null; String userid=null; Integer officeid=null; if (user!=null) { loginname
	 * = user.getUser_loginname();//登录账号 username = user.getUser_name();//昵称
	 * userid=user.getUser_id(); officeid=user.getOffice().getOffice_id(); String
	 * pass = userService.getSelectPassWordByAccount(account);
	 * model.addAttribute("ssssss",account); if (pass.equals(password)) {
	 * session.setAttribute("loginname",loginname); session.setAttribute("username",
	 * username); session.setAttribute("userid", userid);
	 * session.setAttribute("officeid", officeid); return "system/index/index";
	 * }else { model.addAttribute("msg","您的密码有误"); model.addAttribute("u",account);
	 * return "login"; } }else { model.addAttribute("msg","您的账号有误"); return "login";
	 * }
	 * 
	 * 
	 * 
	 * } //点击月度计划，进入页面
	 * 
	 * @RequestMapping("/userss") public String selectPlanAll(Model model) {
	 * List<Object> listss=new ArrayList<Object>(); //返回用户的基本信息 User users =
	 * userService.getSelectBm_leader_idByUserName("666"); //通过用户的单位id查询出对应的事务 //
	 * Integer office_id = users.getOffice().getOffice_id(); // Sx selectSx =
	 * userService.getSelectSx(office_id); //
	 * //通过用户对应的单位id，查出对应的领导id，再用领导id查询出领导用户的基本信息 // String leader_id =
	 * users.getOffice().getOffice_leader_id(); // User leanders =
	 * userService.selectleaderName(leader_id);
	 * 
	 * 
	 * listss.add(users); //listss.add(selectSx); //lists.add(leanders);
	 * model.addAttribute("listss",listss); return "work"; }
	 */
	
	//以下是新写的登录*************************************************
	@RequestMapping("/newlogin")
	public String login(HttpSession session,Model model,String user_loginname,String user_pass) {
		try {
			User user = userService.login(user_loginname,user_pass);
			System.out.println(user);
			if(user==null) {
				//登录失败
				model.addAttribute("msg", "用户名或密码错误");
				return "redirect:/login.html";
			}else {
				session.setAttribute("USER_IN_SESSION", user);
				return "redirect:/system/index/index.html";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "系统维护中");
			return "/login.html";
		}
	}
	
}
