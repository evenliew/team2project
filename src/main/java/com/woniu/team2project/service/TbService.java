package com.woniu.team2project.service;

import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Tb;
/**
 * 通告业务层：所有通告的操作都在此层完成
 * @author 94689
 *
 */
@Service
public interface TbService {
	/**
	 * 添加通告
	 * @param tb
	 */
	void addTb(Tb tb);
	
	/**
	 * 查询通告
	 * @param tb_id
	 * @return
	 */
	Tb getTbByTb_id(String tb_id);
}
