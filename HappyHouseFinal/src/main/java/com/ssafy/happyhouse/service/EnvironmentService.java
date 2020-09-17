package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Environment;

public interface EnvironmentService {

	List<Environment> selectAll(String dong);
}
