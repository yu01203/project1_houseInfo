package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Qna;




@Mapper
public interface QnaDAO {
	public List<Qna> selectQna();
	public Qna selectQnaByQna_no(int qna_no);
	public int insertQna(Qna qna);
	public int updateQna(Qna qna);
	public int deleteQna(int qna_no);
}