package com.woniu.team2project.service;

import java.util.List;

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
	 * 添加通报
	 * @param tb
	 */
	void addTb(Tb tb);
	
	/**
	 * 查询通报
	 * @param tb_id
	 * @return
	 */
	Tb getTbByTb_id(String tb_id);
	
	/**
	 * 所有通报
	 */
	List<Tb> getAllTbs();
	/**
	 * 根据条件查询通报
	 */
	List<Tb> getTbByCondition(Tb tb);
	/**
	 * 根据通报id删除通告
	 */
	void removeTbByTb_id(String tb_id);
}
