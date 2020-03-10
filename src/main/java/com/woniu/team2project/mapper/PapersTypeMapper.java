package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.PapersType;

@Mapper
public interface PapersTypeMapper {
	
	/**
	 * 修改文件类型名称
	 * @param file_type_id
	 * @param type_name
	 */
	public void updatePapersType(String file_type_id,String type_name); 
	/**
	 * 新增文件类型
	 * @param papersType
	 */
	public void insertPagepersType(PapersType papersType);
	/**
	 * 查询文件类型表中的所有信息
	 * @return
	 */
	public PapersType selectPapersTypeName(String type_name);
	/**
	 * 查询文件类型表中的所有信息
	 * @return
	 */
	public List<PapersType> selectPapersType();
	/**
	 * 模糊查询文件所有类型
	 * @param papersType
	 * @return
	 */
	public List<PapersType> selectPapersTypeVague(PapersType papersType);
	
}	
