package com.java.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.entity.FilmType;

@Repository
public interface FilmTypeDao {

//	��ȡ��Ӱ���
	public List<FilmType> getFilmType(Map<String, Object> params);
	
}
