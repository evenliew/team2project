package com.woniu.team2project;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.mapper.Notice_assignMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Notice_assignMapperTest {
	
	@Autowired
	Notice_assignMapper notice_assignMapper;
	
	@Autowired
	DataSource dataSource;
	
	//测试连接池
	@Test
	public void testDruid() {
		System.out.println(dataSource.getClass().getName());
	}
	
	//测试添加事项Dao
	@Test
	public void testInsertNotice_assign() {
	}
	//测试主键查询一个
	@Test
	public void testSelectNotice_assignByNotice_assign_id() {
		System.out.println(
				notice_assignMapper.selectNotice_assignByNotice_assign_id(1));
	}
	//测试通过用户名id查询多个
	@Test
	public void testSelectNotice_assignByRecender_id() {
		System.out.println(
				notice_assignMapper.selectNotice_assignByRecender_id("aaa"));
	}
}
