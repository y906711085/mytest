package com.baseframework.service;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Partymember;

public interface PartymemberService extends BaseDao<Partymember> {

	/**
	 * 
	 * @param page
	 * @param limit
	 * @param name 
	 * @return
	 */
	String getList(int page, int limit, String name);
	
	String Edit(Partymember model);
}
