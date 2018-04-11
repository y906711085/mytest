package com.baseframework.dao;

import java.util.List;
import java.util.Map;

import com.baseframework.comm.FlowFormat;
import com.baseframework.comm.LayuiFormat;

/**
 * 数据操作接口
 * @author 王鸿钦
 *
 * @param <T>
 */
public interface BaseDao<T extends BaseEntity> {
	
	
	
	/**
	 * 添加数据
	 * 
	 * @param model
	 */
	void insert(T model);

	/**
	 * 更新数据
	 * 
	 * @param model
	 */
	void update(T model);

	/**
	 * 根据字段修改数据
	 * 
	 * @param id
	 * @param field
	 * @param value
	 * @return
	 */
	boolean update(int id, String field, String value);
	
	/**
	 * 根据Id删除数据
	 * 
	 * @param id
	 */
	boolean delete(int id);

	/**
	 * 删除数据
	 * 
	 * @param id
	 */
	boolean delete(T model);
	
	/**
	 * 执行sql
	 * @param sql 语句
	 * @return
	 */
	boolean executeupdate(String sql);

	/**
	 * 根据Id查询数据
	 * 
	 * @param id
	 * @return
	 */
	T findById(int id);

	/**
	 * 根据条件查询数据
	 * 
	 * @param hql
	 * @param objects
	 * @return
	 */
	T getByHQL(String hql, Object... values);

	/**
	 * 根据条件查询数据
	 * 
	 * @param hql
	 * @param objects
	 * @return
	 */
	T getByCriteria(Map<String, Object> values);

	/**
	 * 获取数据
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	List<T> getListByHQL(String hql, Object... values);

	/**
	 * 
	 * @param values
	 * @return
	 */
	List<T> getListByCriteria(Map<String, Object> values);

	/**
	 * 获取layui table数据
	 * 
	 * @param sql
	 *            sql语句需要包含条件
	 * @param page
	 *            页码
	 * @param row
	 *            每一页总条数
	 * @param values
	 *            参数(可选)
	 * @return
	 */
	LayuiFormat<T> getFormatBySQL(String sql, int page, int rows, Object... values);

	/**
	 * 获取layui table数据
	 * 
	 * @param page
	 *            页码
	 * @param row
	 *            每一页总条数
	 * @param orderbyField
	 *            排序字段
	 * @param order
	 *            排序方式 true 倒序
	 * @param values
	 *            参数
	 * @return
	 */
	LayuiFormat<T> getListByCriteria(int page, int rows, String orderbyField, boolean order,
			Map<String, Object> values);

	/**
	 * 获取layui table数据
	 * 
	 * @param page
	 *            页码
	 * @param row
	 *            每一页总条数
	 * @param values
	 *            参数
	 * @return
	 */
	LayuiFormat<T> getListByCriteria(int page, int rows, Map<String, Object> values);

	/**
	 * 获取layui table数据
	 * 
	 * @param page
	 *            页码
	 * @param row
	 *            每一页总条数
	 * @return
	 */
	LayuiFormat<T> getListByCriteria(int page, int rows);

	/**
	 * 获取layui table数据
	 * 
	 * @param page
	 *            页码
	 * @param row
	 *            每一页总条数
	 * @param orderbyField
	 *            排序字段
	 * @param order
	 *            排序方式 true 倒序
	 * @return
	 */
	LayuiFormat<T> getListByCriteria(int page, int rows, String orderbyField, boolean order);
	
	/**
	 * 是否包含
	 * @param model 实体
	 * @return
	 */
	boolean contains(T model);
	
	/**
	 * 是否包含
	 * @param sql语句
	 * @return
	 */
	boolean contains(String sql);
	
	int rowCount(Map<String, Object> values);

	List<T> getlistBySql(String sql, Object...values); 
	
	/**
	 * 获取layui table数据
	 * 
	 * @param sql
	 *            sql语句需要包含条件
	 * @param page
	 *            页码
	 * @param row
	 *            每一页总条数
	 * @param values
	 *            参数(可选)
	 * @return
	 */
	FlowFormat<T> getFormatByCriteria(int page, int rows, Map<String, Object> values);
	
	/**
	 * 模型值默认
	 * 
	 */
	boolean setModelValue(T model);
 
}
