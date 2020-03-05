package com.woniu.team2project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.service.SxService;

@Controller
public class SxController {

	@Autowired
	SxService sxService;
	
	//分页条件查询事项
	@RequestMapping("/sxbyconditionpage*")
	@ResponseBody
	public PageInfo<Sx> getSxByConditionPage(Sx sx, Integer sx_type_id) {
		//左侧导航栏若传了事项类型，把事项类型赋给传过来的事项,判断非空
		if(sx_type_id != null) {
			Sx_type sx_type = new Sx_type(); 
			sx_type.setSx_type_id(sx_type_id);
			sx.setSx_type(sx_type);
		}
		PageHelper.startPage(1, 3);
		List<Sx> sxs = sxService.getSxByConditionPage(sx);
		PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
		for(Sx mysx: sxsPage.getList()) {
			System.out.println(mysx);
		}
		return sxsPage;
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
			return 1;
		}else {
			return 2;
		}
	}
}
