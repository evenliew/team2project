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
	List<Notice> getAllNotices(Integer pageNum,Integer pageSize);
	//主键查询
	Notice getNoticeByNotice_id( Integer notice_id);
	//修改公告
	void alterNotice(Notice notice);
	//删除公告
	void removeNotice(Integer notice_id);
	//按条件查询公告
	List<Notice> getNoticesByCondition(Notice notice,Integer pageNum,Integer pageSize);
}
