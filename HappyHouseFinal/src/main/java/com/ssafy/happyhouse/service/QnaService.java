package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Qna;




public interface QnaService {
	public List<Qna> retrieveQna();
	public Qna detailQna(int qna_no);
	public boolean writeQna(Qna qna);
	public boolean updateQna(Qna qna);
	public boolean deleteQna(int qna_no);
}
