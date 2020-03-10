package com.woniu.team2project;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Plan;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Sx_status;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_status;
import com.woniu.team2project.mapper.LoginAndRegisteredMapper;
import com.woniu.team2project.mapper.PlanMapper;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.mapper.UserMapper;
import com.woniu.team2project.service.PlanService;
import com.woniu.team2project.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Team2projectApplicationTests {
	
	@Autowired
	SxMapper sxMapper;

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PlanMapper planMapper;
	
	@Autowired
	UserService userService;
	
	@Autowired
	LoginAndRegisteredMapper regis;

	@Autowired
	PlanService planService;
	
	//测试连接池
	@Test
	public void testDruid() {
		System.out.println(dataSource.getClass().getName());
	}
	
	//测试添加事项Dao
	@Test
	public void testInsertSxDao() {
//		Sx sx=new Sx("1006", "我的事项", new Sx_type(1, "类型一"),new Sx_status(1, "状态一") , new Date(), new User("121", "1","1", "1", "1", new User_status(1,
//				"1"), new Area(1, "1"), new Office(1,"1", "111")), "我的内容", "我的备注", new Urgency(1, "1"), new County(1, "1", new Area(1,"1")), new Industry(1,"1")
//				,new Date(),new Office(1,"s","121"));
//		Sx sx=new Sx("2233", "测试事项", new Sx_type(1, "类型一"),new Sx_status(1, "状态一") ,
//				new Date(), new User("1122", "1","1", "1", "1", new User_status(1,
//				"1"), new Area(1, "1"), new Office(1,"1", new User())), "我的内容", "我的备注", 
//				new Urgency(1, "1"), new Area(2, "地区"), new County(1, "1", new Area(1,"1")), new Industry(1,"1"), 
//				new Date(), new Office(1, "1", new User()));
//				new Urgency(1, "1"), new County(1, "1", new Area(1,"1")), new Industry(2,"1"), 
//				new Date(), new Office(1, "1", new User()),new Area(1,"a"));
//		System.out.println(sx);
//		sxMapper.insertSx(sx);
	}
	 
	//测试条件查询事项Dao+分页
	@Test
	public void testSelectSxByConditionPage() {
		
		//分页插件pageHelper:页索引，页大小
		PageHelper.startPage(1, 3);
		Sx mysx= new Sx();
//		mysx.setSx_status(new Sx_status(4,"")); //测试事项状态为4的
//		mysx.setSx_end_time(new Date()); //测试今天以前创建的
		List<Sx> sxs = sxMapper.selectSxByConditionPage(mysx);
		PageInfo<Sx> sxsPage = new PageInfo<>(sxs);
		System.out.println("页索引: " + sxsPage.getPageNum());
		System.out.println("页大小: " + sxsPage.getPageSize());
		System.out.println("总条数: " + sxsPage.getTotal());
		System.out.println("总页数: " + sxsPage.getPages());
		for(Sx sx: sxsPage.getList()) {
			System.out.println(sx);
		}
		
	}
	
	
	
	//测试删除事项
	@Test
	public void testDeleteSxDao() {
		sxMapper.deleteSx("1122");
	}
	
	//测试更新事项
	/*
	 * @Test public void testUpdateSxDao() { Sx sx=new Sx("1122", "测试更改事项", new
	 * Sx_type(1, "类型一"),new Sx_status(1, "状态一") , new Date(), new User("1122",
	 * "1","1", "1", "1", new User_status(1,"1"), new Area(1, "1"), new
	 * Office(1,"1", new User())), "我的内容", "我的备注", new Urgency(1, "1"), new Area(1,
	 * "1"), new County(1, "1", new Area(1,"1")), new Industry(1,"1"), new Date(),
	 * new Office(1, "1", new User())); sxMapper.updateSx(sx); }
	 */
	
	//测试更改事项状态
	@Test
	public void testUpdateSxStatusDao() {
		sxMapper.updateSxStatus("1122", 2);
	}
	


	@Test
	public void testgetselectBm_leader_idByUserName() {
		System.out.println(userService.getSelectBm_leader_idByUserName("qqqq"));
	}
	@Test
	public void test1() {
		System.out.println(userMapper.selectleaderNameByleander_id("qqqq"));
	}
	@Test
	public void test2() {
		System.out.println(sxMapper.selecttbSx(1));
	}
	@Test
	public void test3() {
		System.out.println(planMapper.seleListplans("121"));
	}
	

	@Test
	public void getPlans() {
		
		System.out.println(planMapper.seleListplans("121"));
		 
	}
	
	@Test
	public void selectAllStudentByPageCount() {
		Plan plan=new Plan();
		User user=new User();
		Date date=new Date("20");
		plan.setPlan_time(date);
		System.out.println(planMapper.selectAllPlanByPageCount(plan));
		 
	}
	@Test
	public void selectAllPlansByPagelist() {
		Plan plan=new Plan();
		plan.setPlan_content("涨薪");
		int pageIndex=1;
		int pageSize=2;
		System.out.println(planService.pagebeanList(plan, pageIndex, pageSize));
		 
	}
	
	@Test
	public void selectAllPlansByPage() {
		Plan plan=new Plan();
		Integer pageIndex=1;
		Integer pageSize=2;
		System.out.println(planMapper.selectAllPlansByPage(plan, pageIndex, pageSize));
	} 
	@Test
	public void testloginusername() {
		System.out.println(regis.selectAllUser("张三"));
	}
	@Test
	public void testoffice() {
		System.out.println(regis.selectAllOffice());
	}
	@Test
	public void selectAllOffice() {
		System.out.println(regis.selectAllOffice());
	}
	@Test
	public void SelectPassWordByAccount() {
		System.out.println(userMapper.SelectPassWordByAccount("bbbb"));
	}
	@Test
	public void insertIntoPlan() {
		planMapper.insertIntoPlan(new Plan());
	}
	
	
	
}
