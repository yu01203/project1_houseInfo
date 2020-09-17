package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Dongcode;
import com.ssafy.happyhouse.dto.Environment;
import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.SearchBean;
import com.ssafy.happyhouse.dto.Shop;
import com.ssafy.happyhouse.dto.ShopBean;
import com.ssafy.happyhouse.service.DongcodeService;
import com.ssafy.happyhouse.service.EnvironmentService;
import com.ssafy.happyhouse.service.HouseDealService;
import com.ssafy.happyhouse.service.ShopService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/deal")
public class SearchRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchRestController.class);
//	private static final String SUCCESS = "success";
//	private static final String FAIL = "fail";
	
	@Autowired
	private HouseDealService houseDealService;
	
	@Autowired
	private EnvironmentService environmentService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private DongcodeService dongcodeService; 
	
	@ApiOperation(value = "선택한 옵션에 해당하는 주택 거래 정보를 반환한다.", response = List.class)
	@PostMapping("list")
	public ResponseEntity<List<Housedeal>> getHouseDeal(@RequestBody SearchBean bean) throws Exception {
		logger.debug("houseDealService.selectAll - 호출");
		
		return new ResponseEntity<List<Housedeal>>(houseDealService.selectAll(bean), HttpStatus.OK);
	}
	
	@ApiOperation(value = "환경 관련 업체 정보를 반환한다.", response = List.class)
	@GetMapping("env/{dong}")
	public ResponseEntity<List<Environment>> getEnv(@PathVariable String dong) throws Exception {
		logger.debug("environmentService.selectAll - 호출");
		
		return new ResponseEntity<List<Environment>>(environmentService.selectAll(dong), HttpStatus.OK);
	}
	
	@ApiOperation(value = "상가 업소 정보를 반환한다.", response = List.class)
	@PostMapping("shop")
	public ResponseEntity<List<Shop>> getShop(@RequestBody ShopBean bean) throws Exception {
		logger.debug("shopService.selectAll - 호출");
		
		return new ResponseEntity<List<Shop>>(shopService.selectAll(bean), HttpStatus.OK);
	}
	
	@ApiOperation(value = "구군목록을 가져온다.", response = List.class)
	@GetMapping("region")
	public ResponseEntity<List<String>> getGuguns() throws Exception {
		logger.debug("dongcodeService.getGuguns - 호출");
		
		return new ResponseEntity<List<String>>(dongcodeService.getGuguns(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "동 목록을 가져온다.", response = List.class)
	@GetMapping("region/{gugunName}")
	public ResponseEntity<List<String>> getDongs(@PathVariable String gugunName) throws Exception {
		logger.debug("dongcodeService.getDongs - 호출");
		
		return new ResponseEntity<List<String>>(dongcodeService.getDongs(gugunName), HttpStatus.OK);
	}

	@ApiOperation(value = "상가 대분류 항목들을 가져온다.", response = List.class)
	@GetMapping("category")
	public ResponseEntity<List<Map<String, String>>> getMains() throws Exception {
		logger.debug("shopService.getMainCategory - 호출");
		
		return new ResponseEntity<List<Map<String, String>>>(shopService.getMainCategory(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "상가 대분류 항목에 대한 중분류 항목들을 가져온다.", response = List.class)
	@GetMapping("middle/{main}")
	public ResponseEntity<List<Map<String, String>>> getMiddles(@PathVariable String main) throws Exception {
		logger.debug("shopService.getMiddleCategory - 호출");
		
		return new ResponseEntity<List<Map<String, String>>>(shopService.getMiddleCategory(main), HttpStatus.OK);
	}
	
	@ApiOperation(value = "상가 중분류 항목에 대한 소분류 항목들을 가져온다.", response = List.class)
	@GetMapping("sub/{middle}")
	public ResponseEntity<List<Map<String, String>>> getSubs(@PathVariable String middle) throws Exception {
		logger.debug("shopService.getSubCategory - 호출");
		
		return new ResponseEntity<List<Map<String, String>>>(shopService.getSubCategory(middle), HttpStatus.OK);
	}

}
