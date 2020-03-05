package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.woniu.team2project.entity.User_notice;
import com.woniu.team2project.mapper.User_noticeMapper;
import com.woniu.team2project.service.User_noticeService;

@Service
public class User_noticeServiceImpl implements User_noticeService{

	@Autowired
	User_noticeMapper user_noticeMapper;
	@Override
	public void addUser_notice(User_notice user_notice) {
		user_noticeMapper.insertUser_notice(user_notice);
	}

	@Override
	public User_notice getUser_noticeByUser_notice_id(Integer User_nt_id) {
		return user_noticeMapper.selectUser_noticeByUser_notice_id(User_nt_id);
	}

	@Override
	public List<User_notice> getAllUser_notice() {
		PageHelper.startPage(0, 5);
		return user_noticeMapper.selectAllUser_notice();
	}

}
