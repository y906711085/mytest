package com.baseframework.comm;

import java.util.List;

/**
 * layui流式加载数据格式
 * 
 * @author wanghongqin
 *
 */
public class FlowFormat<T> {

	private List<T> data;// 数据服
	private long Pagination;// 总页数

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getPagination() {
		return Pagination;
	}

	public void setPagination(long pagination) {
		Pagination = pagination;
	}

}
