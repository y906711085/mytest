package com.baseframework.service;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Disabledbaseinfo;

public interface DisabledbaseinfoService extends BaseDao<Disabledbaseinfo> {
	/**
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	String getList(int page,int limit,String name);
	/**
	 * 
	 * 
	 * @param model
	 * @return
	 */
	String Edit(Disabledbaseinfo model);
}
