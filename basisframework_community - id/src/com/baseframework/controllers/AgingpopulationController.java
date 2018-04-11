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
import com.baseframework.models.Agingpopulation;
import com.baseframework.models.Region;
import com.baseframework.service.AgingpopulationService;
import com.baseframework.service.RegionService;

@Controller
public class AgingpopulationController {
	@Resource
	private AgingpopulationService agingpopulationService;
	@Resource
	private RegionService regionService;

	@RequestMapping(value = "/Agingpopulation/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Agingpopulation/Index");
		return view;
	}

	@RequestMapping(value = "/Agingpopulation/Agingpopulations", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Activesoldiers(int page, int limit, String AName) {
		return agingpopulationService.getListAging(page, limit, AName);
	}

	@RequestMapping(value = "/Agingpopulation/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Agingpopulation agingpopulation = new Agingpopulation();
		if (Id > 0) {
			agingpopulation = agingpopulationService.findById(Id);
			agingpopulationService.setModelValue(agingpopulation);
		} else {
			agingpopulationService.setModelValue(agingpopulation);
			agingpopulation.setDescription("");
		}
		List<Region> list = regionService.getList();
		view.addObject("Regionlist",list);
		view.addObject("agingpopulation", agingpopulation);
		view.setViewName("/Agingpopulation/Edit");
		return view;
	}

	@RequestMapping(value = "/Agingpopulation/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Agingpopulation model) {
		return agingpopulationService.Edit(model);
	}

	@RequestMapping(value = "/Agingpopulation/Delete",produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if (Id > 0) {
			if (agingpopulationService.delete(Id)) {
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
