package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.SearchBean;

public interface HousedealDao {

	//전체 내역 조회
	List<Housedeal> selectDeals(SearchBean bean);
	
	//특정 내역 조회
	Housedeal selectDeal(int no);
	
}
