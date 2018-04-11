package com.baseframework.service;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Veteransnotenjoy;

public interface VeteransnotenjoyService extends BaseDao<Veteransnotenjoy> {
	String getlist(int page, int limit, String name);

	String Edit(Veteransnotenjoy model);
}
