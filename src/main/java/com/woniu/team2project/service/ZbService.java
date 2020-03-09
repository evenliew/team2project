package com.woniu.team2project.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Zb;

/**
 * 专报的业务层数据处理
 * @author 94689
 *
 */
public interface ZbService {
	/**
	 * 添加专报
	 * @param zb
	 */
	void addZb(Zb zb);
	
	/**
	 * 查询一条专报的操作
	 * @param zb_id
	 * @return
	 */
	Zb getZbByZb_id(String zb_id);
	
	/**
	 * 查询所有专报的操作
	 * 分页显示
	 * @return
	 */
	List<Zb> getAllZb(Integer pageNum,Integer pageSize);
	
	/**
	 * 按条件查询
	 */
	List<Zb> getZbByCondition(Zb zb,Integer pageNum,Integer pageSize);
	
	
	/**
	 * 修改专报的状态
	 */
	void changeZb_state(String zb_id,Integer zb_state_id);
}
