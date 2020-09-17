package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.MemberDAO;
import com.ssafy.happyhouse.dto.Member;


@Service
public class MemberServiceImpl implements MemberService {
	
    @Autowired
	private MemberDAO memberDao;

    @Override
	public List<Member> retrieveMember() {
		return memberDao.selectMember();
	}
    
  	@Override
	public boolean writeMember(Member member) {
		return memberDao.insertMember(member) == 1;
	}

	@Override
	public Member detailMember(String id) {
		return memberDao.selectMemberById(id);
	}

	@Override
	@Transactional
	public boolean updateMember(Member member) {
		return memberDao.updateMember(member) == 1;
	}

	@Override
	@Transactional
	public boolean deleteMember(String id) {
		return memberDao.deleteMember(id) == 1;
	}
}