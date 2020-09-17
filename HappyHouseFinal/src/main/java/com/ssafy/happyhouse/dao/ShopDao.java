package com.ssafy.happyhouse.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Shop;
import com.ssafy.happyhouse.dto.ShopBean;

public interface ShopDao {
	
	//특정 동에 대한 전체 상가 목록 조회
	List<Shop> selectShops(ShopBean bean);
	
	//대분류  목록 가져오기
	List<Map<String, String>> getMainCategory();
	
	//중분류 목록 가져오기
	List<Map<String, String>> getMiddleCategory(String main);
	
	//소분류 목록 가져오기
	List<Map<String, String>> getSubCategory(String middle);
}
