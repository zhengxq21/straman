package com.java.dao;

import org.springframework.stereotype.Repository;

import com.java.entity.Film;

@Repository
public interface FilmDao {

//	��ӵ�Ӱ
	public int addFilm(Film film);
	
	
//	���µ�Ӱ
	public int updateFilm(Film film);
}
