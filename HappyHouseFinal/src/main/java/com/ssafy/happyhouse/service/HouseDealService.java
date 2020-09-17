package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.SearchBean;

public interface HouseDealService {
	
	List<Housedeal> selectAll(SearchBean bean);
	
	Housedeal selectOne(int no);
}
