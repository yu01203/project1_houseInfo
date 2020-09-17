package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Policy;




@Mapper
public interface PolicyDAO {
	public List<Policy> selectPolicy();
	public Policy selectPolicyByPolicy_no(int policy_no);
	public int insertPolicy(Policy policy);
	public int updatePolicy(Policy policy);
	public int deletePolicy(int policy_no);
}