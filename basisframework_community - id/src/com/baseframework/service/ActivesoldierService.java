package com.baseframework.service;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Activesoldier;

public interface ActivesoldierService extends BaseDao<Activesoldier>{
	/**
	 * 获取现役军人列表
	 * @param page
	 * @param limit
	 * @param SName 军人姓名
	 * @return
	 */
	String getList(int page, int limit, String SName);
	
	String Edit(Activesoldier model);
}
