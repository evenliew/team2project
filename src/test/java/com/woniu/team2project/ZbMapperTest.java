package com.woniu.team2project;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Zb_state;
import com.woniu.team2project.mapper.Zb_stateMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZbMapperTest {
	
	@Autowired
	Zb_stateMapper zb_stateMapper;
	
	@Autowired
	DataSource dataSource;
	
	//测试连接池
	@Test
	public void testDruid() {
		System.out.println(dataSource.getClass().getName());
	}
	
	//测试添加状态Dao
	@Test
	public void testInsertZb_state() {
		Zb_state zb_state=new Zb_state(3, "sda");
		zb_stateMapper.insertZb_state(zb_state);
	}
	//测试查询一个
	@Test
	public void testSelectZb_stateByZb_state_id() {
		System.out.println(zb_stateMapper.selectZb_stateByZb_state_id(1));
	}
	//测试查询所有
		@Test
		public void testSelectAllZbDao() {
			List<Zb_state> zbs = zb_stateMapper.selectAllZb_state_id();
			for(Zb_state zb:zbs) {
				System.out.println(zb);
			}
		}
	
}
