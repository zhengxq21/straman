package com.java.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.DistrictDao;
import com.java.entity.District;
import com.java.service.DistrictService;

@Service("districtService")
public class DistrictServiceImpl implements DistrictService{

	@Resource
	private DistrictDao districtDao;
	
	public List<District> getDistricts(Map<String, Object> params) {
		return districtDao.getDistricts(params);
	}

}
