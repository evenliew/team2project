package com.woniu.team2project;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Sx_status;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_status;
import com.woniu.team2project.mapper.SxMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Team2projectApplicationTests {
	
	@Autowired
	SxMapper sxMapper;
	
	@Autowired
	DataSource dataSource;
	
	//测试连接池
	@Test
	public void testDruid() {
		System.out.println(dataSource.getClass().getName());
	}
	
	//测试添加事项Dao
	@Test
	public void testInsertSxDao() {
		Sx sx=new Sx("1133", "测试事项", new Sx_type(1, "类型一"),new Sx_status(1, "状态一") ,
				new Date(), new User("1122", "1","1", "1", "1", new User_status(1,
				"1"), new Area(1, "1"), new Office(1,"1", new User())), "我的内容", "我的备注", 
				new Urgency(1, "1"), new County(1, "1", new Area(1,"1")), new Industry(1,"1"), 
				new Date(), new Office(1, "1", new User()));
		sxMapper.insertSx(sx);
	}
	
	//测试条件查询事项Dao+分页
	@Test
	public void testSelectSxByConditionPage() {
		
		//分页插件pageHelper:页索引，页大小
		PageHelper.startPage(1, 3);
		Sx mysx= new Sx();
//		mysx.setSx_status(new Sx_status(4,"")); //测试事项状态为4的
//		mysx.setSx_end_time(new Date()); //测试今天以前创建的
		List<Sx> sxlist = sxMapper.selectSxByConditionPage(mysx);
		for(Sx sx:sxlist) {
			System.out.println(sx);
		}
	}
	
	
	
	//测试删除事项
	@Test
	public void testDeleteSxDao() {
		sxMapper.deleteSx("1122");
	}
	
	//测试更新事项
	@Test
	public void testUpdateSxDao() {
		Sx sx=new Sx("1122", "测试更改事项", new Sx_type(1, "类型一"),new Sx_status(1, "状态一") , 
				new Date(), new User("1122", "1","1", "1", "1", new User_status(1,"1"),
				new Area(1, "1"), new Office(1,"1", new User())), "我的内容", "我的备注", 
				new Urgency(1, "1"), new County(1, "1", new Area(1,"1")), new Industry(1,"1"), 
				new Date(), new Office(1, "1", new User()));
		sxMapper.updateSx(sx);
	}
	
	//测试更改事项状态
	@Test
	public void testUpdateSxStatusDao() {
		sxMapper.updateSxStatus("1122", 3);
	}
	

}
