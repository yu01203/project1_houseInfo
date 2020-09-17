package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Reply;





@Mapper
public interface ReplyDAO {
	public List<Reply> selectReply();
	public Reply selectReplyByReply_no(int reply_no);
	public int insertReply(Reply reply);
	public int updateReply(Reply reply);
	public int deleteReply(int reply_no);
}