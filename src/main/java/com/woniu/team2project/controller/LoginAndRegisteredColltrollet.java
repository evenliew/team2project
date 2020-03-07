package com.woniu.team2project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_status;
import com.woniu.team2project.service.LoginAndRegisteredService;

@Controller
public class LoginAndRegisteredColltrollet {

	@Autowired
	LoginAndRegisteredService res;
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	@RequestMapping("/registered")
	public String Registered(Model model) {
		List<Office> offs = res.getAllOffice();
		model.addAttribute("offs",offs);
		return "registered";
	}
	//添加方法
	@RequestMapping("/addUser")
	public String addUser(Model model,User user) {
		Random random=new Random();
		int num = random.nextInt(100);
		String userid=num+"";
		user.setUser_id(userid);
		res.addUser(user);
		model.addAttribute("msg","恭喜注册成功，请登录");
		return "login";
	}
	//核实昵称是否合法
	@RequestMapping("/username")
	@ResponseBody
	public Map<String, Object> RegisteredUser_name(String account) {
		Map<String, Object> mapsMap=new HashMap<String, Object>();
		User user = res.getAllUser(account);
		if(StringUtils.isEmpty(account)) {
			mapsMap.put("userExsit", true);
			mapsMap.put("msg", "昵称不能为空");
			return mapsMap;
		}else {
			if (user!=null) {
				mapsMap.put("userExsit", true);
				mapsMap.put("msg", "此昵称太受欢迎，请换一个");
			}else{
				mapsMap.put("userExsit", false);
				mapsMap.put("msg", "此昵称可用");
			}
		}
		
		return mapsMap;
	}
	@RequestMapping("/loginnames")
	@ResponseBody
	public Map<String, Object> RegisteredLoginName(String login_name) {
		Map<String, Object> mapsname=new HashMap<String, Object>();
		User user = res.getAllUserByLoginName(login_name);
		if(StringUtils.isEmpty(login_name)) {
			mapsname.put("userExsit1", true);
			mapsname.put("msg1", "用户名不能为空");
			return mapsname;
		}else {
			if (user!=null) {
				mapsname.put("userExsit1", true);
				mapsname.put("msg1", "此用户名太受欢迎，请换一个");
			}else{
				mapsname.put("userExsit1", false);
				mapsname.put("msg1", "此用户名可用");
			}
		}
		
		return mapsname;
	}
	
	@RequestMapping("/password")
	@ResponseBody
	public Map<String, Object> RegisteredPassword(String user_pass) {
		Map<String, Object> mapsname=new HashMap<String, Object>();
		String regExp = "^[\\w_]{6,12}$";
		if (!user_pass.matches(regExp)) {
			mapsname.put("userExsit2", true);
			mapsname.put("msg2", "密码长度应6到12位");
			return mapsname;
		}
		User user = res.getAllUserByPassWord(user_pass);
		if(StringUtils.isEmpty(user_pass)) {
			mapsname.put("userExsit2", true);
			mapsname.put("msg2", "密码不能为空");
			return mapsname;
		}else {
			if (user!=null) {
				mapsname.put("userExsit2", true);
				mapsname.put("msg2", "此密码太受欢迎，请换一个");
			}else{
				mapsname.put("userExsit2", false);
				mapsname.put("msg2", "此密码可用");
			}
		}
		
		return mapsname;
	}
	
	@RequestMapping("/phones")
	@ResponseBody
	public Map<String, Object> Registeredphone(String user_phone) {
		Map<String, Object> mapsname=new HashMap<String, Object>();
		/*
		 * String regExp="^1(3\\d|5[012356789]|8[03456789])\\d{8}$"; if
		 * (!user_phone.matches(regExp)&&!StringUtils.isEmpty(user_phone)) {
		 * mapsname.put("userExsit3", true); mapsname.put("msg3", "号码必须为1开头的11位数字");
		 * return mapsname; }
		 */
		User user = res.getAllUserByPhone(user_phone);
		if(StringUtils.isEmpty(user_phone)) {
			mapsname.put("userExsit3", true);
			mapsname.put("msg3", "号码不能为空");
			return mapsname;
		}else {
			if (user!=null) {
				mapsname.put("userExsit3", true);
				mapsname.put("msg3", "此号码已被注册");
			}else{
				mapsname.put("userExsit3", false);
				mapsname.put("msg3", "此号码可用");
			}
		}
		
		return mapsname;
	}
	
	@RequestMapping("/loginname")
	@ResponseBody
	public Map<String, Object> loginName(String account) {
		Map<String, Object> mapsname=new HashMap<String, Object>();
		/*
		 * String regExp="^1(3\\d|5[012356789]|8[03456789])\\d{8}$"; if
		 * (!user_phone.matches(regExp)&&!StringUtils.isEmpty(user_phone)) {
		 * mapsname.put("userExsit3", true); mapsname.put("msg3", "号码必须为1开头的11位数字");
		 * return mapsname; }
		 */
		User user = res.getAllUserByLoginName(account);
		if(StringUtils.isEmpty(account)) {
			mapsname.put("userExsit", true);
			mapsname.put("msg", "号码不能为空");
			return mapsname;
		}else {
			if (user!=null) {
				mapsname.put("userExsit", false);
				mapsname.put("msg", "账号合法");
			}else {
				mapsname.put("userExsit", true);
				mapsname.put("msg", "账号未注册请先注册");
			}
		}
		
		return mapsname;
	}
}
