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
import com.baseframework.models.Activesoldier;
import com.baseframework.models.Region;
import com.baseframework.service.ActivesoldierService;
import com.baseframework.service.RegionService;

@Controller
public class ActivesoldierController {
	@Resource
	private ActivesoldierService activesoldierService;
	@Resource
	private RegionService regionService;

	@RequestMapping(value = "/Activesoldier/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Activesoldier/Index");
		return view;
	}

	@RequestMapping(value = "/Activesoldier/Activesoldiers", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Activesoldiers(int page, int limit, String SName) {
		return activesoldierService.getList(page, limit, SName);
	}

	@RequestMapping(value = "/Activesoldier/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Activesoldier activesoldier = new Activesoldier();
		if (Id > 0) {
			activesoldier = activesoldierService.findById(Id);
		} else {
			activesoldierService.setModelValue(activesoldier);
		}
		List<Region> listRegion = regionService.getList();
		view.addObject("listRegion", listRegion);
		view.addObject("activesoldier", activesoldier);
		view.setViewName("/Activesoldier/Edit");
		return view;
	}

	@RequestMapping(value = "/Activesoldier/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Activesoldier model) {
		return activesoldierService.Edit(model);
	}

	@RequestMapping(value = "/Activesoldier/Delete", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if (Id > 0) {
			if (activesoldierService.delete(Id)) {
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
