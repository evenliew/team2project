package com.woniu.team2project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.team2project.entity.User_notice;
import com.woniu.team2project.service.User_noticeService;

/**
 * 个人同报表
 * @author 94689
 *
 */
@Controller
public class User_noticeController {
	
	@Autowired
	User_noticeService user_noticeService;
	/**
	 * 当前所有个人通告表
	 * @param model
	 * @return
	 */
	@GetMapping("/getall/notice")
	public String getUser_notice(Model model) {
		List<User_notice> allUser_notice = user_noticeService.getAllUser_notice();
		model.addAttribute("notices", allUser_notice);
		return "showUserNotice";
	}
	/**
	 * 我的个人通告页面
	 * 我的发送，我的接收
	 * @param model
	 * @return
	 */
	@GetMapping("/my/notice")
	public String MyNoticePage(Model model) {
		List<User_notice> userFb = user_noticeService.getUser_noticeByUserFb("aaa");
		model.addAttribute("userFb", userFb);
		List<User_notice> userRe = user_noticeService.getUser_noticeByUserRe("aaa");
		model.addAttribute("userRe", userRe);
		return "noticeMy";
	}
	/**
	 * 转到添加页面
	 * @param model
	 * @return
	 */
	@GetMapping("/add/user_notice")
	public String addPage(Model model) {
		String[] strs = new String[] {"事项一：攻打白宫","事项二：收复台湾"};
		model.addAttribute("sxs", strs);
		
		return "toAddUser_notice";
	}
	/**
	 * 添加功能
	 */
	@PostMapping("/add/user_notice")
	public String addUser_notice(User_notice user_notice) {
		//在这里取出session_user 设置发布人
		System.out.println(user_notice);
		return "redirect:/getall/notice";
	}
	/**
	 * 删除功能
	 */
	@DeleteMapping("/remove")
	public String removeAll(Integer[] notices) {
		if(notices!=null) {
			for(Integer notice:notices) {
				user_noticeService.removeUser_notice(notice);
			}
		}
		return "redirect:/getall/notice";
	}
	/**
	 * 去修改页面
	 */
	@GetMapping("/update/user_notice/{user_nt_id}")
	public String toUpdatePage(Model model,@PathVariable("user_nt_id")Integer user_nt_id) {
		User_notice notice = user_noticeService.getUser_noticeByUser_notice_id(user_nt_id);
		model.addAttribute("notice", notice);
		return "updateUser_notice";
	}
	/**
	 * 提交修改处理方法
	 */
	@PutMapping("/update/user_notice")
	public String updateUser_notice(User_notice user_notice) {
		System.out.println(user_notice);
		return "redirect:/getall/notice";
	}
}
