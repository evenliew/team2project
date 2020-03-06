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
		sxMapper.updateSx(sx);
	}
	//修改事项状态
	public void modifySxStatus(String sx_id, Integer sx_status_id) {
		sxMapper.updateSxStatus(sx_id, sx_status_id);
	}

	//查询事项(根据事项id)
	public Sx getSxBySx_id(String sx_id) {
		Sx sxCondition = new Sx();
		sxCondition.setSx_id(sx_id);
		List<Sx> sx = sxMapper.selectSxByConditionPage(sxCondition);
		System.out.println(sx.size());
		return sx.get(0);
	}
	
	//修改紧急程度
	public void modifySxUrgency(String sx_id, Integer urgency_id) {
		sxMapper.updateSxUrgency(sx_id, urgency_id);
	}
	
}
