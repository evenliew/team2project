package com.woniu.team2project.service;

import java.util.List;

import com.woniu.team2project.entity.User_notice;
/**
 * 个人通告业务层：
 * 人对人发送的一个告示信息。
 * 比如：近期某事项如何
 * @author 94689
 *
 */
public interface User_noticeService {
	/**
	 * 添加个人通知
	 * @param user_notice
	 */
	void addUser_notice(User_notice user_notice);
	/**
	 * 得到个人通告
	 * @param User_nt_id
	 * @return
	 */
	User_notice getUser_noticeByUser_notice_id(Integer User_nt_id);
	/**
	 * 所有的个人通告
	 * @return
	 */
	List<User_notice> getAllUser_notice();
}
