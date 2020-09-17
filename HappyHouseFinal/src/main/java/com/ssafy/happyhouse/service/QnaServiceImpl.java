package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.QnaDAO;
import com.ssafy.happyhouse.dto.Qna;





@Service
public class QnaServiceImpl implements QnaService {
	
    @Autowired
	private QnaDAO qnaDao;

    @Override
	public List<Qna> retrieveQna() {
		return qnaDao.selectQna();
	}
    
  	@Override
	public boolean writeQna(Qna qna) {
		return qnaDao.insertQna(qna) == 1;
	}

	@Override
	public Qna detailQna(int qna_no) {
		return qnaDao.selectQnaByQna_no(qna_no);
	}

	@Override
	@Transactional
	public boolean updateQna(Qna qna) {
		return qnaDao.updateQna(qna) == 1;
	}

	@Override
	@Transactional
	public boolean deleteQna(int qna_no) {
		return qnaDao.deleteQna(qna_no) == 1;
	}
}