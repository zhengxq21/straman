package com.java.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.java.entity.District;
import com.java.entity.FilmType;
import com.java.service.DistrictService;
import com.java.service.FilmTypeService;



@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{

//	获取上下文
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void contextDestroyed(ServletContextEvent arg0) {}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		FilmTypeService filmTypeService =  (FilmTypeService)applicationContext.getBean("filmTypeService");
		DistrictService districtService = (DistrictService)applicationContext.getBean("districtService");
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<FilmType> filmTypeList = filmTypeService.getFilmType(params);
		List<District> districtList = districtService.getDistricts(params);
		
		
		application.setAttribute("filmTypeList", filmTypeList);
		application.setAttribute("districtList", districtList);
	}

	
	
	

		
}
