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
import com.baseframework.models.Veteransnotenjoy;
import com.baseframework.service.VeteransnotenjoyService;

@Controller
public class VeteransnotenjoyController {

	@Resource
	private VeteransnotenjoyService veteransnotenjoyService;

	@RequestMapping(value = "/Veteransnotenjoy/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Veteransnotenjoy/Index");
		return view;
	}

	@RequestMapping(value = "/Veteransnotenjoy/Veteransnotenjoys", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Veteransnotenjoys(int page, int limit, String Vname) {
		return veteransnotenjoyService.getlist(page, limit, Vname);
	}

	@RequestMapping(value = "/Veteransnotenjoy/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Veteransnotenjoy veteransnotenjoy = new Veteransnotenjoy();
		if (Id > 0) {
			veteransnotenjoy = veteransnotenjoyService.findById(Id);
		} else {
			veteransnotenjoyService.setModelValue(veteransnotenjoy);
			veteransnotenjoy.setDescription("");
		}
		view.addObject("Veteransnotenjoy", veteransnotenjoy);
		view.setViewName("/Veteransnotenjoy/Edit");
		return view;
	}

	@RequestMapping(value = "/Veteransnotenjoy/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Veteransnotenjoy model) {
		return veteransnotenjoyService.Edit(model);
	}

	@RequestMapping(value = "/Veteransnotenjoy/Delete", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if (Id > 0) {
			if (veteransnotenjoyService.delete(Id)) {
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
