package com.woniu.team2project.service;

import java.util.List;

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
}
