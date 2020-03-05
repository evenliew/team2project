package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.service.SxService;

@Service
public class SxServiceImpl implements SxService{

	@Autowired
	SxMapper sxMapper;
	
	
	@Override
	public void addSx(Sx sx) {
		// TODO Auto-generated method stub
		
	}

	//分页条件查询事项
	//@Transactional
	@Override
	public List<Sx> getSxByConditionPage(Sx sx) {
		return sxMapper.selectSxByConditionPage(sx);
	}
	
	//根据id删除事项
	@Override 
	public void removeSx(String sx_id) {
		sxMapper.deleteSx(sx_id);
		
	}

	@Override
	public void modifySx(Sx sx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifySxStatus(String sx_id, Integer sx_status_id) {
		// TODO Auto-generated method stub
		
	}

}
