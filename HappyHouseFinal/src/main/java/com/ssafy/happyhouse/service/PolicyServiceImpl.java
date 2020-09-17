package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.PolicyDAO;
import com.ssafy.happyhouse.dto.Policy;






@Service
public class PolicyServiceImpl implements PolicyService {
	
    @Autowired
	private PolicyDAO policyDao;

    @Override
	public List<Policy> retrievePolicy() {
		return policyDao.selectPolicy();
	}
    
  	@Override
	public boolean writePolicy(Policy policy) {
		return policyDao.insertPolicy(policy) == 1;
	}

	@Override
	public Policy detailPolicy(int policy_no) {
		return policyDao.selectPolicyByPolicy_no(policy_no);
	}

	@Override
	@Transactional
	public boolean updatePolicy(Policy policy) {
		return policyDao.updatePolicy(policy) == 1;
	}

	@Override
	@Transactional
	public boolean deletePolicy(int policy_no) {
		return policyDao.deletePolicy(policy_no) == 1;
	}
}