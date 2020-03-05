package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.service.SxService;

@Service
public class SxServiceImpl implements SxService{
	@Autowired
	SxMapper sxMapper;
	
	//查询事项(根据事项id)
	public Sx getSxBySx_id(String sx_id) {
		Sx sxCondition = new Sx();
		sxCondition.setSx_id(sx_id);
		List<Sx> sx = sxMapper.selectSxByConditionPage(sxCondition);
		System.out.println(sx.size());
		return sx.get(0);
	}
	
	//更改事项
	public void modifySx(Sx sx) {
		sxMapper.updateSx(sx);
	}
	
	//删除事项
	public void removeSxBySx_id(String sx_id) {
		sxMapper.deleteSx(sx_id);
	}
	
}
