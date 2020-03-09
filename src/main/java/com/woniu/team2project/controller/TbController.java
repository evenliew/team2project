package com.woniu.team2project.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.TbService;
/**
 * 通报Controller层。
 * 此层中可以新增通报，删除通报，修改通报
 * 投资促进局里的人对某单位的通报
 * @author 94689
 *
 */
@Controller
public class TbController {
	@Autowired
	TbService tbService;
	/**
	 * 查询所有通报
	 * @param model
	 * @return
	 */
	@GetMapping("/getall/tb")
	public String tbTest(Model model) {
		List<Tb> allTbs = tbService.getAllTbs();
		model.addAttribute("tbs", allTbs);
		return "showtb";
	};
	/**
	 * 转到添加页面
	 * @param model
	 * @return
	 */
	@GetMapping("/toaddpage/tb")
	public String tbAddpage(Model model,HttpServletRequest req) {
		String[] strs=new String[]{"sx1","sx2"};
		model.addAttribute("sxs",strs);
		req.getSession().setAttribute("session_user", "aaa");
		String[] deps=new String[]{"单位一","单位二"};
		model.addAttribute("deps", deps);
		return "tbAdd";
	}
	/**
	 * 添加通报
	 * @param model
	 * @param tb
	 * @return
	 */
	@PostMapping("/add/tb")
	public String tbAdd(Model model,Tb tb,HttpServletRequest req) {
		tb.setTb_id(UUID.randomUUID().toString().replace("-", ""));//通报id
		tb.setTb_time(new Date());//发送通报时间
		//在这里取出session——user的id设置为发布人
		String session_user = (String) req.getSession().getAttribute("session_user");
		User tb_author = new User();
		tb_author.setUser_id(session_user);
		tb.setTb_author(tb_author);
		Sx tb_sx = new Sx();
		tb_sx.setSx_id("123");//事项id
		Office tb_office = new Office();
		tb_office.setOffice_id(1);//单位id
		tb.setTb_office(tb_office );
		tb.setTb_sx(tb_sx );
		tbService.addTb(tb);
		return "redirect:/getall/tb";
	}
	/**
	 * 删除通报
	 * @param model
	 * @param tb_id
	 * @return
	 */
	@DeleteMapping("/delete")
	public String tbDelete(Model model,String[] tbs) {
		System.out.println(tbs);
		if (tbs != null) {
			for (String tb_id : tbs) {
				tbService.removeTbByTb_id(tb_id);	
			}
		}
		return "redirect:/getall/tb";
	}
	/**
	 * 去通报修改页面
	 * @param model
	 * @param tb_id
	 * @return
	 */
	@GetMapping("/getall/update/{tb_id}")
	public String tbUpdate(Model model,@PathVariable("tb_id") String tb_id) {
		Tb tb = tbService.getTbByTb_id(tb_id);
		model.addAttribute("tb", tb);
		return "tbUpdate";
	};
}
