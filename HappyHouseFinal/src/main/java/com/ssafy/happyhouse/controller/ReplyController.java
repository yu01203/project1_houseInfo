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

import com.ssafy.happyhouse.dto.Reply;
import com.ssafy.happyhouse.service.ReplyService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/reply")
public class ReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ReplyService replyService;

    @ApiOperation(value = "모든 질문게시판의 댓글 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Reply>> retrieveReply() throws Exception {
		logger.debug("retrieveReply - 호출");
		return new ResponseEntity<List<Reply>>(replyService.retrieveReply(), HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "새로운 질문게시판 댓글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeReply(@RequestBody Reply reply) {
		logger.debug("writeReply - 호출");
		if (replyService.writeReply(reply)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    @ApiOperation(value = "글번호에 해당하는 질문게시판 정보를 반환한다.", response = Reply.class)    
	@GetMapping("{reply_no}")
	public ResponseEntity<Reply> detailReply(@PathVariable int reply_no) {
		logger.debug("detailReply - 호출");
		return new ResponseEntity<Reply>(replyService.detailReply(reply_no), HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "글번호에 해당하는 질문게시판 댓글 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{reply_no}")
	public ResponseEntity<String> updateReply(@RequestBody Reply reply) {
		logger.debug("updateReply - 호출");
		logger.debug("" + reply);
		
		if (replyService.updateReply(reply)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "댓글 번호에 해당하는 댓글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{reply_no}")
	public ResponseEntity<String> deleteReply(@PathVariable int reply_no) {
		logger.debug("deleteReply - 호출");
		if (replyService.deleteReply(reply_no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}