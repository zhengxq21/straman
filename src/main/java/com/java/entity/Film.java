package com.java.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Film {
	private Integer id;
	private String name;
	private String title;
	private String content;
	private String imageName;
	private Integer hot;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishDate;
	private Integer filmTypeId;
	private Integer districtId;
	private Date createDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Integer getFilmTypeId() {
		return filmTypeId;
	}
	public void setFilmTypeId(Integer filmTypeId) {
		this.filmTypeId = filmTypeId;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}
