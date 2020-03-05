package com.woniu.team2project.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Module;
import com.woniu.team2project.entity.Notice;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.mapper.NoticeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeMapperTest {
	

	@Autowired
	NoticeMapper mapper;
	
	@Test
	public void test() {
		Notice notice= new Notice();
		notice.setNotice_id(2);
		notice.setNotice_title("公告2");
		notice.setNotice_content("这是公告2");
		notice.setNotice_time(new Date());
		Module module = new Module();
		module.setModule_id(2);
		notice.setModule(module );
		User notice_founder = new User();
		notice_founder.setUser_id("bbb");
		notice.setNotice_founder(notice_founder );
		mapper.insertNotice(notice);
	}
	@Test
	public void test1() {
		List<Notice> sa = mapper.selectAllNotices();
		System.out.println(sa);
	}
}
