package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Notice;


@Mapper
public interface NoticeDAO {
	public List<Notice> selectNotice();
	public Notice selectNoticeBynotice_no(int notice_no);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(int notice_no);
}