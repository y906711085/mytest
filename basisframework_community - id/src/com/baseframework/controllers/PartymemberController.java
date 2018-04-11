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
import com.baseframework.models.Partymember;
import com.baseframework.models.Region;
import com.baseframework.service.PartydptService;
import com.baseframework.service.PartymemberService;
import com.baseframework.service.RegionService;

@Controller
public class PartymemberController {
	@Resource
	private PartymemberService partymemberService;
	@Resource
	private RegionService regionService;
	@Resource
	private PartydptService partydptService;

	@RequestMapping(value = "/Partymember/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Partymember/Index");
		return view;
	}

	@RequestMapping(value = "/Partymember/Partymembers", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Partymembers(int page, int limit, String PName) {
		return partymemberService.getList(page, limit, PName);
	}

	@RequestMapping(value = "/Partymember/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Partymember partymember = new Partymember();
		if (Id > 0) {
			partymember = partymemberService.findById(Id);
		} else {
			partymemberService.setModelValue(partymember);
			partymember.setDescription("");
		}
		List<Region> listRegion = regionService.getList();
		List<Partydpt> listPartydpt = partydptService.getList();
		view.addObject("listPartydpt",listPartydpt);
		view.addObject("listRegion",listRegion);
		view.addObject("Partymember", partymember);
		view.setViewName("/Partymember/Edit");
		return view;
	}

	@RequestMapping(value = "/Partymember/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Partymember model) {
		return partymemberService.Edit(model);
	}

	@RequestMapping(value = "/Partymember/Delete", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if (Id > 0) {
			if (partymemberService.delete(Id)) {
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
