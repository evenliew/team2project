package com.woniu.team2project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.team2project.entity.Papers;
import com.woniu.team2project.mapper.PapersMapper;
import com.woniu.team2project.service.PapersService;
@Service
public class PapersServiceImpl implements PapersService {
	
	@Autowired
	PapersMapper papersMapper;
	@Override
	public void addPapers(Papers papers) {
		System.out.println(papers+"****");
		papersMapper.insertPapers(papers);
	}

	@Override
	public void removePapersPid(String file_id) {
		papersMapper.deletePapers(file_id);
	}

	@Override
	public void modifyPapers(String file_id, String file_name) {
		papersMapper.upadtePagers(file_id, file_name);
	}

	@Override
	public List<Papers> getPapers() {
		return papersMapper.selectPapers();
	}

	@Override
	public List<Papers> getPapersVager(Papers papers) {
		return papersMapper.selectPapersVague(papers);
	}

	
	
	

}
