package com.baseframework.comm;

import com.baseframework.service.NavigationService; 

/**
 * velocity 菜单工具类
 * 
 * @author wanghongqin
 *
 */
public class MenuTools {

	public String GetMenu(String root,String path) {
		NavigationService service = SpringBeanHelper.getBean(NavigationService.class);
		return service.getMenu(root,path);
	}
}
