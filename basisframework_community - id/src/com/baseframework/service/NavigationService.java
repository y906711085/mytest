package com.baseframework.service;

import java.util.List;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Navigation;

public interface NavigationService extends BaseDao<Navigation> {
	/**
	 * 组装页面菜单
	 * @param root
	 * @param url
	 * @return
	 */
	String getMenu(String root,String url);
	/**
	 * 根据导航名获取导航
	 * @param page 页码
	 * @param limit 每一页总条数
	 * @param navigationName 导航名
	 * @return
	 */
	String getlist(int page, int limit, String navigationName);
	
	/**
	 * 获取导航链接
	 * @return
	 */
	List<Navigation> getUrls();
	
	/**
	 * 编辑导航
	 * @param model
	 * @return
	 */
	String Edit(Navigation model);
}
