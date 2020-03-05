package com.woniu.team2project;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_notice;
import com.woniu.team2project.mapper.User_noticeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User_noticeMapperTest {
	
	@Autowired
	User_noticeMapper user_noticeMapper;
	
	@Autowired
	DataSource dataSource;
	
	//测试连接池
	@Test
	public void testDruid() {
		System.out.println(dataSource.getClass().getName());
	}
	
	//测试添加状态Dao
	@Test
	public void testInsertUser_notice() {
		User_notice notice = new User_notice();
		notice.setUser_nt_id(1233);
		notice.setUser_nt_content("的撒大");
		User user=new User();
		user.setUser_id("eee");
		notice.setUser_nt_founder(user);
		notice.setUser_nt_recender(user);
		Sx user_nt_sx_id = new Sx();
		user_nt_sx_id.setSx_id("112");
		notice.setUser_nt_sx(user_nt_sx_id);
		notice.setUser_nt_time(new Date());
		notice.setUser_nt_title("发士大夫大师傅");
		user_noticeMapper.insertUser_notice(notice );
	}
	//测试查询一个
	@Test
	public void testSelectUser_noticeByUser_notice_id() {
		User_notice user_notice =
				user_noticeMapper.selectUser_noticeByUser_notice_id(111);
		System.out.println(user_notice);
	}
	//测试查询所有
		@Test
		public void testSelectAllUser_notice() {
			List<User_notice> uns = user_noticeMapper.selectAllUser_notice();
			for(User_notice un:uns) {
				System.out.println(un);
			}
		}
	
}
