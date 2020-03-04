package com.woniu.team2project.service;

import java.util.List;

import com.woniu.team2project.entity.Notice;

/**
 * 通告：人对单位
 * @author Administrator
 *
 */
public interface NoticeService {
	//添加通告
	void addNotice(Notice notice);
	//查看公告
	List<Notice> getAllNotices();
	//修改公告
	void alterNotice(Notice notice);
	//删除公告
	void removeNotice(String notice_id);
}
