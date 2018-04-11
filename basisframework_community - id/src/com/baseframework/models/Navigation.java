package com.baseframework.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.baseframework.dao.BaseEntity;

@Entity
@Table(name = "navigation")
public class Navigation extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int parentId;

	private boolean issystem;

	/**
	 * 导航名称
	 */
	private String navigationName;
	/**
	 * 导航连接
	 */
	private String url;

	private boolean ismenu;

	@Column(name = "parentId", nullable = false, columnDefinition = "int default 0")
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Column(name = "navigationName", nullable = false)
	public String getNavigationName() {
		return navigationName;
	}

	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
	}

	@Column(name = "url", nullable = false, columnDefinition = "varchar(255) default ''")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "ismenu", nullable = false, columnDefinition = "bit default 0")
	public boolean isIsmenu() {
		return ismenu;
	}

	public void setIsmenu(boolean ismenu) {
		this.ismenu = ismenu;
	}

	/**
	 * 系统菜单
	 * 
	 * @return
	 */	
	@Column(name = "issystem", nullable = true, columnDefinition = "bit default 0")
	public boolean isIssystem() {
		return issystem;
	}

	public void setIssystem(boolean issystem) {
		this.issystem = issystem;
	}

}
