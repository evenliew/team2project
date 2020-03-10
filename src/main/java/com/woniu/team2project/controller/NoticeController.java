package com.woniu.team2project.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Module;
import com.woniu.team2project.entity.Notice;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.mapper.ModuleMapper;
import com.woniu.team2project.service.NoticeService;

/**
 * 控制notice到达页面
 * 
 * @author 59255
 *
 */
@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@Autowired
	ModuleMapper moduleMapper;

	// 与页面交互--查询所有
	@GetMapping(value = "/noticeall")
	public String getAllNotices(Model model, HttpSession session, Integer pageNum) {

		// 对页码进行判断
		if (pageNum == null || pageNum == 0) {
			pageNum = 1;
		}

		// 从数据库查询得到
		List<Notice> notices = noticeService.getAllNotices(pageNum, null);

		// 转成pageinfo类型
		PageInfo<Notice> noticePage = new PageInfo<>(notices);

		// 装入模型
		model.addAttribute("noticePage", noticePage);

		// 模拟存入user来进行判断能否增删改查
		User user = new User();
		user.setUser_id("aaaa");
		session.setAttribute("user", user);

		// 返回页面
		return "notice";

	}

	// 删除公告的操作
	@DeleteMapping(value = "/deletenotice/{notice_id}")
	public String removeNotice(@PathVariable("notice_id") Integer notice_id) {

		noticeService.removeNotice(notice_id);

		System.out.println(notice_id);

		return "redirect:/noticeall";
	}

	// 进入新增或者修改公告操作的页面
	@GetMapping(value = "/noticeadd/{notice_id}")
	public String getNoticeAddPage(Model model, @PathVariable("notice_id") Integer notice_id) {

		// 查询所有的模板
		List<Module> modules = moduleMapper.selectAllModules();
		Notice notice;
		// 判断notice_id的值：-1：新增，其他值都素hi修改
		if (notice_id == -1) {
			notice = new Notice();
		} else {
			notice = noticeService.getNoticeByNotice_id(notice_id);
		}

		// 装入模型
		model.addAttribute("modules", modules);
		model.addAttribute("notice", notice);
		// 返回页面
		return "addNotice";

	}

	// 提交添加操作
	@PostMapping(value = "/addOneNotice")
	public String addNotice(Notice notice, Model model, HttpSession session) {
		// 先判断notice是否传输过来
		if (notice == null) {
			model.addAttribute("msg", "系统维护中");
			return "msg";
		}
		// 获取查看是否有主键id，有：修改 无：新增
		Integer notice_id = notice.getNotice_id();
		// 再判断是否没有输入内容和标题
		if (notice.getNotice_content() == null && notice.getNotice_content().equals("")) {
			// 没有输入内容打回当前页面重新输入
			model.addAttribute("msg", "内容不能为空");
			// 判断是修改还是新增
			if (notice_id == null) {
				// 新增
				return "redirect:/noticeadd/-1";
			}
			// 修改
			return "redirect:/noticeadd/" + notice_id;
		}
		if (notice.getNotice_title() == null || notice.getNotice_title().equals("")) {
			// 没有输入内容打回当前页面重新输入
			model.addAttribute("msg", "标题不能为空");
			// 判断是修改还是新增
			if (notice_id == null) {
				// 新增
				return "redirect:/noticeadd/-1";
			}
			// 修改
			return "redirect:/noticeadd/" + notice_id;
		}

		// User应该从域中取，这里取不到 进行模拟
		User notice_founder=(User) session.getAttribute("user");
//		User notice_founder = new User();
//		notice_founder.setUser_id("aaaa");
		notice.setNotice_founder(notice_founder);
		notice.setNotice_time(new Date());
		noticeService.addNotice(notice);

		return "redirect:/noticeall";
	}

}
