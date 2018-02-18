package com.java.dao;

import org.springframework.stereotype.Repository;

import com.java.entity.Film;

@Repository
public interface FilmDao {

//	添加电影
	public int addFilm(Film film);
	
	
//	更新电影
	public int updateFilm(Film film);
}
