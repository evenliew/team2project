package com.woniu.team2project.mapper;

import java.util.List;


import com.woniu.team2project.entity.Sx;

public interface SxMapper {
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
	


}
