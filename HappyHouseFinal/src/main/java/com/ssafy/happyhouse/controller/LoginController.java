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

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.MemberService;


import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/member")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private MemberService memberService;

    @ApiOperation(value = "회원 아이디에 해당하는 회원의 정보를 반환한다.", response = Member.class)    
	@GetMapping("{id}")
	public ResponseEntity<Member> detailBoard(@PathVariable String id) {
		logger.debug("detailMember - 호출");
		return new ResponseEntity<Member>(memberService.detailMember(id), HttpStatus.OK);
	}
    
    @ApiOperation(value = "새로운 회원 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeBoard(@RequestBody Member member) {
		logger.debug("writeMember - 호출");
		if (memberService.writeMember(member)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "회원 아이디에 해당하는 회원정보의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> updateBoard(@RequestBody Member member) {
		logger.debug("updateMember - 호출");
		logger.debug("" + member);
		
		if (memberService.updateMember(member)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    @ApiOperation(value = "회원아이디 해당하는 회원정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMember(@PathVariable String id) {
		logger.debug("deleteMember - 호출");
		if (memberService.deleteMember(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}