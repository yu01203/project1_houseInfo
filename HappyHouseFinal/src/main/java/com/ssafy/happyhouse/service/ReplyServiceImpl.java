package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.ReplyDAO;
import com.ssafy.happyhouse.dto.Reply;



@Service
public class ReplyServiceImpl implements ReplyService {
	
    @Autowired
	private ReplyDAO replyDao;

    @Override
	public List<Reply> retrieveReply() {
		return replyDao.selectReply();
	}
    
  	@Override
	public boolean writeReply(Reply reply) {
		return replyDao.insertReply(reply) == 1;
	}

	@Override
	public Reply detailReply(int reply_no) {
		return replyDao.selectReplyByReply_no(reply_no);
	}

	@Override
	@Transactional
	public boolean updateReply(Reply reply) {
		return replyDao.updateReply(reply) == 1;
	}

	@Override
	@Transactional
	public boolean deleteReply(int reply_no) {
		return replyDao.deleteReply(reply_no) == 1;
	}
}