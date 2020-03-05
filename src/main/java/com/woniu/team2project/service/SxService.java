package com.woniu.team2project.service;

import com.woniu.team2project.entity.Sx;

public interface SxService {
	//查询事项(根据事项id)
	Sx getSxBySx_id(String sx_id);
	
	//更改事项
	void modifySx(Sx sx);
	
	//删除事项(根据事项id)
	void removeSxBySx_id(String sx_id);
}
