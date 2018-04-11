package com.baseframework.controllers;

import java.util.List;

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
import com.baseframework.models.Partydpt;
import com.baseframework.service.PartydptService;

@Controller
public class PartydptController {
	@Resource
	private PartydptService partydptService;

	@RequestMapping(value = "/Partydpt/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Partydpt/Index");
		return view;
	}

	@RequestMapping(value = "/Partydpt/Partydpts", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Partydpts(int page, int limit, String DptName) {
		return partydptService.getList(page, limit, DptName);
	}

	@RequestMapping(value = "/Partydpt/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Partydpt partydpt = new Partydpt();
		if (Id > 0) {
			partydpt = partydptService.findById(Id);
		} else {
			partydptService.setModelValue(partydpt);
			partydpt.setDescription("");
		}
		List<Partydpt> partydpts=partydptService.getList();
		view.addObject("partydpts",partydpts);
		view.addObject("partydpt", partydpt);
		view.setViewName("/Partydpt/Edit");
		return view;
	}

	@RequestMapping(value = "/Partydpt/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Partydpt model) {
		return partydptService.Edit(model);
	}

	@RequestMapping(value = "/Partydpt/Delete", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if (Id > 0) {
			if (partydptService.delete(Id)) {
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
