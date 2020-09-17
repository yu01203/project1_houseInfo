package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Member;



public interface MemberService {
	public List<Member> retrieveMember();
	public Member detailMember(String id);
	public boolean writeMember(Member member);
	public boolean updateMember(Member member);
	public boolean deleteMember(String id);
}
