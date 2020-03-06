package com.woniu.team2project.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Module;
import com.woniu.team2project.mapper.ModuleMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleMapperTest {
	
	@Autowired
	ModuleMapper moduleMapper;
	
	
	//测试添加状态Dao
	@Test
	public void testInsertmodule() {
		Module module = new Module();
		module.setModule_id(1);
		module.setModule_name("模块一");
		module.setParent(module);
		moduleMapper.insertModule(module );
	}
	
	//测试查询所有
	@Test
	public void testSelectAllModules() {
		System.out.println(moduleMapper.selectAllModules());
	}
	
}
