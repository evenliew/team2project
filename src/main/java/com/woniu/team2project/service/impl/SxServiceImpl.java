package com.woniu.team2project.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.entity.User_status;
import com.woniu.team2project.exception.SxException;
import com.woniu.team2project.mapper.SxMapper;
import com.woniu.team2project.service.SxService;
import com.woniu.team2project.service.UserService;
import com.woniu.team2project.service.User_noticeService;

@Service
public class SxServiceImpl implements SxService{

	@Autowired
	SxMapper sxMapper;
	
	@Autowired
	User_noticeService user_noticeService;
	
	@Autowired
	UserService userService;

	
	//新建事项+发送通知提示上级审批（事务）
	@Transactional
	@Override
	public void addSx(Sx sx) {
		// 新建事项
		// 发送通知
	}

	//分页条件查询事项
	@Override
	public List<Sx> getSxByConditionPage(Sx sx) {
		try {
			return sxMapper.selectSxByConditionPage(sx);
		//捕获Dao层的异常
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}
	
	//根据id删除事项
	@Override 
	public void removeSx(String sx_id) {
		try {
			sxMapper.deleteSx(sx_id);
		//捕获Dao层的异常
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}

	//更改事项信息
	@Override
	public void modifySx(Sx sx) {
		try {
			sxMapper.updateSx(sx);
			//查出对应事项
			sx = getSxBySx_id(sx.getSx_id());
			//调用通知模板9：事项内容更新（admin发给事项相关的人）
			User admin = userService.getUserByUser_id("admin");
			user_noticeService.sendUser_notice(admin, sx.getFounder(), sx, 9);
			user_noticeService.sendUser_notice(admin, sx.getFounder().getOffice().getOffice_leader(), sx, 9);
			user_noticeService.sendUser_notice(admin, sx.getOffice().getOffice_leader(), sx, 9);
		//捕获Dao层的异常
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}
	
	@Override
	//修改事项状态
	public void modifySxStatus(String sx_id, Integer sx_status_id) {
		try {
			sxMapper.updateSxStatus(sx_id, sx_status_id);
		//捕获Dao层的异常
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}

	//查询事项(根据事项id)
	public Sx getSxBySx_id(String sx_id) {
		try {
			Sx sxCondition = new Sx();
			sxCondition.setSx_id(sx_id);
			List<Sx> sx = sxMapper.selectSxByConditionPage(sxCondition);
			System.out.println(sx.size());
			return sx.get(0);
		//捕获Dao层的异常
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}
	
	//修改紧急程度
	@Override
	public void modifySxUrgency(String sx_id, Integer urgency_id) {
		try {
			sxMapper.updateSxUrgency(sx_id, urgency_id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}

	//查某局领导审批了的事项
	@Override
	public List<Sx> getApprovedSxByLeader_id(String leader_id, Sx sx) {
		try {
			return sxMapper.selectApprovedSxByLeader_id(leader_id, sx);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}
	
	//查某局领导待审批的事项
	@Override
	public List<Sx> getUnapprovedSxByLeader_id(String leader_id, Sx sx) {
		try {
			return sxMapper.selectUnapprovedSxByLeader_id(leader_id, sx);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}

	//查某局员工创造的事项
	@Override
	public List<Sx> getSxByFounder_id(String founder_id, Sx sx) {
		try {
			return sxMapper.selectSxByFounder_id(founder_id, sx);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}

	//查某单位领导接收了的事项
	@Override
	public List<Sx> getAcceptedSxByLeader_id(String leader_id, Sx sx) {
		try {
			return sxMapper.selectAcceptedSxByLeader_id(leader_id, sx);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}

	//查某单位领导还未接收的事项
	@Override
	public List<Sx> getUnacceptedSxByLeader_id(String leader_id, Sx sx) {
		try {
			return sxMapper.selectUnacceptedSxByLeader_id(leader_id, sx);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}

	//查某单位员工相关的事项（其子任务的事项）
	@Override
	public List<Sx> getSxByWorker_id(String worker_id, Sx sx) {
		try {
			return sxMapper.selectSxByWorker_id(worker_id, sx);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new SxException("系统维护中");
		}
	}
	
	//局领导审批事项 + 发送审批通过通知
	@Transactional
	@Override
	public void approveSx(String sx_id) {
		//更改事项状态为2“已审核”
		modifySxStatus(sx_id, 2);
		//查出对应事项
		Sx sx = getSxBySx_id(sx_id);
		//调用通知模板2：局领导-->事项创建人（审批通过）
		user_noticeService.sendUser_notice(sx.getFounder().getOffice().getOffice_leader(), sx.getFounder(), sx, 2);
		//调用通知模板4：局领导-->接收单位领导（请接收）
		user_noticeService.sendUser_notice(sx.getFounder().getOffice().getOffice_leader(), sx.getOffice().getOffice_leader(), sx, 4);
	}
		
	//局领导驳回事项 + 发送审批未通过通知
	@Transactional
	@Override
	public void unapproveSx(String sx_id) {
		//更改事项状态为3“未通过”
		modifySxStatus(sx_id, 3);
		//查出对应事项
		Sx sx = getSxBySx_id(sx_id);
		//调用通知模板3：局领导-->事项创建人（驳回）
		user_noticeService.sendUser_notice(sx.getFounder().getOffice().getOffice_leader(), sx.getFounder(), sx, 3);
	}

	//单位领导接受事项
	@Transactional
	@Override
	public void acceptSx(String sx_id) {
		//更改事项状态为4“按期进行”
		modifySxStatus(sx_id, 4);
		//查出对应事项
		Sx sx = getSxBySx_id(sx_id);
		//调用通知模板5:接收事项
		user_noticeService.sendUser_notice(sx.getOffice().getOffice_leader(), sx.getFounder(), sx, 5);
		user_noticeService.sendUser_notice(sx.getOffice().getOffice_leader(), sx.getFounder().getOffice().getOffice_leader(), sx, 5);
	}

	//单位领导拒绝接受事项
	@Transactional
	@Override
	public void unacceptSx(String sx_id) {
		//更改事项状态为7“已销项”
		modifySxStatus(sx_id, 7);
		//查出对应事项
		Sx sx = getSxBySx_id(sx_id);
		//调用通知模板6:不接收
		user_noticeService.sendUser_notice(sx.getOffice().getOffice_leader(), sx.getFounder(), sx, 6);
		user_noticeService.sendUser_notice(sx.getOffice().getOffice_leader(), sx.getFounder().getOffice().getOffice_leader(), sx, 6);
	}	
	
}
