package com.woniu.team2project.service;

import java.util.List;

import com.woniu.team2project.entity.PapersType;

public interface PapersTypeService {
	/**
	 * 新增文件类型
	 * @param papersType
	 */
	public void addPapersType(PapersType papersType);
	/**
	 * 修改文件类型名称
	 * @param file_type_id
	 * @param type_name
	 */
	public void modifyPapersType(String file_type_id,String type_name);
	/**
	 * 根据文件类型名称获取文件类型对象
	 * @param type_name
	 */
	public PapersType getPapersTypeName(String type_name);
	/**
	 * 查询所有文件类型
	 * @return
	 */
	public List<PapersType> getPapersType();
	/**
	 * 模糊查询所有文件类型
	 * @param PapersType
	 * @return
	 */
	public List<PapersType> getPapersTypeVager(PapersType PapersType);
}
