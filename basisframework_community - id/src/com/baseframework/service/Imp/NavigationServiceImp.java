package com.baseframework.service.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

import com.baseframework.comm.JsonHelper;
import com.baseframework.comm.OperationResult;
import com.baseframework.comm.OperationResultType;
import com.baseframework.dao.BaseDaoImp;
import com.baseframework.models.Navigation;
import com.baseframework.service.NavigationService;

@Service
public class NavigationServiceImp extends BaseDaoImp<Navigation> implements NavigationService {

	/**
	 * 获取导航
	 */
	@Override
	public String getMenu(String root, String url) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ismenu", true);
		List<Navigation> list = this.getListByCriteria(map);
		StringBuilder builder = new StringBuilder();
		list.stream().filter(q -> q.getParentId() == 0).forEach(q -> {
			String navurl = q.getUrl();
			if (navurl.isEmpty()) {
				// 获取该栏子菜单
				Stream<Navigation> stream = list.stream().filter(parent -> parent.getParentId() == q.getId());
				Stream<Navigation> allstream = list.stream().filter(parent -> parent.getParentId() == q.getId());
				List<String> urls = stream.collect(() -> new ArrayList<String>(), (ll, item) -> ll.add(item.getUrl()),
						(t1, t2) -> t1.addAll(t2));
				if (urls.size() > 0) {
					if (urls.stream().anyMatch(u -> u.contains(url))) {
						builder.append("<li class=\"layui-nav-item layui-nav-itemed\">");
					} else {
						builder.append("<li class=\"layui-nav-item\">");
					}
					builder.append("<a class=\"\" href=\"javascript:;\">" + q.getNavigationName() + "</a>");
					builder.append("<dl class=\"layui-nav-child\">");

					allstream.forEach(n -> {
						if (n.getUrl().contains(url)) {
							if (n.getUrl().startsWith("/")) {
								builder.append("<dd class=\"layui-this\"> <a href=\"" + root + n.getUrl() + "\">"
										+ n.getNavigationName() + "</a></dd> ");
							} else {
								builder.append("<dd class=\"layui-this\"> <a href=\"" + root + "/" + n.getUrl() + "\">"
										+ n.getNavigationName() + "</a></dd> ");
							}
						} else {
							if (n.getUrl().startsWith("/")) {
								builder.append("<dd> <a href=\"" + root + n.getUrl() + "\">" + n.getNavigationName()
										+ "</a></dd> ");
							} else {
								builder.append("<dd> <a href=\"" + root + "/" + n.getUrl() + "\">"
										+ n.getNavigationName() + "</a></dd> ");
							}
						}
					});
					allstream.close();
					builder.append("</dl>");
					builder.append("</li>");
				} else {
					builder.append("<li class=\"layui-nav-item\">" + q.getNavigationName() + "</li>");
				}
				stream.close();
			} else {
				if (!navurl.isEmpty() && navurl.contains(url)) {
					builder.append("<li class=\"layui-nav-item layui-this\">" + "							<a href=\""
							+ root + "/Home/Index\">" + q.getNavigationName() + "</a>" + "						</li>");
				} else {
					builder.append("<li class=\"layui-nav-item\">" + "							<a href=\"" + root
							+ "/Home/Index\">" + q.getNavigationName() + "</a>" + "						</li>");
				}
			}

		});
		;

		return builder.toString();
	}

	@Override
	public String getlist(int page, int limit, String navigationName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("navigationName", navigationName);
		return JsonHelper.objectToJson(this.getListByCriteria(page, limit, map));
	}

	@Override
	public List<Navigation> getUrls() {
		String sql = "from Navigation where url !=''";
		return this.getListByHQL(sql);
	}

	@Override
	public String Edit(Navigation model) {
		// TODO Auto-generated method stub
		OperationResult result = null;
		try {
			if (model.getId() == 0) {
				// 添加
				Navigation navigation = null;
				if (model.getUrl().isEmpty()) {
					String hql = "from Navigation where navigationName=?";
					navigation = this.getByHQL(hql, model.getNavigationName());
				} else {
					String hql = "from Navigation where url=? or navigationName=?";
					navigation = this.getByHQL(hql, model.getUrl(), model.getNavigationName());
				}
				if (navigation == null) {
					this.insert(model);
					result = new OperationResult(OperationResultType.Success, "添加成功");
				} else {
					result = new OperationResult(OperationResultType.Error, "已存在相同导航，不能添加");
				}

			} else {
				this.update(model);
				result = new OperationResult(OperationResultType.Success, "修改成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result = new OperationResult(OperationResultType.Error, e.getMessage());
		}
		return JsonHelper.objectToJson(result);
	}
}
