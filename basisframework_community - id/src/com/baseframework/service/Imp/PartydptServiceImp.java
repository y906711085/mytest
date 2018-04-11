package com.baseframework.service.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Partydpt;
import com.baseframework.service.PartydptService;

@Service
public class PartydptServiceImp extends BaseDaoImp<Partydpt> implements PartydptService {

	@Override
	public String getList(int page, int limit, String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Name", name);
		return JsonHelper.objectToJson(this.getListByCriteria(page, limit, map));
	}

	@Override
	public String Edit(Partydpt model) {
		// TODO Auto-generated method stub
		OperationResult result = null;
		Partydpt partydpt = null;
		if (model.getId() == 0) {
			String hql = "from Partydpt where dptName = ?";
			partydpt = this.getByHQL(hql, model.getDptName());
			if (partydpt == null) {
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

	@Override
	public List<Partydpt> getList() {
		// TODO Auto-generated method stub
		String hql="from Partydpt";
		List<Partydpt> list = this.getListByHQL(hql);
		return list;
	}

}
