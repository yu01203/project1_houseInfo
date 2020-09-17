package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Shop;
import com.ssafy.happyhouse.dto.ShopBean;

public interface ShopService {
	
	List<Shop> selectAll(ShopBean bean);
	
	List<Map<String, String>> getMainCategory();
	
	List<Map<String, String>> getMiddleCategory(String main);
	
	List<Map<String, String>> getSubCategory(String middle);

}
