package com.baseframework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断此使用者是否可進此連結
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		if (this.isPassUrl(url)) {
			// 判断是否已登录
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			if (session != null) {
				Object object = session.getAttribute("user");
				String root = request.getContextPath();
				if (object == null) {
					response.sendRedirect(root + "/Users/Login?redirect=" + url);
					return false;
				}
			}
		}
		return true;
	}

	private boolean isPassUrl(String url) { 
		if (!url.contains("/Users/Login") &&!url.contains("/WeiXin") && !url.contains("/WeiXin/Init") && !url.endsWith("/Users/getCode")
				&& !url.endsWith("/Users/CheckLogin") && !url.endsWith(".JSON") && !url.endsWith(".json")
				&& !url.endsWith(".txt") && !url.endsWith(".xml") && !url.endsWith(".js") && !url.endsWith(".css")
				&& !url.endsWith(".png") && !url.endsWith(".CSS") && !url.endsWith(".CSS") && !url.endsWith(".jpg")
				&& !url.endsWith(".gif") && !url.endsWith(".JPG") && !url.endsWith(".GIF")) {
			return true;
		}
		return false;
	}
}
