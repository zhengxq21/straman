package com.java.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.java.entity.FilmType;


@Service("filmTypeService")
public interface FilmTypeService {

	
//	��ȡ��Ӱ���
	public List<FilmType> getFilmType(Map<String, Object> params);

	
}
