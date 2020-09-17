package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Reply;

public interface ReplyService {
	public List<Reply> retrieveReply();
	public Reply detailReply(int reply_no);
	public boolean writeReply(Reply reply);
	public boolean updateReply(Reply reply);
	public boolean deleteReply(int reply_no);
}
