package com.woniu.team2project.service.impl;

import java.util.List;
import java.util.UUID;

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
	
	//添加
	@Override
	public void addZb(Zb zb) {
		if(zb!=null ) {
			String randomUUID = 
					UUID.randomUUID().toString().replace("-", "").toLowerCase(); 
			System.out.println(randomUUID);
			zb.setZb_id(randomUUID);
		}
		zbMapper.insertZb(zb);
	}
	//主键查询
	@Override
	public Zb getZbByZb_id(String zb_id) {
		return zbMapper.selectZbByZb_id(zb_id);
	}
	//所有查
	@Override
	public List<Zb> getAllZb(Integer pageNum,Integer pageSize) {
		if(pageNum==null ||pageNum==0) {
			pageNum=1;
		}
		if(pageSize==null ||pageSize==0) {
			pageSize=5;
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Zb> zbs = zbMapper.selectAllZb();
		return zbs;
	}
	//条件检查
	@Override
	public List<Zb> getZbByCondition(Zb zb,Integer pageNum,Integer pageSize) {
		if(pageNum==null ||pageNum==0) {
			pageNum=1;
		}
		if(pageSize==null ||pageSize==0) {
			pageSize=5;
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Zb> zbs = zbMapper.selectZbByCondition(zb);
		return zbs;
	}
	//该状态
	@Override
	public void changeZb_state(String zb_id, Integer zb_state_id) {
		zbMapper.updateZb_state(zb_id, zb_state_id);
	}
}
