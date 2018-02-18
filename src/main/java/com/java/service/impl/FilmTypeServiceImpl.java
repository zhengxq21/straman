package com.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.FilmTypeDao;
import com.java.entity.FilmType;
import com.java.service.FilmService;
import com.java.service.FilmTypeService;

@Service("filmTypeService")
public class FilmTypeServiceImpl implements FilmTypeService{

	@Autowired
	private FilmTypeDao filmTypeDao;
	
	public List<FilmType> getFilmType(Map<String, Object> params) {
		return filmTypeDao.getFilmType(params);
	}

}
