package com.woniu.team2project;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.entity.Zb;
import com.woniu.team2project.mapper.TbMapper;
import com.woniu.team2project.mapper.ZbMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Zb_stateMapperTest {
	
	@Autowired
	ZbMapper zbMapper;
	
	@Autowired
	DataSource dataSource;
	
	//测试连接池
	@Test
	public void testDruid() {
		System.out.println(dataSource.getClass().getName());
	}
	
	//测试添加事项Dao
	@Test
	public void testInsertZbDao() {
		Zb zb=new  Zb("sa", new Date(), "aaaa", 23, "aaaaw",
				"aaaa", "aaaa", new Date(), "aaaa");
		zbMapper.insertZb(zb);
	}
	//测试查询一个
	@Test
	public void testSelectZbByZb_idDao() {
		System.out.println(zbMapper.selectZbByZb_id("aaa"));
	}
	//测试查询所有
		@Test
		public void testSelectAllZbDao() {
			List<Zb> zbs = zbMapper.selectAllZb();
			for(Zb zb:zbs) {
				System.out.println(zb);
			}
		}
	//测试修改状态
	@Test
	public void testUpdateZbDao() {
		zbMapper.updateZb_state("aaa", 1);
	}
}
