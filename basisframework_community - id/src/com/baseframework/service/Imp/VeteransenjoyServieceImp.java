package com.baseframework.service.Imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Veteransenjoy;
import com.baseframework.service.VeteransenjoyService;

@Service
public class VeteransenjoyServieceImp extends BaseDaoImp<Veteransenjoy> implements VeteransenjoyService {

	@Override
	public String getlist(int page, int limit, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		return JsonHelper.objectToJson(this.getListByCriteria(page, limit, map));
	}

	@Override
	public String Edit(Veteransenjoy model) {
		// TODO Auto-generated method stub
		OperationResult result = null;
		Veteransenjoy veteransenjoy = null;
		if (model.getId() == 0) {
			String hql = "from Veteransenjoy where name = ?";
			veteransenjoy = this.getByHQL(hql, model.getName());
			if (veteransenjoy == null) {
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
