package com.java.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.FilmDao;
import com.java.entity.Film;
import com.java.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService{

	
	@Resource
	private FilmDao filmDao;
	
	public int addFilm(Film film) {
		return filmDao.addFilm(film);
	}

	public int updateFilm(Film film) {
		return filmDao.updateFilm(film);
	}

}
