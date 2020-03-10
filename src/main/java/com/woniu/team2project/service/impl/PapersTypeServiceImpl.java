package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.woniu.team2project.entity.PapersType;
import com.woniu.team2project.mapper.PapersTypeMapper;
import com.woniu.team2project.service.PapersTypeService;

public class PapersTypeServiceImpl implements PapersTypeService {
	private static final String String = null;
	@Autowired
	PapersTypeMapper papersTypeMapper;

	public PapersTypeMapper getPapersTypeMapper() {
		return papersTypeMapper;
	}

	public void setPapersTypeMapper(PapersTypeMapper papersTypeMapper) {
		this.papersTypeMapper = papersTypeMapper;
	}

	@Override
	public void addPapersType(PapersType papersType) {
		papersTypeMapper.insertPagepersType(papersType);
	}
	
	@Override
	public PapersType getPapersTypeName(String type_name) {
		return papersTypeMapper.selectPapersTypeName(type_name);
	}
	
	@Override
	public List<PapersType> getPapersType() {
		return papersTypeMapper.selectPapersType();
	}

	@Override
	public List<PapersType> getPapersTypeVager(PapersType PapersType) {
		return papersTypeMapper.selectPapersTypeVague(PapersType);
	}

	@Override
	public void modifyPapersType(String file_type_id, String type_name) {
		papersTypeMapper.updatePapersType(file_type_id, type_name);
	}

	

}
