package com.baseframework.service;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Agingpopulation;

public interface AgingpopulationService extends BaseDao<Agingpopulation> {
	/**
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param Name
	 * @return
	 */
	String getListAging(int page, int limit, String Name);
	
	/**
	 * 
	 * 
	 * @param model
	 * @return
	 */
	String Edit(Agingpopulation model);
}
