package com.baseframework.comm;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/***
 * json帮助类
 * @author 王鸿钦
 * @version 1.0.0.0
 */
public class JsonHelper {

	static Gson gson = null;
	static {
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	}

	/**
	 * 将实体对象转化为json字符串
	 * 
	 * @param 待转化的对象
	 * @return json字符串
	 */
	public static String objectToJson(Object object) {
		if (gson != null) {
			return gson.toJson(object);
		} else {
			return "";
		}
	}

	/**
	 * 将json字符串转化为实体对象
	 * 
	 * @param 待转化的json字符串
	 * @param 被转化的类型
	 * @return 实体类型
	 */
	public static <T> T jsonToObject(String json, Class<T> cls) {
		if (gson != null) {
			T t = gson.fromJson(json, cls);
			return t;
		} else {
			return null;
		}
	}

	/**
	 * 将json字符串转化为实体对象集合
	 * 
	 * @param 待转化的json字符串
	 * @param 被转化的类型
	 * @return 实体类型集合
	 */
	public static <T> List<T> josnToList(String json, Class<T> cls) {
		if (gson != null) {
			List<T> list = new ArrayList<T>();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(json).getAsJsonArray();
			for (JsonElement element : array) {
				T t = gson.fromJson(element, cls);
				list.add(t);
			}
			return list;
		} else {
			return null;
		}
	}
}
