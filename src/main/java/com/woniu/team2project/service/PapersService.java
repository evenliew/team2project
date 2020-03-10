package com.woniu.team2project.service;

import java.util.List;

import com.woniu.team2project.entity.Papers;

public interface PapersService {
	/**
	 * 新增
	 * @param papers
	 */
	public void addPapers(Papers papers);
	/**
	 * 删除
	 * @param file_id
	 */
	public void removePapersPid(String file_id);
	/**
	 * 修改
	 * @param file_id
	 * @param file_name
	 */
	public void modifyPapers(String file_id,String file_name);
	/**
	 * 查询所有信息
	 * @return
	 */
	public List<Papers> getPapers();
	/**
	 * 模糊查询所有
	 * @param papers
	 * @return
	 */
	public List<Papers> getPapersVager(Papers papers);
}
