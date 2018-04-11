package com.baseframework.service.Imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Partymember;
import com.baseframework.service.PartymemberService;

@Service
public class PartymemberServiceImp extends BaseDaoImp<Partymember> implements PartymemberService {

	@Override
	public String getList(int page, int limit, String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		return JsonHelper.objectToJson(this.getListByCriteria(page, limit, map));
	}

	@Override
	public String Edit(Partymember model) {
		// TODO Auto-generated method stub
		OperationResult result = null;
		Partymember partymember = null;
		if (model.getId() == 0) {
			String hql = "from Partymember where Name = ?";
			partymember = this.getByHQL(hql, model.getName());
			if (partymember == null) {
				this.insert(model);
				result = new OperationResult(OperationResultType.Success, "添加成功");
			} else {
				result = new OperationResult(OperationResultType.Error, "存在相同的请直接修改!");
			}
		} else {
			this.update(model);
			result = new OperationResult(OperationResultType.Success, "修改成功");
		}
		return JsonHelper.objectToJson(result);
	}

}
