package com.baseframework.service.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Region;
import com.baseframework.service.RegionService;

@Service
public class RegionServiceImp extends BaseDaoImp<Region> implements RegionService{

	@Override
	public String getlistRegion(int page, int limit, String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Name", name);
		return JsonHelper.objectToJson(this.getListByCriteria(page, limit, map));
	}

	@Override
	public List<Region> getList() {
		// TODO Auto-generated method stub
		String sql = "select * from region";
		List<Region> list = this.getlistBySql(sql);
		return list;
	}

	@Override
	public String Edit(Region model) {
		// TODO Auto-generated method stub
		OperationResult result = null;
		Region region=null;
		if(model.getId()==0) {
			String hql = "from Region where name = ?";
			region=this.getByHQL(hql, model.getName());
			if(region==null) {
				this.insert(model);
				result = new OperationResult(OperationResultType.Success,"添加成功");
			}else {
				result = new OperationResult(OperationResultType.Error, "存在相同的请直接修改!");
			}	
		}else {
			this.update(model);
			result = new OperationResult(OperationResultType.Success,"修改成功");
		}
		return JsonHelper.objectToJson(result);
	}
	
}
