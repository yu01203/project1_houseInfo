package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HousedealDao;
import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.SearchBean;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	@Autowired
	private HousedealDao dao;
	
	@Override
	public List<Housedeal> selectAll(SearchBean bean) {
		return dao.selectDeals(bean);
	}

	@Override
	public Housedeal selectOne(int no) {
		return dao.selectDeal(no);
	}

}
