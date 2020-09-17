package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Dongcode;

public interface DongcodeService {

	//시구군 조회
		List<String> getGuguns();
		
		//동 조회
		List<String> getDongs(String gugunName);
}
