package com.woniu.team2project.service;

import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Zb;

/**
 * 专报的业务层数据处理
 * @author 59255
 *
 */
public interface ZbService {
	//添加操作
	void addZb(Zb zb);
	
	//查询一条专报的操作
	Zb getZbByZb_id(String zb_id);
	
	//查询所有专报的操作
	PageInfo<Zb> getAllZb();
}
