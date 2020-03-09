package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.mapper.TbMapper;
import com.woniu.team2project.service.TbService;
@Service
public class TbServiceImpl implements TbService{
	//自动注入
	@Autowired
	TbMapper tbMapper;
	//添加通报
	@Override
	public void addTb(Tb tb) {
		tbMapper.insertTb(tb);
	}
	/**
	 * 查询根据通报id查询通报
	 */
	@Override
	public Tb getTbByTb_id(String tb_id) {
		return tbMapper.selectTbByTb_id(tb_id);
	}
	/**
	 * 查询所有通报
	 */
	@Override
	public List<Tb> getAllTbs() {
		PageHelper.startPage(1, 5);
		return tbMapper.selectAllTbs();
	}
	/**
	 * 根据条件查询通报
	 */
	@Override
	public List<Tb> getTbByCondition(Tb tb) {
		return tbMapper.selectByCondition(tb);
	}
	@Override
	public void removeTbByTb_id(String tb_id) {
		tbMapper.deleteTb(tb_id);
	}

	
}
