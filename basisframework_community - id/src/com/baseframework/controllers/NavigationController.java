package com.baseframework.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.models.Navigation;
import com.baseframework.service.NavigationService;

/**
 * 导航
 * 
 * @author wanghongqin
 *
 */
@Controller
public class NavigationController {

	@Resource
	private NavigationService navigationService;

	@RequestMapping(value = "/Navigation/Index")
	public ModelAndView Index() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/Navigation/Index");
		return view;
	}

	@RequestMapping(value = "/Navigation/Edit/{Id}")
	public ModelAndView Edit(@PathVariable(name = "Id") int Id) {
		ModelAndView view = new ModelAndView();
		Navigation navigation = new Navigation();
		if (Id > 0) {
			navigation = navigationService.findById(Id);
		} else {
			navigation.setDescription("");
			navigation.setIsmenu(false);
			navigation.setNavigationName("");
			navigation.setUrl("");
			navigation.setParentId(0);
			navigation.setIssystem(false);
		}
		List<Navigation> navigations = navigationService.getlistBySql("select * from navigation where url =''");
		view.addObject("navigation", navigation);
		view.addObject("navigations", navigations);
		view.setViewName("/Navigation/Edit");
		return view;
	}

	@RequestMapping(value = "/Navigation/Edit", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Edit(Navigation model) {
		return navigationService.Edit(model);
	}

	@RequestMapping(value = "/Navigation/Delete", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Delete(int Id) {
		OperationResult result = null;
		if (navigationService.delete(Id)) {
			result = new OperationResult(OperationResultType.Success, "删除成功");
		} else {
			result = new OperationResult(OperationResultType.Error, "删除失败");
		}
		return JsonHelper.objectToJson(result);
	}

	@RequestMapping(value = "/Navigation/Navigations", produces = "application/json;charset=UTF-8")
	public @ResponseBody String Navigations(int page, int limit, String navigationName) {
		return navigationService.getlist(page, limit, navigationName);
	}
}
