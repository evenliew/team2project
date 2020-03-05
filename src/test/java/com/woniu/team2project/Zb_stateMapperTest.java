package com.woniu.team2project;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.Zb;
import com.woniu.team2project.entity.Zb_state;
import com.woniu.team2project.mapper.ZbMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Zb_stateMapperTest {
	
	@Autowired
	ZbMapper zbMapper;

	//测试添加事项Dao
	@Test
	public void testInsertZbDao() {
		Zb zb = new Zb();
		zb.setZb_id("ZB6");
		zb.setZb_content("ZBZBZBZBZBZB");
		Zb_state zbs = new Zb_state();
		zbs.setZb_state_id(1);
		zb.setZb_state(zbs);
		zb.setZb_ps_time(new Date());
		zb.setZb_sb_time(new Date());
		Sx xx = new Sx();
		xx.setSx_id("1");
		zb.setZb_sx(xx );
		zb.setZb_remark("备注");
		User user = new User();
		user.setUser_id("aaa");
		zb.setZb_founder(user );
		zb.setZb_recender(user);
		zbMapper.insertZb(zb );
	}
	//测试查询一个
	@Test
	public void testSelectZbByZb_idDao() {
		System.out.println(zbMapper.selectZbByZb_id("ZB1"));
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
