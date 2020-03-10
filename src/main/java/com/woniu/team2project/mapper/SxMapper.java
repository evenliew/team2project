package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniu.team2project.entity.Sx;

public interface SxMapper {
	//郑老师的方法？
	Sx selecttbSx(Integer officeId);
	
	//新建事项
	void insertSx(Sx sx);
	
	//条件查询事项
	List<Sx> selectSxByConditionPage(Sx sx);

	//删除事项
	void deleteSx(String sx_id);
	
	//修改事项
	void updateSx(Sx sx);
	
	//修改事项状态
	void updateSxStatus(String sx_id,Integer sx_status_id);
	
	//修改事项状态
	void updateSxUrgency(String sx_id,Integer urgency_id);
	
	//查某局领导审批了的事项
	List<Sx> selectApprovedSxByLeader_id(@Param("leader_id")String leader_id, @Param("sx")Sx sx);

	//查某局领导待审批的事项
	List<Sx> selectUnapprovedSxByLeader_id(@Param("leader_id")String leader_id, @Param("sx")Sx sx);
	
	//查某局员工创造的事项
	List<Sx> selectSxByFounder_id(@Param("founder_id")String founder_id, @Param("sx")Sx sx);
	
	//查某单位领导接收了的事项
	List<Sx> selectAcceptedSxByLeader_id(@Param("leader_id")String leader_id, @Param("sx")Sx sx);
	
	//查某单位领导还未接收的事项
	List<Sx> selectUnacceptedSxByLeader_id(@Param("leader_id")String leader_id, @Param("sx")Sx sx);
	
	//查某单位员工相关的事项（其子任务的事项）
	List<Sx> selectSxByWorker_id(@Param("worker_id")String worker_id, @Param("sx")Sx sx);

}
