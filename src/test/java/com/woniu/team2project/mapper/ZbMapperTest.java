package com.woniu.team2project.mapper;

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
import com.woniu.team2project.service.ZbService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZbMapperTest {
	
	@Autowired
	ZbMapper zbMapper;
	
	//测试条件查询
	@Test
	public void testSelectZbByCondition() {
		Zb zb1=new Zb();
		
		
		
		/*User zb_recender=new User();zb_recender.setUser_id("aaaa");
		 *	zb1.setZb_recender(zb_recender);
		 * User zb_founder=new User();zb_founder.setUser_id("aaaa");
		 * zb1.setZb_founder(zb_founder);
		 */
		
		/*测试类型
		 * Zb_state zb_state=new Zb_state();zb_state.setZb_state_id(21);
		 * zb1.setZb_state(zb_state);
		 */
	//	zb1.setZb_remark("sss");	测试备注
	//	zb1.setZb_content("aaa");	测试内容
		List<Zb> zbs = zbMapper.selectZbByCondition(zb1);
		for(Zb zb:zbs) {
			System.out.println(zb);
		}
	}
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
