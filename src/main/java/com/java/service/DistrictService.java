package com.java.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.entity.District;



public interface DistrictService {

//	获取地区列表
	public List<District> getDistricts(Map<String, Object> params);
	
}
