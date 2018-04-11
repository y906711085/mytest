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
import com.baseframework.models.Region;
import com.baseframework.service.RegionService;

@Controller
public class RegionController {
	
	@Resource
	private RegionService regionService;
	@RequestMapping(value="/Region/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView(); 
		List<Region> list = regionService.getList();
		view.addObject("RegionList",list);
		view.setViewName("/Region/Index");
		return view;
	}
	@RequestMapping(value="/Region/Regions",produces = "application/json;charset=UTF-8")
	public @ResponseBody String Activesoldiers(int page, int limit, String Rname) {
		return regionService.getlistRegion(page, limit, Rname);
	}
	@RequestMapping(value = "/Region/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Region activesoldier = new Region();
		if(Id>0) {
			activesoldier = regionService.findById(Id);
		}else {
			regionService.setModelValue(activesoldier);
			activesoldier.setDescription("");
		}
		List<Region> list = regionService.getList();
		view.addObject("Regionlist",list);
		view.addObject("Region", activesoldier);
		view.setViewName("/Region/Edit");
		return view;
	}
	@RequestMapping(value = "/Region/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Region model) {
		return regionService.Edit(model);
	}
	@RequestMapping(value="/Region/Delete",produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if(Id>0) {
			if(regionService.delete(Id)) {
				result = new OperationResult(OperationResultType.Success, "删除成功");
			}else {
				result = new OperationResult(OperationResultType.Error, "删除失败");
			}
		}else {
			result = new OperationResult(OperationResultType.Error, "删除失败,数据不存在");
		}
		return JsonHelper.objectToJson(result);
	}
}
