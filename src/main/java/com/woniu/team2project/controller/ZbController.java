package com.woniu.team2project.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.Zb;
import com.woniu.team2project.entity.Zb_state;
import com.woniu.team2project.service.ZbService;


/**
 * 专报的控制器，传到页面
 * @author 59255
 *
 */
@Controller
public class ZbController {
	
	@Autowired
	ZbService zbService;
	
	
	
	//与页面交互--查询所有
	@GetMapping(value="/zball" )
	public String getAllZbs(Model model) {
		
		//从数据库查询得到
		List<Zb> zbs = zbService.getAllZb();
		
		//转成pageinfo类型
		PageInfo<Zb> zbPage = new PageInfo<Zb>(zbs);
		
		//装入模型
		model.addAttribute("zbPage",zbPage);
		
		//测试是否得到
		for(Zb zb:zbPage.getList()) {
			System.out.println(zb);
		}
		
		return "zb";
	}
	//前往新增一个专报的页面--需要查询用户和事项
	@GetMapping(value="/zbadd")
	public String getUserAndSx() {
		//需要得到user---目前尚未书写
		//需要得到事项sx
		
		return "noticeAdd";
	}
	
	//新增一个专报
	@PostMapping(value="/addonezb")
	public String addOneZb(Zb zb,HttpServletRequest request) {
		//这里是从域中获取到用户信息，然后赋值
	//	User user = (User) request.getSession().getAttribute("user");
	//	zb.setZb_founder(user);
		
		//这里进行模拟
		User user=new User();user.setUser_id("aaa");zb.setZb_founder(user);
		
		//正常使用
		zb.setZb_sb_time(new Date());
		
		//模拟
		zb.setZb_state(new Zb_state(1, null));
		
		//模拟
		User zb_recender=new User();zb_recender.setUser_id("bbbb");
		zb.setZb_recender(zb_recender);
		
		
		//事项id：模拟
		Sx zb_sx=new Sx();zb_sx.setSx_id("aaaa");
		zb.setZb_sx(zb_sx);
		zbService.addZb(zb);
		return "noticeMy";
	}
	
	//删除一个专报--就是修改状态为-1
	@PutMapping(value="/zbdelete/{zb_id}")
	public String updateOneZb(@PathVariable("zb_id") String zb_id) {
		
		zbService.changeZb_state(zb_id, -1);
		System.out.println(zb_id);
		
		return "redirect:/zball";
	}
	
	//查询我的专报信息
	@GetMapping(value="/zbmine" )
	public String getMyZbs(Model model) {
		
		//从数据库查询得到
		List<Zb> zbs = zbService.getAllZb();
		
		//转成pageinfo类型
		PageInfo<Zb> zbPage = new PageInfo<Zb>(zbs);
		
		//装入模型
		model.addAttribute("zbPage",zbPage);
		
		//测试是否得到
		for(Zb zb:zbPage.getList()) {
			System.out.println(zb);
		}
		
		return "zb";
	}	
}
