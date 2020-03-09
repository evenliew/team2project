package com.woniu.team2project.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.team2project.entity.Sx_task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SxTaskMapperTest {
	@Autowired
	SxTaskMapper sxTaskMapper;
	
	@Test
	public void testSelectBySx_task_id() {
		Sx_task task = sxTaskMapper.selectTaskByTask_id("1");
		System.out.println("1:"+task);
		List<Sx_task> selectTask = sxTaskMapper.selectTask("1122");
		System.out.println("2:"+task);
		
		task.setSx_task_content("update内容");
		sxTaskMapper.updateTask(task);
		task.setSx_task_id("1234");
		//sxTaskMapper.insertTask(task);
		
		List<Sx_task> tasks = sxTaskMapper.selectTaskByUser_id("1122");
		System.out.println(tasks);
	}
}
