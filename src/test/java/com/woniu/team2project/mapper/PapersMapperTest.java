package com.woniu.team2project.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Module;
import com.woniu.team2project.entity.Papers;
import com.woniu.team2project.entity.PapersType;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.PapersService;
import com.woniu.team2project.service.impl.PapersServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PapersMapperTest {
	@Autowired
	PapersMapper papersMapper;
	
	@Autowired
	PapersService papersService;
	
	//测试添加状态Dao
	@Test
	public void testInsertpapers() {
		Papers papers=new Papers("2", new Date(), "a.txt", new User("1", null, null, null, null, null, null, null), new Module(1, null, null),
				new Sx("1", null, null, null, null, null, null, null, null, null, null, null, null, null), "ststic", new PapersType(2, null));
		papersMapper.insertPapers(papers);
	}
	//dao查询数据
	@Test
	public void selectPapers() {
		List<Papers> selectPapers = papersMapper.selectPapers();
		System.out.println(selectPapers);
	}
	@Test
	public void selectPapersVig() {
		Papers papers=new Papers("1", null, null, null, null, null, null, null);
		List<Papers> selectPapersVague = papersMapper.selectPapersVague(papers);
		System.out.println(selectPapersVague);
	}
	//service添加数据
	@Test
	public void testAddpapers(){
		Papers papers=new Papers("2", new Date(), "a.txt", new User("1", null, null, null, null, null, null, null), new Module(1, null, null),
				new Sx("1", null, null, null, null, null, null, null, null, null, null, null, null, null), "ststic", new PapersType(2, null));
		papersService.addPapers(papers);
	}
	//数据查询
	@Test
	public void testGetPapers() {
		List<Papers> papers = papersService.getPapers();
		System.out.println(papers);
	}
}
