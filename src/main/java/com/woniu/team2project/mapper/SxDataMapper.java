package com.woniu.team2project.mapper;

import java.util.List;

import com.woniu.team2project.entity.Area;
import com.woniu.team2project.entity.County;
import com.woniu.team2project.entity.Industry;
import com.woniu.team2project.entity.Office;
import com.woniu.team2project.entity.Sx_type;
import com.woniu.team2project.entity.Urgency;
import com.woniu.team2project.entity.User;
//这个mapper装新建事项界面要附带查的数据
public interface SxDataMapper {
	//查事项类型
	List<Sx_type> selectSx_type();
	
	//查区
	List<Area> selectArea();
	
	//查县
	List<County> selectCountyByArea_id(Integer area_id);
	
	//查行业
	List<Industry> selectIndustry();
	
	//查单位
	List<Office> selectOffice();
	
	//查紧急程度
	List<Urgency> selectUrgency();
	
	//查领导(根据单位id)
	User selectLeaderByOffice_id(Integer office_id);
	
}
