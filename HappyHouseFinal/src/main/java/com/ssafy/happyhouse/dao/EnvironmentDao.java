package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.Environment;

public interface EnvironmentDao {

	//특정 동에 대한 전체 환경업체 조회
	List<Environment> selectEnvs(String dong);
}
