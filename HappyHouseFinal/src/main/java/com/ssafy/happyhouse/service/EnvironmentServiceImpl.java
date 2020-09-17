package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.EnvironmentDao;
import com.ssafy.happyhouse.dto.Environment;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {
	
	@Autowired
	private EnvironmentDao dao;

	@Override
	public List<Environment> selectAll(String dong) {
		return dao.selectEnvs(dong);
	}

}
