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

import com.ssafy.happyhouse.dto.Qna;
import com.ssafy.happyhouse.service.QnaService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/qna")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private QnaService qnaService;

    @ApiOperation(value = "모든 질문게시판의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Qna>> retrieveQna() throws Exception {
		logger.debug("retrieveQna - 호출");
		return new ResponseEntity<List<Qna>>(qnaService.retrieveQna(), HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "새로운 질문게시판 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeQna(@RequestBody Qna qna) {
		logger.debug("writeQna - 호출");
		if (qnaService.writeQna(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    @ApiOperation(value = "글번호에 해당하는 질문게시판 정보를 반환한다.", response = Qna.class)    
	@GetMapping("{qna_no}")
	public ResponseEntity<Qna> detailQna(@PathVariable int qna_no) {
		logger.debug("detailQna - 호출");
		return new ResponseEntity<Qna>(qnaService.detailQna(qna_no), HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "글번호에 해당하는 질문게시판 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{qna_no}")
	public ResponseEntity<String> updateNotice(@RequestBody Qna qna) {
		logger.debug("updateQna - 호출");
		logger.debug("" + qna);
		
		if (qnaService.updateQna(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 공지사항의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{qna_no}")
	public ResponseEntity<String> deleteQna(@PathVariable int qna_no) {
		logger.debug("deleteQna - 호출");
		if (qnaService.deleteQna(qna_no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}