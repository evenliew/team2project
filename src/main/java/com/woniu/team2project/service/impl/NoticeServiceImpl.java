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
	public List<Notice> getAllNotices(Integer pageNum,Integer pageSize) {
		if(pageNum==null ||pageNum==0) {
			pageNum=1;
		}
		if(pageSize==null ||pageSize==0) {
			pageSize=5;
		}
		PageHelper.startPage(pageNum, pageSize);
		return noticeMapper.selectAllNotices();
	}

	@Override
	public void alterNotice(Notice notice) {
		noticeMapper.updateNotice(notice);
	}

	@Override
	public void removeNotice(Integer notice_id) {
		noticeMapper.deleteNotice(notice_id);
	}

	@Override
	public List<Notice> getNoticesByCondition(Notice notice,Integer pageNum,Integer pageSize) {
		if(pageNum==null ||pageNum==0) {
			pageNum=1;
		}
		if(pageSize==null ||pageSize==0) {
			pageSize=5;
		}
		PageHelper.startPage(pageNum, pageSize);
		return noticeMapper.selectNoticesByCondition(notice);
	}

	@Override
	public Notice getNoticeByNotice_id(Integer notice_id) {
		return noticeMapper.selectNoticeByNotice_Id(notice_id);
		
	}

}
