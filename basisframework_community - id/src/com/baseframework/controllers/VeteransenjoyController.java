package com.baseframework.controllers;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.models.Veteransenjoy;
import com.baseframework.service.VeteransenjoyService;

@Controller
public class VeteransenjoyController {

	@Resource
	private VeteransenjoyService veteransenjoyService;

	@RequestMapping(value = "/Veteransenjoy/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Veteransenjoy/Index");
		return view;
	}

	@RequestMapping(value = "/Veteransenjoy/Veteransenjoys", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Activesoldiers(int page, int limit, String Vname) {
		return veteransenjoyService.getlist(page, limit, Vname);
	}

	@RequestMapping(value = "/Veteransenjoy/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Veteransenjoy veteransenjoy = new Veteransenjoy();
		if (Id > 0) {
			veteransenjoy = veteransenjoyService.findById(Id);
		} else {
			veteransenjoyService.setModelValue(veteransenjoy);
			veteransenjoy.setDescription("");
		}
		view.addObject("Veteransenjoy", veteransenjoy);
		view.setViewName("/Veteransenjoy/Edit");
		return view;
	}

	@RequestMapping(value = "/Veteransenjoy/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Veteransenjoy model) {
		return veteransenjoyService.Edit(model);
	}

	@RequestMapping(value = "/Veteransenjoy/Delete", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if (Id > 0) {
			if (veteransenjoyService.delete(Id)) {
				result = new OperationResult(OperationResultType.Success, "删除成功");
			} else {
				result = new OperationResult(OperationResultType.Error, "删除失败");
			}
		} else {
			result = new OperationResult(OperationResultType.Error, "删除失败,数据不存在");
		}
		return JsonHelper.objectToJson(result);
	}
}
