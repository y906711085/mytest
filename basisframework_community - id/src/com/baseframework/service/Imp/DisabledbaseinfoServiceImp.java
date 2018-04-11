package com.baseframework.service.Imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Disabledbaseinfo;
import com.baseframework.service.DisabledbaseinfoService;

@Service
public class DisabledbaseinfoServiceImp extends BaseDaoImp<Disabledbaseinfo> implements DisabledbaseinfoService {

	@Override
	public String getList(int page, int limit, String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", name);
		return JsonHelper.objectToJson(this.getListByCriteria(page,limit,map));
	}

	@Override
	public String Edit(Disabledbaseinfo model) {
		// TODO Auto-generated method stub
		OperationResult result=null;
		Disabledbaseinfo disabledbaseinfo=null;
		if(model.getId()==0) {
			String hql = "from Disabledbaseinfo where name = ?";
			disabledbaseinfo = this.getByHQL(hql,model.getName());
			if(disabledbaseinfo == null) {
				this.insert(model);
				result = new OperationResult(OperationResultType.Success, "添加成功");
			}else {
				result = new OperationResult(OperationResultType.Error, "已存在相同名称,请修改");
			}
		}else {
			this.update(model);
			result = new OperationResult(OperationResultType.Success, "修改成功");
		}
		return JsonHelper.objectToJson(result);
	}
	
}
