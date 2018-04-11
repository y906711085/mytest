package com.baseframework.service.Imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Activesoldier;
import com.baseframework.service.ActivesoldierService;

@Service
public class ActivesoldierServiceImp extends BaseDaoImp<Activesoldier> implements ActivesoldierService {

	@Override
	public String getList(int page, int limit, String SName) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SName", SName);
		return JsonHelper.objectToJson(this.getListByCriteria(page, limit, map));
	}

	@Override
	public String Edit(Activesoldier model) {
		// TODO Auto-generated method stub
		OperationResult result = null;
		Activesoldier region=null;
		if(model.getId()==0) {
			String hql = "from Activesoldier where SName = ?";
			region=this.getByHQL(hql, model.getSName());
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
