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
import com.baseframework.models.Disabledbaseinfo;
import com.baseframework.models.Region;
import com.baseframework.service.DisabledbaseinfoService;
import com.baseframework.service.RegionService;

@Controller
public class DisabledbaseinfoController {
	@Resource
	private DisabledbaseinfoService disabledbaseinfoService;
	@Resource
	private RegionService regionService;
	@RequestMapping(value="/Disabledbaseinfo/Index")
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView(); 
		view.setViewName("/Disabledbaseinfo/Index");
		return view;
	}
	@RequestMapping(value="/Disabledbaseinfo/Disabledbaseinfos",produces = "application/json;charset=UTF-8")
	public @ResponseBody String Activesoldiers(int page, int limit, String SName) {
		return disabledbaseinfoService.getList(page, limit, SName);
	}
	@RequestMapping(value = "/Disabledbaseinfo/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Disabledbaseinfo disabledbaseinfo = new Disabledbaseinfo();
		if(Id>0) {
			disabledbaseinfo = disabledbaseinfoService.findById(Id);
		}else {
			disabledbaseinfoService.setModelValue(disabledbaseinfo);
			disabledbaseinfo.setDescription("");
		}
		List<Region> regionslist = regionService.getList();
		view.addObject("Regionlist", regionslist);
		view.addObject("disabledbaseinfo", disabledbaseinfo);
		view.setViewName("/Disabledbaseinfo/Edit");
		return view;
	}
	@RequestMapping(value = "/Disabledbaseinfo/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Disabledbaseinfo model) {
		return disabledbaseinfoService.Edit(model);
	}
	@RequestMapping(value="/Disabledbaseinfo/Delete",produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if(Id>0) {
			if(disabledbaseinfoService.delete(Id)) {
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
