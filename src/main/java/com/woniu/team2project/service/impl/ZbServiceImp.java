package com.woniu.team2project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Zb;
import com.woniu.team2project.mapper.ZbMapper;
import com.woniu.team2project.service.ZbService;

/**
 * 这是专业业务层的实现类
 * @author 59255
 *
 */

@Service
public class ZbServiceImp implements ZbService {

	//注入一个mapper
	@Autowired
	ZbMapper zbMapper;
	
	
	//添加的方法
	@Override
	public void addZb(Zb zb) {
		// TODO Auto-generated method stub

	}

	@Override
	public Zb getZbByZb_id(String zb_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Zb> getAllZb() {
		// TODO Auto-generated method stub
		return null;
	}

}
