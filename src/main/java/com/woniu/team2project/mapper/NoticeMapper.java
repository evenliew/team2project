package com.woniu.team2project.mapper;
/**
 * 公告：单位内部全体员工可看
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.woniu.team2project.entity.Notice;
@Mapper
public interface NoticeMapper {
	/**
	 * 新增公告
	 */
	void insertNotice(Notice notice);
	/**
	 * 查看公告
	 * @return
	 */
	List<Notice> selectAllNotices();
	/**
	 * 修改公告
	 */
	void updateNotice(Notice notice);
	/**
	 * 删除公告
	 */
	void deleteNotice(Integer notice_id);
	
	/**
	 * 主键查询
	 */
	Notice selectNoticeByNotice_Id(Integer notice_id);
	/**
	 * 按条件查询
	 */
	List<Notice> selectNoticesByCondition(Notice notice);
}
