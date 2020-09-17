package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Member;


@Mapper
public interface MemberDAO {
	public List<Member> selectMember();
	public Member selectMemberById(String id);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String id);
}