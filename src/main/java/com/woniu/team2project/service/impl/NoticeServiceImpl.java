package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.woniu.team2project.entity.Notice;
import com.woniu.team2project.mapper.NoticeMapper;
import com.woniu.team2project.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	NoticeMapper noticeMapper;
	@Override
	public void addNotice(Notice notice) {
		noticeMapper.insertNotice(notice);
	}

	@Override
	public List<Notice> getAllNotices() {
		PageHelper.startPage(1, 5);
		return noticeMapper.selectAllNotices();
	}

	@Override
	public void alterNotice(Notice notice) {
		noticeMapper.updateNotice(notice);
	}

	@Override
	public void removeNotice(String notice_id) {
		noticeMapper.deleteNotice(notice_id);
	}

}
