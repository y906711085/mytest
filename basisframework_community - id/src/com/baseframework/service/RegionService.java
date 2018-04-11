package com.baseframework.service;

import java.util.List;

import com.baseframework.dao.BaseDao;
import com.baseframework.models.Region;

public interface RegionService extends BaseDao<Region>{
	String getlistRegion(int page, int limit, String name);
	
	List<Region> getList();
	
	String Edit(Region model);
}
