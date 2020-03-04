package com.woniu.team2project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.mapper.TbMapper;
import com.woniu.team2project.service.TbService;
@Service
public class TbServiceImpl implements TbService{

	@Autowired
	TbMapper tbMapper;
	
	@Override
	public void addTb(Tb tb) {
		tbMapper.insertTb(tb);
	}

	@Override
	public Tb getTbByTb_id(String tb_id) {
		return tbMapper.selectTbByTb_id(tb_id);
	}

	
}
