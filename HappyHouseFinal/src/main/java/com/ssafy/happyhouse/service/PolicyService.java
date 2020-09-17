package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Policy;




public interface PolicyService {
	public List<Policy> retrievePolicy();
	public Policy detailPolicy(int policy_no);
	public boolean writePolicy(Policy policy);
	public boolean updatePolicy(Policy policy);
	public boolean deletePolicy(int policy_no);
}
