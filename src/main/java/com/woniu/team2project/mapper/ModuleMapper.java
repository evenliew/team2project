package com.woniu.team2project.mapper;
/**
 * 公告：单位内部全体员工可看
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniu.team2project.entity.Module;
@Mapper
public interface ModuleMapper {
	/**
	 * 新增模板
	 */
	void insertModule(Module module);
	/**
	 * 查看模板
	 * @return
	 */
	List<Module> selectAllModules();
	/**
	 * 修改模板
	 */
	void updateModule(@Param("module_id") Integer module_id,@Param("module_name") String module_name);
	/**
	 * 删除模板
	 */
	void deleteModule(Integer module_id);
}
