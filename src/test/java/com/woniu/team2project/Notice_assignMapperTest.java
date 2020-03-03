package com.woniu.team2project;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Notice_assign;
import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.mapper.Notice_assignMapper;
import com.woniu.team2project.mapper.TbMapper;

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
		Notice_assign notice_assign=new Notice_assign(2, "aaa", "bb");
		notice_assignMapper.insertNotice_assign(notice_assign);
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
