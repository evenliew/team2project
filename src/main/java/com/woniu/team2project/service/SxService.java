package com.woniu.team2project.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.woniu.team2project.entity.Sx;

public interface SxService {

	//新建事项
	void addSx(Sx sx);
		
	//条件查询事项
	List<Sx> getSxByConditionPage(Sx sx);

	//删除事项
	void removeSx(String sx_id);
		
	//修改事项
	void modifySx(Sx sx);
		
	//修改事项状态
	void modifySxStatus(String sx_id,Integer sx_status_id);
	
	//修改紧急程度
	void modifySxUrgency(String sx_id,Integer urgency_id);
	
	
	//查询事项(根据事项id)
	Sx getSxBySx_id(String sx_id);
	
	//查某局领导审批了的事项
	List<Sx> getApprovedSxByLeader_id(String leader_id, Sx sx);
	
	//查某局领导待审批的事项
	List<Sx> getUnapprovedSxByLeader_id(String leader_id, Sx sx);
	
	//查某局员工创造的事项
	List<Sx> getSxByFounder_id(String founder_id, Sx sx);
	
	//查某单位领导接收了的事项
	List<Sx> getAcceptedSxByLeader_id(String leader_id, Sx sx);
	
	//查某单位领导还未接收的事项
	List<Sx> getUnacceptedSxByLeader_id(String leader_id, Sx sx);
	
	//查某单位员工相关的事项（其子任务的事项）
	List<Sx> getSxByWorker_id(String worker_id, Sx sx);
	
	//局领导审批事项 + 发送审批通过通知
	void approveSx(String sx_id);
			
	//局领导驳回事项
	public void unapproveSx(String sx_id);

	//单位领导接受事项
	public void acceptSx(String sx_id);

	//单位领导拒绝接受事项
	public void unacceptSx(String sx_id);
	
}
