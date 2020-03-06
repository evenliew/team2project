package com.woniu.team2project.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.Zb;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZbServiceTest {
	
	@Autowired
	ZbService zbService;
	
	//测试
	@Test
	public void testZbService(){
		List<Zb> zbs = zbService.getAllZb(null,null);
		for (Zb zb : zbs) {
			System.out.println(zb);
		}
	}
	//测试
	@Test
	public void testGetZbByCondition(){
		Zb zb1=new Zb();User user=new User();user.setUser_id("aaaa");
	//	zb1.setZb_recender(user);
	//	zb1.setZb_founder(user);
		List<Zb> zbs = zbService.getZbByCondition(zb1, 0, 0);
		for (Zb zb : zbs) {
			System.out.println(zb);
		}
	}
}
