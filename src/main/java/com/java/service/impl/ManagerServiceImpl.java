package com.java.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.ManagerDao;
import com.java.entity.Manager;
import com.java.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Resource
	private ManagerDao managerDao;
	
	
	public Manager getByUserName(String userName) {
		return managerDao.getByUserName(userName);
	}
	
}
