package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Zb;
import com.woniu.team2project.mapper.ZbMapper;
import com.woniu.team2project.service.ZbService;

/**
 * 这是专业业务层的实现类
 * @author 94689
 *
 */

@Service
public class ZbServiceImp implements ZbService {

	//注入一个mapper
	@Autowired
	ZbMapper zbMapper;

	@Override
	public void addZb(Zb zb) {
		zbMapper.insertZb(zb);
	}

	@Override
	public Zb getZbByZb_id(String zb_id) {
		return zbMapper.selectZbByZb_id(zb_id);
	}

	@Override
	public List<Zb> getAllZb() {
		PageHelper.startPage(1, 5);
		List<Zb> zbs = zbMapper.selectAllZb();
		return zbs;
	}
	
	

}
