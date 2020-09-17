package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.ShopDao;
import com.ssafy.happyhouse.dto.Shop;
import com.ssafy.happyhouse.dto.ShopBean;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao dao;
	
	@Override
	public List<Shop> selectAll(ShopBean bean) {
		return dao.selectShops(bean);
	}

	@Override
	public List<Map<String, String>> getMainCategory() {
		return dao.getMainCategory();
	}

	@Override
	public List<Map<String, String>> getMiddleCategory(String main) {
		return dao.getMiddleCategory(main);
	}

	@Override
	public List<Map<String, String>> getSubCategory(String middle) {
		return dao.getSubCategory(middle);
	}

}
