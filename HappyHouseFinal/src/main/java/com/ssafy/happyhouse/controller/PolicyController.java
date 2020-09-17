package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Policy;
import com.ssafy.happyhouse.service.PolicyService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/policy")
public class PolicyController {

	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private PolicyService policyService;

    @ApiOperation(value = "모든 정책지원 게시판의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Policy>> retrievePolicy() throws Exception {
		logger.debug("retrievePolicy - 호출");
		return new ResponseEntity<List<Policy>>(policyService.retrievePolicy(), HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "새로운 정책 지원 게시판 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writePolicy(@RequestBody Policy policy) {
		logger.debug("writePolicy - 호출");
		if (policyService.writePolicy(policy)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    @ApiOperation(value = "글번호에 해당하는 정책게시판 정보를 반환한다.", response = Policy.class)    
	@GetMapping("{policy_no}")
	public ResponseEntity<Policy> detailPolicy(@PathVariable int policy_no) {
		logger.debug("detailPolicy - 호출");
		return new ResponseEntity<Policy>(policyService.detailPolicy(policy_no), HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "글번호에 해당하는 정책게시판 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{policy_no}")
	public ResponseEntity<String> updatePolicy(@RequestBody Policy policy) {
		logger.debug("updatePolicy - 호출");
		logger.debug("" + policy);
		
		if (policyService.updatePolicy(policy)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 정책 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{policy_no}")
	public ResponseEntity<String> deletePolicy(@PathVariable int policy_no) {
		logger.debug("deletePolicy - 호출");
		if (policyService.deletePolicy(policy_no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}