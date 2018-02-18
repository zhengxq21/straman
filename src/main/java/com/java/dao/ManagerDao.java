package com.java.dao;

import org.springframework.stereotype.Repository;

import com.java.entity.Manager;

@Repository
public interface ManagerDao {
	public Manager getByUserName(String userName);
}
