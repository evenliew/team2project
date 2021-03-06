package com.woniu.team2project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.ResponseInfo;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Sx_status;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_role;
import com.woniu.team2project.exception.SxException;
import com.woniu.team2project.service.SxDataService;
import com.woniu.team2project.service.SxService;
import com.woniu.team2project.service.UserService;
import com.woniu.team2project.service.User_noticeService;

@Controller
public class SxController {

	@Autowired
	SxService sxService;
	
	@Autowired
	SxDataService sxDataService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	User_noticeService user_noticeService;
	
	String pmPath;
	
	//根据角色去不同页面
	@RequestMapping("/manageProject")
	@ResponseBody
	public String goProjectManagement(HttpSession session) {
		
		User user_in_session = (User) session.getAttribute("USER_IN_SESSION");
		System.out.println(user_in_session);
		//拿User角色
		User_role user_role = userService.getUser_roleByUser_id(user_in_session.getUser_id());
		//判断角色,写入不同的页面链接
		if(user_role.getRole_id()==1) {		//局里的老板 1000
			pmPath = "../sxBureauLeader.html";
		}else if(user_role.getRole_id()==2) {//局里的员工 121
			pmPath = "../sxBureauStaff.html";
		}else if(user_role.getRole_id()==3){//单位的老板 2000
			pmPath = "../sxOfficeLeader.html"; 
		}else {								//单位的员工 00001
			pmPath = "../sxOfficeStaff.html"; 
		}
		return pmPath;
	}

	//分页条件查询事项
	@RequestMapping("/sxbyconditionpage*")
	@ResponseBody
	public ResponseInfo getSxByConditionPage(Sx sx, Integer sx_type_id, Integer pageIndex) {
		PageInfo<Sx> sxsPage;
		try {
			//左侧导航栏若传了事项类型，把事项类型赋给传过来的事项,判断非空
			if(sx_type_id != null) {
				Sx_type sx_type = new Sx_type(); 
				sx_type.setSx_type_id(sx_type_id);
				sx.setSx_type(sx_type);
			}
			System.out.println("页码"+pageIndex);
			//判断页码
			if(pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			PageHelper.startPage(pageIndex, 2);
			List<Sx> sxs = sxService.getSxByConditionPage(sx);
			sxsPage = new PageInfo<>(sxs);
			for(Sx mysx: sxsPage.getList()) {
				System.out.println(mysx);
			}
			//成功打回200和数据
			return new ResponseInfo(200, sxsPage);
		} catch (SxException e) {
			//不成功打回500和错误信息
			return new ResponseInfo(500,e.getMessage().toString());
		}
	}
		
	//分页查局领导审批了的事项
	@RequestMapping("/leaderapprovedsx*")
	@ResponseBody
	public ResponseInfo getApprovedSxByLeader(Sx sx, Integer pageIndex, HttpSession session) {
		try {
			System.out.println("filter传过来的事项："+sx);
			//判断页码,若为空默认为1，调pagehelper
			if(pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			PageHelper.startPage(pageIndex, 2);
			//从Session里面拿出user_in_session的ID，查出他审批了的事项
			User user_in_session = (User) session.getAttribute("USER_IN_SESSION");
			List<Sx> sxs = sxService.getApprovedSxByLeader_id(user_in_session.getUser_id(), sx);
			//把事项装配成pageInfo
			PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
			for(Sx mysx: sxsPage.getList()) {
				System.out.println(mysx);
			}
			//成功打回200和数据
			return new ResponseInfo(200, sxsPage);
		} catch (SxException e) {
			//不成功打回500和错误信息
			return new ResponseInfo(500, e.getMessage().toString());
		}
	}	

	//分页查局领导未审批的事项
	@RequestMapping("/leaderunapprovedsx*")
	@ResponseBody
	public ResponseInfo getUnapprovedSxByLeader(Sx sx, Integer pageIndex, HttpSession session) {
		
		try {
			//判断页码,若为空默认为1，调pagehelper
			if(pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			PageHelper.startPage(pageIndex, 2);
			//从Session里面拿出user_in_session的ID，查出他审批了的事项
			User user_in_session = (User) session.getAttribute("USER_IN_SESSION");
			List<Sx> sxs = sxService.getUnapprovedSxByLeader_id(user_in_session.getUser_id(), sx);
			//把事项装配成pageInfo
			PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
			for(Sx mysx: sxsPage.getList()) {
				System.out.println(mysx);
			}
			//成功打回200和数据
			return new ResponseInfo(200, sxsPage);
		} catch (SxException e) {
			//不成功打回500和错误信息
			return new ResponseInfo(500, e.getMessage().toString());
		}
	}	
	
	//分页某局员工创造的事项
	@RequestMapping("/sxbyfounder*")
	@ResponseBody
	public ResponseInfo getSxByFounder(Sx sx, Integer pageIndex, HttpSession session) {
			
		try {
			//判断页码,若为空默认为1，调pagehelper
			if(pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			System.out.println(sx);
			PageHelper.startPage(pageIndex, 2);
			//从Session里面拿出user_in_session的ID，查出他审批了的事项
			User user_in_session = (User) session.getAttribute("USER_IN_SESSION");
			List<Sx> sxs = sxService.getSxByFounder_id(user_in_session.getUser_id(), sx);
			//把事项装配成pageInfo
			PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
			for(Sx mysx: sxsPage.getList()) {
				System.out.println(mysx);
			}
			//成功打回200和数据
			return new ResponseInfo(200, sxsPage);
		} catch (SxException e) {
			//不成功打回500和错误信息
			return new ResponseInfo(500, e.getMessage().toString());
		}
	}	
	
	//分页查单位领导已接受的事项
	@RequestMapping("/leaderacceptedsx*")
	@ResponseBody
	public ResponseInfo getAcceptedSxByLeader(Sx sx, Integer pageIndex, HttpSession session) {
		
		try {
			//判断页码,若为空默认为1，调pagehelper
			if(pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			PageHelper.startPage(pageIndex, 2);
			//从Session里面拿出user_in_session的ID，查出他审批了的事项
			User user_in_session = (User) session.getAttribute("USER_IN_SESSION");
			List<Sx> sxs = sxService.getAcceptedSxByLeader_id(user_in_session.getUser_id(), sx);
			//把事项装配成pageInfo
			PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
			for(Sx mysx: sxsPage.getList()) {
				System.out.println(mysx);
			}
			//成功打回200和数据
			return new ResponseInfo(200, sxsPage);
		} catch (SxException e) {
			//不成功打回500和错误信息
			return new ResponseInfo(500, e.getMessage().toString());
		}
	}	
	
	//分页查单位领导还未接收的事项
	@RequestMapping("/leaderunacceptedsx*")
	@ResponseBody
	public ResponseInfo getUnacceptedSxByLeader(Sx sx, Integer pageIndex, HttpSession session) {
		
		try {
			//判断页码,若为空默认为1，调pagehelper
			if(pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			PageHelper.startPage(pageIndex, 2);
			//从Session里面拿出user_in_session的ID，查出他审批了的事项
			User user_in_session = (User) session.getAttribute("USER_IN_SESSION");
			List<Sx> sxs = sxService.getUnacceptedSxByLeader_id(user_in_session.getUser_id(), sx);
			//把事项装配成pageInfo
			PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
			for(Sx mysx: sxsPage.getList()) {
				System.out.println(mysx);
			}
			//成功打回200和数据
			return new ResponseInfo(200, sxsPage);
		} catch (SxException e) {
			//不成功打回500和错误信息
			return new ResponseInfo(500, e.getMessage().toString());
		}
	}	
	
	//分页某单位员工相关的事项
	@RequestMapping("/sxbyworker*")
	@ResponseBody
	public ResponseInfo getSxByWorker(Sx sx, Integer pageIndex, HttpSession session) {
		try {
			//判断页码,若为空默认为1，调pagehelper
			if(pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			PageHelper.startPage(pageIndex, 2);
			//从Session里面拿出user_in_session的ID，查出他审批了的事项
			User user_in_session = (User) session.getAttribute("USER_IN_SESSION");
			List<Sx> sxs = sxService.getSxByWorker_id(user_in_session.getUser_id(), sx);
			//把事项装配成pageInfo
			PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
			for(Sx mysx: sxsPage.getList()) {
				System.out.println(mysx);
			}
			//成功打回200和数据
			return new ResponseInfo(200, sxsPage);
		} catch (SxException e) {
			//不成功打回500和错误信息
			return new ResponseInfo(500, e.getMessage().toString());
		}
	}		
		
		
	//批量删除事项
	@RequestMapping("/deletesxbysx_id")
	@ResponseBody
	public Integer removeSxBySx_id(String deleteList) {
		System.out.println(deleteList);
		if(deleteList!=null && !"".equals(deleteList)) {
			String[] sx_ids = deleteList.split(",");
			for(String sx_id : sx_ids) {
				sxService.removeSx(sx_id);
			}
			//成功return 1
			return 1;
		}else {
			//不成功return 2
			return 2;
		}
	}
	//新建事项
//	@RequestMapping("/newproject")
//	public String newproject(Model model,Sx sx,BindingResult bindingresult) {
//		System.out.println(sx);
//		return "redirect:/system/projectlist.html";
//	}
	
	//事项详情界面使用(要查对应的领导和单位负责人)
	@RequestMapping("/getSxBySx_id*")
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
	/*
	 * @RequestMapping("/getSxStatuBySx_id") public ModelAndView
	 * getSxStatusBySx_id(String sx_id) { ModelAndView mv=new ModelAndView();
	 * if(sx_id!=null) { //查该事项 Sx sx = sxService.getSxBySx_id(sx_id);
	 * mv.addObject("sx", sx); mv.setViewName("/system/projectstatus.html"); }else{
	 * mv.setViewName("/system/projectlist.html"); } return mv; }
	 */
	
	//点击编辑事项 
	@RequestMapping("/editproject*")
	public ModelAndView modifySx(String sx_id) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("sx_id", sx_id);
		//根据id拿到事项传到编辑页面
		Sx sx = sxService.getSxBySx_id(sx_id);
		mv.addObject("sx", sx);
		mv.setViewName("/system/editproject.html");
		return mv;
	}
	
	//管理事项进度 
	@RequestMapping("/manageproject*")
	public ModelAndView manageSx(String sx_id) {
		ModelAndView mv=new ModelAndView();
		//根据id拿到事项传到编辑页面
		Sx sx = sxService.getSxBySx_id(sx_id);
		mv.addObject("sx", sx);
		mv.setViewName("/system/projectstatus.html");
		return mv;
	}
	
	//提交更改事项进度
	@RequestMapping("/changestatus")
	public String changeSxStatus(Integer urgency_id,Integer sx_status_id,String sx_id) {
		//更改事项状态
		sxService.modifySxStatus(sx_id, sx_status_id);
		//修改紧急程度
		sxService.modifySxUrgency(sx_id, urgency_id);
		//调通知:模板7状态改变
		Sx sx = sxService.getSxBySx_id(sx_id);
		User admin = userService.getUserByUser_id("admin");
		user_noticeService.sendUser_notice(admin, sx.getFounder(), sx, 7);
		user_noticeService.sendUser_notice(admin, sx.getFounder().getOffice().getOffice_leader(), sx, 7);
		user_noticeService.sendUser_notice(admin, sx.getOffice().getOffice_leader(), sx, 7);
		return "redirect:/system/"+pmPath.substring(3);
	}
	
	//提交编辑的事项
	@RequestMapping("/submitproject")
	public String submitproject(String sx_id,Sx_status sx_status,Sx_type sx_type,Area area,
			County county,Industry industry,Office office,Urgency urgency,String sx_content,
			String sx_remark) {
		Sx sx = sxService.getSxBySx_id(sx_id);
		System.out.println("原始事项:"+sx);
		sx.setSx_status(sx_status);
		sx.setSx_type(sx_type);
		sx.setArea(area);
		sx.setCounty(county);
		sx.setIndustry(industry);
		sx.setOffice(office);
		sx.setUrgency(urgency);
		sx.setSx_content(sx_content);
		sx.setSx_remark(sx_remark);
		sxService.modifySx(sx);
		System.out.println("之后事项:"+sx);
		//该单位后给相应领导发通知
		return "redirect:/system/"+pmPath.substring(3);
	}
	
	//局领导审批事项
	@RequestMapping("/approvesx")
	@ResponseBody
	public String approveSx(String sx_id) {
		sxService.approveSx(sx_id);
		return "success";
	}
	
	//局领导驳回事项
	@RequestMapping("/unapprovesx")
	@ResponseBody
	public String unapproveSx(String sx_id) {
		sxService.unapproveSx(sx_id);
		return "success";
	}

	//单位领导接受事项
	@RequestMapping("/acceptsx")
	@ResponseBody
	public String acceptSx(String sx_id) {
		sxService.acceptSx(sx_id);
		return "success";
	}

	//单位领导拒绝接受事项（销项）
	@RequestMapping("/unacceptsx")
	@ResponseBody
	public String unacceptSx(String sx_id) {
		sxService.unacceptSx(sx_id);
		return "success";
	}
} 
