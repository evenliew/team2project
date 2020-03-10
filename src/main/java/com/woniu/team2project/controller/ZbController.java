package com.woniu.team2project.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	public String getAllZbs(Model model,Integer pageNum) {
		
		//对页码进行判断
		if(pageNum==null||pageNum==0) {
			pageNum=1;
		}
		//从数据库查询得到
		List<Zb> zbs = zbService.getAllZb(pageNum,null);
		
		
		
		//转成pageinfo类型
		PageInfo<Zb> zbPage = new PageInfo<Zb>(zbs);
		
		
		
		
		//装入模型
		model.addAttribute("zbPage",zbPage);
		
		
		
		return "zb";
	}
	//前往新增一个专报的页面--需要查询用户和事项
	@GetMapping(value="/zbadd")
	public String getUserAndSx() {
		//需要得到user---目前尚未书写
		//需要得到事项sx
		
		return "zbAdd";
	}
	
	//新增一个专报
	@PostMapping(value="/addonezb")
	public String addOneZb(Zb zb,HttpSession session,Model model) {
		//这里是从域中获取到用户信息，然后赋值
	//	User user = (User) session.getAttribute("user");
	//	zb.setZb_founder(user);
		if(zb.getZb_content()==null ||zb.getZb_content()=="") {
			 model.addAttribute("msg","内容不能为空");
			 return "redirect:/zbadd";
		}
		/*这里判断接收者的信息是否是空，但目前无法选择接收者，所以不进行判断
		 * if(zb.getZb_recender()==null || zb.getZb_recender().getUser_id()==null
		 * ||zb.getZb_recender().getUser_id()=="" ) {
		 * model.addAttribute("msg","接收者不能为空"); return "redirect:/zbadd"; }
		 */
		if(zb.getZb_remark()==null ||zb.getZb_remark()=="") {
			model.addAttribute("msg","备注不能为空");
			 return "redirect:/zbadd";
		}
		//这里进行模拟
		User user=new User();user.setUser_id("aaaa");zb.setZb_founder(user);
		
		//正常使用
		zb.setZb_sb_time(new Date());
		
		//模拟
		zb.setZb_state(new Zb_state(0, null));
		
		//模拟
		User zb_recender=new User();zb_recender.setUser_id("bbbb");
		zb.setZb_recender(zb_recender);
		
		
		//事项id：模拟
		Sx zb_sx=new Sx();zb_sx.setSx_id("aaaa");
		zb.setZb_sx(zb_sx);
		zbService.addZb(zb);
		return "redirect:/zbmine";
	}
	
	//删除一个专报--就是修改状态为-1
	@PutMapping(value="/zbdelete/{zb_id}")
	public String updateOneZb(@PathVariable("zb_id") String zb_id) {
		
		zbService.changeZb_state(zb_id, -1);
		
		
		return "redirect:/zball";
	}
	
	//查询我的专报信息
	@GetMapping(value="/zbmine" )
	public String getMyZbs(Model model,HttpServletRequest request) {
		
		//获取用户--暂时没有，进行模拟
		User user=new User();user.setUser_id("bbbb");
//		User user=(User) request.getSession().getAttribute("user");
		//条件查询
		Zb zb1=new Zb();
		zb1.setZb_founder(user);
		Integer pageNum=0;
		Integer pageSize=0;
		//从数据库查询得到发送者是用户的专报
		List<Zb> zbs1 = zbService.getZbByCondition(zb1, pageNum, pageSize);
		//接收者是user
		Zb zb2=new Zb();zb2.setZb_recender(user);
		List<Zb> zbs2 = zbService.getZbByCondition(zb2, pageNum, pageSize);
		//转成pageinfo类型
		PageInfo<Zb> zbPage1 = new PageInfo<Zb>(zbs1);
		PageInfo<Zb> zbPage2 = new PageInfo<Zb>(zbs2);
		//装入模型

		model.addAttribute("zbPage1",zbPage1);
		model.addAttribute("zbPage2",zbPage2);

		
		return "zbMy";
	}	
	
	//专报审批--状态更改
	@PutMapping(value="/resultzb/{zb_id}/{resultid}" )
	public String getMySp_Zbs(@PathVariable("zb_id") String zb_id,@PathVariable("resultid")Integer resultid) {
		
		zbService.changeZb_state(zb_id, resultid);
		return "redirect:/zball";
	}	
	@GetMapping("/error")
	public String test(Model model){
		model.addAttribute("msg","睡觉睡觉睡觉");
		return "error";
	}
}
