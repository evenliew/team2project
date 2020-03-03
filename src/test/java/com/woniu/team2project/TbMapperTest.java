package com.woniu.team2project;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.mapper.TbMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbMapperTest {
	
	@Autowired
	TbMapper tbMapper;
	
	@Autowired
	DataSource dataSource;
	
	//测试连接池
	@Test
	public void testDruid() {
		System.out.println(dataSource.getClass().getName());
	}
	
	//测试添加事项Dao
	@Test
	public void testInsertTbDao() {
		Tb tb=new Tb("aaa", new Date(),21, "sss", "sss", "aaa");
		tbMapper.insertTb(tb);
	}
	@Test
	public void testSelectTbDao() {
		System.out.println(tbMapper.selectTbByTb_id("aaa"));
	}
	
}
