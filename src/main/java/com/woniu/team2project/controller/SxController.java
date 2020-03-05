package com.woniu.team2project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.service.SxDataService;
import com.woniu.team2project.service.SxService;

@Controller
public class SxController {
	@Autowired
	SxDataService sxDataService;
	
	@Autowired
	SxService sxService;
	
	//删除事项
	//@RequestMapping("")
	public ModelAndView removeSxBySx_id(String sx_id) {
		ModelAndView mv=new ModelAndView();
		if(sx_id!=null && !"".equals(sx_id)) {
			sxService.removeSxBySx_id(sx_id);
			mv.setViewName("projectlist.html");
		}else {
			//抛异常
		}
		return mv;
	}
	
	//新建事项
//	@RequestMapping("/newproject")
//	public String newproject(Model model,Sx sx,BindingResult bindingresult) {
//		System.out.println(sx);
//		return "redirect:/system/projectlist.html";
//	}
	
	//事项详情界面使用
	@RequestMapping("/getSxBySx_id")
	public ModelAndView getSxBySx_id(String sx_id) {
		ModelAndView mv=new ModelAndView();
		if(sx_id!=null) {
			//查该事项
			Sx sx = sxService.getSxBySx_id(sx_id);
			mv.addObject("sx", sx);
			//查需审核领导
			String sendLeader = sx.getFounder().getOffice().getOffice_leader().getUser_name();
			mv.addObject("sendLeader", sendLeader);
			//查接收单位负责人
			String receiveLeader = sx.getOffice().getOffice_leader().getUser_name();
			mv.addObject("receiveLeader",receiveLeader);
			mv.setViewName("/system/projectdetail.html");
		}else{
			mv.setViewName("/system/projectlist.html");
		}
		return mv;
	}
	//查询事项状态
	@RequestMapping("/getSxStatuBySx_id")
	public ModelAndView getSxStatusBySx_id(String sx_id) {
		ModelAndView mv=new ModelAndView();
		if(sx_id!=null) {
			//查该事项
			Sx sx = sxService.getSxBySx_id(sx_id);
			mv.addObject("sx", sx);
			mv.setViewName("/system/projectstatus.html");
		}else{
			mv.setViewName("/system/projectlist.html");
		}
		return mv;
	}
	
	//编辑事项 
	@RequestMapping("/editproject")
	public ModelAndView modifySx(String sx_id) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("sx_id", sx_id);
		//根据id拿到事项传到编辑页面
		Sx sx = sxService.getSxBySx_id(sx_id);
		mv.addObject("sx", sx);
		mv.setViewName("/system/editproject.html");
		return mv;
	}
}
