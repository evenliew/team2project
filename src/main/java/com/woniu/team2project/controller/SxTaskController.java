package com.woniu.team2project.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Sx_task;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.SxTaskService;

@Controller
public class SxTaskController {
	
	@Autowired
	SxTaskService sxTaskService;
	
	//去我的子任务界面
	@RequestMapping("/tomytask")
	public ModelAndView toMyTask(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		//查询我的子任务
		User user = (User)session.getAttribute("USER_IN_SESSION");
		
		//模拟登录**************************
		User user2 = new User();
		user2.setUser_id("1122");
		
		List<Sx_task> myTasks = sxTaskService.getMyTask(user2);
		mv.addObject("task", myTasks);
		mv.setViewName("/system/mytask.html");
		return mv;
	}
	
	//去本单位子任务页面
	@RequestMapping("/officetask")
	public ModelAndView toOfficeTask(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		//查询我的子任务
		User user = (User)session.getAttribute("USER_IN_SESSION");
		
		//模拟登录**************************
		User user2 = new User();
		user2.setUser_id("1122");
		
		Integer office_id = sxTaskService.getOffice_idByUser_id(user2.getUser_id());
		List<Sx_task> myOfficeTask = sxTaskService.getMyOfficeTask(office_id);
		mv.addObject("task", myOfficeTask);
		mv.setViewName("/system/officetask.html");
		return mv;
	}
	//去所有子任务页面
	@RequestMapping("/alltask")
	public ModelAndView toAllTask() {
		ModelAndView mv=new ModelAndView();
		List<Sx_task> allTask = sxTaskService.getAllTask();
		
		mv.addObject("task", allTask);
		mv.setViewName("/system/alltask.html");
		return mv;
	}
	
	//去更改子任务界面
	@RequestMapping("/tomodifytask")
	public ModelAndView toModifyTask(String sx_task_id) {
		ModelAndView mv=new ModelAndView();
		Sx_task task = sxTaskService.getSx_taskBySx_task_id(sx_task_id);
		mv.addObject("task", task);
		mv.setViewName("/system/edittask.html");
		return mv;
	}
	
	//根据单位id查所有user
	@RequestMapping("/allUserByOffice_id")
	@ResponseBody
	public List<User> allUserByOffice_id(Integer office_id) {
		List<User> users = sxTaskService.getallUserByOffice_id(office_id);
		return users;
	}
	
	//提交修改子任务
	@RequestMapping("//changetask")
	public String changetask(String sx_task_id,String sx_task_content,String sx_task_worker_id) {
		System.out.println("前端的id："+sx_task_id);
		System.out.println("前端的内容："+sx_task_content);
		System.out.println("前端的worker_id："+sx_task_worker_id);
		//从数据库查该子任务
		Sx_task task = sxTaskService.getSx_taskBySx_task_id(sx_task_id);
		System.out.println("数据库子任务："+task);
		//设置更改的内容
		task.setSx_task_content(sx_task_content);
		User worker = new User();
		worker.setUser_id(sx_task_worker_id);
		task.setWorker(worker);
		//更改子任务
		sxTaskService.modifyTask(task);
		
		return "redirect:/officetask";
	}
	
	//删除子任务
	@RequestMapping("/deletetask")
	public String deleteTask(String sx_task_id) {
		sxTaskService.removeTask(sx_task_id);
		return "redirect:/officetask";
	}
	
	//去新建子任务页面
	@RequestMapping("/tonewtask")
	public ModelAndView tonewtask(String sx_id) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("sx_id", sx_id);
		mv.setViewName("/system/newtask.html");
		return mv;
	}
	
	//新建子任务
	@RequestMapping("/newtask")
	public String newtask(Sx_task sx_task,String sx_task_worker_id,String sx_id) {
		User worker = new User();
		worker.setUser_id(sx_task_worker_id);
		sx_task.setWorker(worker);
		Sx sx = new Sx();
		sx.setSx_id(sx_id);
		sx_task.setSx(sx);
		sx_task.setSx_task_id(UUID.randomUUID().toString().substring(32));
		sx_task.setSx_task_status_id(1);
		sx_task.setSx_task_time(new Date());
		sxTaskService.addTask(sx_task);
		return "redirect:/officetask";
	}
	
	
	
}
