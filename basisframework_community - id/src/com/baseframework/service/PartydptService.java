package com.baseframework.service;

import java.util.List;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Partydpt;

public interface PartydptService extends BaseDao<Partydpt> {
	/**
	 * 
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	String getList(int page, int limit, String name);
	
	String Edit(Partydpt model);
	
	List<Partydpt> getList();
}
