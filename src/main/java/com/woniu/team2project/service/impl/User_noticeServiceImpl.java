package com.woniu.team2project.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.woniu.team2project.entity.Notice_mb;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.Tb;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_notice;
import com.woniu.team2project.mapper.Notice_mbMapper;
import com.woniu.team2project.mapper.User_noticeMapper;
import com.woniu.team2project.service.User_noticeService;
/**
 * 个人通报实现类
 * @author 94689
 *
 */
@Service
public class User_noticeServiceImpl implements User_noticeService{

	/**
	 * 新增个人通报
	 */
	@Autowired
	User_noticeMapper user_noticeMapper;
	
	@Autowired
	Notice_mbMapper notice_mbMapper;
	@Override
	public void addUser_notice(User_notice user_notice) {
		user_noticeMapper.insertUser_notice(user_notice);
	}
	/**
	 * 根据id查询个人通报
	 */
	@Override
	public User_notice getUser_noticeByUser_notice_id(Integer User_nt_id) {
		return user_noticeMapper.selectUser_noticeByUser_notice_id(User_nt_id);
	}
	/**
	 * 查询所有的个人通报信息
	 */
	@Override
	public List<User_notice> getAllUser_notice() {
		return user_noticeMapper.selectAllUser_notice();
	}
	/**
	 * 根据条件插叙所有的个人通报
	 */
	@Override
	public List<User_notice> getUser_noticeByCondition(User_notice user_notice) {
		return user_noticeMapper.selectUser_noticeByCondition(user_notice);
	}
	/**
	 * 删除个人通告
	 */
	@Override
	public void removeUser_notice(Integer user_nt_id) {
		user_noticeMapper.deleteUser_notice(user_nt_id);
	}
	/**
	 * 查询当前登录用户发布的个人通报
	 */
	@Override
	public List<User_notice> getUser_noticeByUserFb(String user_id) {
		return user_noticeMapper.selectUser_noticeByUserFb(user_id);
	}
	/**
	 * 查询当前登录用户接收的个人通报
	 */
	@Override
	public List<User_notice> getUser_noticeByUserRe(String user_id) {
		return user_noticeMapper.selectUser_noticeByUserRe(user_id);
	}
	/*
	 * 1，立项。投资促进局的同事创建事项之后，他的领导会收到消息
	 * 2，批准。局里领导批准事项之后，创建事项的员工收到通知
	 * 3，驳回。局里领导驳回事项之后，创建事项的员工收到通知
	 * 4，分派。局里领导驳回事项之后，被分配事项的单位的领导会收到消息
	 */
	@Override
	public void sendUser_notice(User sender, User receiver, Sx sx, Integer mb_id) {
		Notice_mb mb = notice_mbMapper.selectNotice_mbByNotice_mb_id(mb_id);
		User_notice notice = new User_notice();
		switch (mb_id) {
		case 1:
			notice.setUser_nt_founder(sender);//发送人
			notice.setUser_nt_recender(receiver);//接收人
			notice.setUser_nt_title("有新事项立项");//主题
			notice.setUser_nt_content("查看详情");//内容
			notice.setUser_nt_mb(mb);//模板
			notice.setUser_nt_time(new Date());//时间
			notice.setUser_nt_sx(sx);
			break;
		case 2:
			notice.setUser_nt_founder(sender);//发送人
			notice.setUser_nt_recender(receiver);//接收人
			notice.setUser_nt_title("事项已被批准");//主题
			notice.setUser_nt_content("事项已被批准");//内容
			notice.setUser_nt_mb(mb);//模板
			notice.setUser_nt_time(new Date());//时间
			notice.setUser_nt_sx(sx);
			break;
		case 3:
			notice.setUser_nt_founder(sender);//发送人
			notice.setUser_nt_recender(receiver);//接收人
			notice.setUser_nt_title("事项已被驳回");//主题
			notice.setUser_nt_content("您申请的事项已被驳回");//内容
			notice.setUser_nt_mb(mb);//模板
			notice.setUser_nt_time(new Date());//时间
			notice.setUser_nt_sx(sx);
			break;
		case 4:
			notice.setUser_nt_founder(sender);//发送人
			notice.setUser_nt_recender(receiver);//接收人
			notice.setUser_nt_title("分派");//主题
			notice.setUser_nt_content("你有一个新的事项分派");//内容
			notice.setUser_nt_mb(mb);//模板
			notice.setUser_nt_time(new Date());//时间
			notice.setUser_nt_sx(sx);
			break;
		}
		user_noticeMapper.insertUser_notice(notice);
	}

}
