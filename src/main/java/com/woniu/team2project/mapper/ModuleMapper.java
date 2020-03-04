package com.woniu.team2project.mapper;
/**
 * 公告：单位内部全体员工可看
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniu.team2project.entity.Module;
import com.woniu.team2project.entity.Notice;
@Mapper
public interface ModuleMapper {
	/**
	 * 新增公告
	 */
	void insertModule(Module module);
	/**
	 * 查看公告
	 * @return
	 */
	List<Module> selectAllModules();
	/**
	 * 修改公告
	 */
	void updateModule(@Param("module_id") Integer module_id,@Param("module_name") String module_name);
	/**
	 * 删除公告
	 */
	void deleteModule(Integer module_id);
}
