package com.baseframework.comm;

import java.util.List;

/***
 * layui table数据格式
 * @author 王鸿钦  
 * @version 1.0.0.0
 */
public class LayuiFormat<T> {

	/**
	 * 返回码
	 */
	private int code;
	/**
	 * 返回信息
	 */
	private String msg;
	
	/**
	 * 返回条数
	 */
	private int count;
	
	/**
	 * 返回数据
	 */
	private List<T> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
