package com.woniu.team2project.service;

import java.util.List;

import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
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
	 * 事项立项或者事项审批通过之后发送消息
	 * 参数待定
	 */
	void sendUser_notice(User sender,User receiver,Sx sx,Integer mb_id);
	
	/**
	 * 添加个人通知
	 * @param user_notice
	 */
	void addUser_notice(User_notice user_notice);
	/**
	 * 删除通告
	 */
	void removeUser_notice(Integer user_nt_id);
	
	/**
	 * 查询当前登录用户发布的个人通报
	 */
	List<User_notice> getUser_noticeByUserFb(String user_id);
	/**
	 * 查询当前登录用户接收的个人通报
	 */
	List<User_notice> getUser_noticeByUserRe(String user_id);
	
	/**
	 * 得到个人通告
	 * @param User_nt_id
	 * @return
	 */
	User_notice getUser_noticeByUser_notice_id(Integer user_nt_id);
	/**
	 * 所有的个人通告
	 * @return
	 */
	List<User_notice> getAllUser_notice();
	
	/**
	 * 根据条件查询通报
	 */
	List<User_notice> getUser_noticeByCondition(User_notice user_notice);
}