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

	//查某局领导审批了的事项
	@Override
	public List<Sx> getApprovedSxByLeader_id(String leader_id, Sx sx) {
		return sxMapper.selectApprovedSxByLeader_id(leader_id, sx);
	}
	
	//查某局领导待审批的事项
	@Override
	public List<Sx> getUnapprovedSxByLeader_id(String leader_id, Sx sx) {
		return sxMapper.selectUnapprovedSxByLeader_id(leader_id, sx);
	}

	//查某局员工创造的事项
	@Override
	public List<Sx> getSxByFounder_id(String founder_id, Sx sx) {
		return sxMapper.selectSxByFounder_id(founder_id, sx);
	}

	//查某单位领导接收了的事项
	@Override
	public List<Sx> getAcceptedSxByLeader_id(String leader_id, Sx sx) {
		return sxMapper.selectAcceptedSxByLeader_id(leader_id, sx);
	}

	//查某单位领导还未接收的事项
	@Override
	public List<Sx> getUnacceptedSxByLeader_id(String leader_id, Sx sx) {
		return sxMapper.selectUnacceptedSxByLeader_id(leader_id, sx);
	}

	//查某单位员工相关的事项（其子任务的事项）
	@Override
	public List<Sx> getSxByWorker_id(String worker_id, Sx sx) {
		return sxMapper.selectSxByWorker_id(worker_id, sx);
	}
	
}
