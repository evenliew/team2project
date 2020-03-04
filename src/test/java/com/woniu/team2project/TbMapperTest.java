package com.woniu.team2project;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.entity.User;
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
		Tb tb = new Tb();
		tb.setTb_id("111");
		User tb_author = new User();
		tb_author.setUser_id("aaa");
		tb.setTb_author(tb_author);
		tb.setTb_time(new Date());
		tb.setTb_content("是四十");
		Office tb_office = new Office();
		tb_office.setOffice_id(1);
		tb.setTb_office(tb_office );
		Sx tb_sx = new Sx();
		tb_sx.setSx_id("1122");
		tb.setTb_sx(tb_sx );
		tbMapper.insertTb(tb );
	}
	@Test
	public void testSelectTbDao() {
		System.out.println(tbMapper.selectTbByTb_id("111"));
	}
	
}
