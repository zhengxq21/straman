package com.java.entity;

import java.util.Date;

public class Info {
	private Integer id;
	private Integer filmId;
	private Integer webSiteId;
	private String info;
	private String url;
	private Date publishDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFilmId() {
		return filmId;
	}
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	public Integer getWebSiteId() {
		return webSiteId;
	}
	public void setWebSiteId(Integer webSiteId) {
		this.webSiteId = webSiteId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
	
}
