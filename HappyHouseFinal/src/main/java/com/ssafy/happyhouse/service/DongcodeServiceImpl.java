package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.DongcodeDao;
import com.ssafy.happyhouse.dto.Dongcode;

@Service
public class DongcodeServiceImpl implements DongcodeService {
	
	@Autowired
	private DongcodeDao dao;

	@Override
	public List<String> getGuguns() {
		return dao.getGuguns();
	}

	@Override
	public List<String> getDongs(String gugunName) {
		return dao.getDongs(gugunName);
	}

}
