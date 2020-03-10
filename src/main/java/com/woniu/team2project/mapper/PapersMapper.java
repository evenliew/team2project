package com.woniu.team2project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Papers;


@Mapper
public interface PapersMapper {
	/**
	 * 新增文件
	 */
	public void insertPapers(Papers papers);
	/**
	 * 根据文件id删除文件
	 */
	public void deletePapers(String file_id);
	/**
	 *  根据文件id修改文件
	 * @param file_id
	 */
	public void upadtePagers(String file_id,String file_name);
	/**
	 * 查询文件类型所有信息
	 * 分页待完成
	 * @return
	 */
	public List<Papers> selectPapers();
	/**
	 * 模糊查询所有文件信息
	 * @param papers
	 * @return
	 */
	public List<Papers> selectPapersVague(Papers papers);
}
