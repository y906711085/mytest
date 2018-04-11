package com.baseframework.service.Imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Agingpopulation;
import com.baseframework.service.AgingpopulationService;

@Service
public class AgingpopulationServiceImp extends BaseDaoImp<Agingpopulation> implements AgingpopulationService {

	@Override
	public String getListAging(int page, int limit, String Name) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", Name);
		return JsonHelper.objectToJson(this.getListByCriteria(page, limit, map));
	}

	@Override
	public String Edit(Agingpopulation model) {
		// TODO Auto-generated method stub
		OperationResult result = null;
		Agingpopulation region=null;
		if(model.getId()==0) {
			String hql = "from Agingpopulation where Name = ?";
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
