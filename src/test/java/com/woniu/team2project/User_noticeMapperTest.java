
package com.woniu.team2project;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Notice_mb;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_notice;
import com.woniu.team2project.mapper.User_noticeMapper;
import com.woniu.team2project.service.User_noticeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User_noticeMapperTest {
	
	@Autowired
	User_noticeMapper user_noticeMapper;
	
	@Autowired
	User_noticeService user_noticeService;
	
	@Autowired
	DataSource dataSource;
	
	//测试连接池
	@Test
	public void testAll() {
		List<User_notice> all = user_noticeService.getAllUser_notice();
		for(User_notice notice:all) {
			System.out.println(notice);
		}
	}
	/**
	 * 测试条件查询
	 */
	@Test
	public void testCondition() {
		User_notice user_notice = new User_notice();
//		user_notice.setUser_nt_content("nt");
//		user_notice.setUser_nt_title("旗");
		User user = new User();
		user.setUser_id("bbb");
//		user_notice.setUser_nt_founder(user );
//		user_notice.setUser_nt_recender(user);
		Sx user_nt_sx=  new Sx();
		user_nt_sx.setSx_id("123");
		user_notice.setUser_nt_sx(user_nt_sx);
		List<User_notice> all = user_noticeService.getUser_noticeByCondition(user_notice );
		for(User_notice notice:all) {
			System.out.println(notice);
		}
	}
	
	//测试添加状态Dao
	@Test
	public void testInsertUser_notice() {
		User_notice notice = new User_notice();
		notice.setUser_nt_id(1234);
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
		Notice_mb user_nt_mb = new Notice_mb();
		user_nt_mb.setNotice_mb_id(1);
		notice.setUser_nt_mb(user_nt_mb );
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
		@Test
		public void SelectAllUser_notice() {
			List<User_notice> uns = user_noticeService.getAllUser_notice();
			for(User_notice un:uns) {
				System.out.println(un);
			}
		}
}
