package com.baseframework.service;


import com.baseframework.dao.BaseDao;
import com.baseframework.models.Veteransenjoy;

public interface VeteransenjoyService extends BaseDao<Veteransenjoy> {
	String getlist(int page, int limit, String name);

	String Edit(Veteransenjoy model);
}
