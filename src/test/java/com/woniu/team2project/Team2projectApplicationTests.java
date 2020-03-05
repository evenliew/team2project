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
import com.woniu.team2project.mapper.SxDataMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Team2projectApplicationTests {
	
	@Autowired
	SxMapper sxMapper;
	
	@Autowired
	SxDataMapper sxDataMapper;
	
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
		Sx sx=new Sx("2233", "测试事项", new Sx_type(1, "类型一"),new Sx_status(1, "状态一") ,
				new Date(), new User("1122", "1","1", "1", "1", new User_status(1,
				"1"), new Area(1, "1"), new Office(1,"1", new User())), "我的内容", "我的备注", 
				new Urgency(1, "1"), new County(1, "1", new Area(1,"1")), new Industry(2,"1"), 
				new Date(), new Office(1, "1", new User()),new Area(1,"a"));
		System.out.println(sx);
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
		Sx sx=new Sx("1122", "测试我的更改事项", new Sx_type(1, "类型一"),new Sx_status(1, "状态一") , 
				new Date(), new User("1122", "1","1", "1", "1", new User_status(1,"1"),
				new Area(1, "1"), new Office(1,"1", new User())), "我的内容", "我的备注", 
				new Urgency(1, "1"), new County(1, "1", new Area(1,"1")), new Industry(1,"1"), 
				new Date(), new Office(1, "1", new User()),new Area(1,"a"));
		sxMapper.updateSx(sx);
	}
	
	//测试更改事项状态
	@Test
	public void testUpdateSxStatusDao() {
		sxMapper.updateSxStatus("1122", 2);
	}
	
	//测试查询事项状态
	@Test
	public void testSelectSxTypeDao() {
		List<Sx_type> types = sxDataMapper.selectSx_type();
		System.out.println(types);
	}
	//测试查询区
	@Test
	public void testSelectAreaDao() {
		List<Area> areas = sxDataMapper.selectArea();
		System.out.println(areas);
	}
	//测试根据区查询县
	@Test
	public void testSelectCountyByArea_idDao() {
		List<County> countys = sxDataMapper.selectCountyByArea_id(1);
		System.out.println(countys);
	}
	//测试查询行业
	@Test
	public void testSelectIndustryDao() {
		List<Industry> industrys = sxDataMapper.selectIndustry();
		System.out.println(industrys);
	}
	//测试查询单位
	@Test
	public void testSelectOfficeDao() {
		List<Office> offices = sxDataMapper.selectOffice();
		System.out.println(offices);
	}
	//测试查询紧急程度
	@Test
	public void testSelectUrgencyDao() {
		List<Urgency> urgencys = sxDataMapper.selectUrgency();
		System.out.println(urgencys);
	}
	
	
}
