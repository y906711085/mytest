package com.baseframework.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.baseframework.comm.FlowFormat;
import com.baseframework.comm.LayuiFormat;

/**
 * 数据操作基类
 * 
 * @author 王鸿钦
 *
 * @param <T>
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImp<T extends BaseEntity> implements BaseDao<T> {

	@PersistenceContext
	private EntityManager entityManager;
	protected Class<T> entityClass;

	protected Class<T> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return entityClass;
	}

	@Override
	public void insert(T model) {
		// TODO Auto-generated method stub
		entityManager.persist(model);
	}

	@Override
	public void update(T model) {
		// TODO Auto-generated method stub
		entityManager.merge(model);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		T model = findById(id);
		if (model != null) {
			delete(model);
		}
		return true;
	}

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(getEntityClass(), id);
	}

	@Override
	public boolean delete(T model) {
		// TODO Auto-generated method stub
		entityManager.remove(model);
		return true;
	}

	@Override
	public T getByHQL(String hql, Object... values) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		List<?> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return (T) list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<T> getListByHQL(String hql, Object... values) {
		// TODO Auto-generated method stub

		Query query = entityManager.createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.getResultList();
	}

	@Override
	public List<T> getlistBySql(String sql, Object... values) {
		Query query = entityManager.createNativeQuery(sql, getEntityClass());
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.getResultList();
	}

	@Override
	public LayuiFormat<T> getFormatBySQL(String sql, int page, int rows, Object... values) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(sql, getEntityClass());
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				if (values[i] != null && !values[i].toString().isEmpty()) {
					query.setParameter(i, values[i]);
				}
			}
		}

		int total = query.getResultList().size();// ?
		query.setFirstResult((page - 1) * rows);
		query.setMaxResults(rows);
		List<T> list = query.getResultList();
		LayuiFormat<T> format = new LayuiFormat<T>();
		format.setCode(0);
		format.setMsg("");
		format.setCount(total);
		format.setData(list);
		return format;
	}

	@Override
	public LayuiFormat<T> getListByCriteria(int page, int rows, String orderbyField, boolean order,
			Map<String, Object> values) {
		// TODO Auto-generated method stub
		TypedQuery<T> query = query(orderbyField, order, values);
		int total = rowCount(values);
		query.setFirstResult((page - 1) * rows);
		query.setMaxResults(rows);
		LayuiFormat<T> format = new LayuiFormat<T>();
		format.setCode(0);
		format.setMsg("");
		format.setCount(total);
		List<T> list = query.getResultList();
		format.setData(list);
		return format;
	}

	@Override
	public LayuiFormat<T> getListByCriteria(int page, int rows, Map<String, Object> values) {
		// TODO Auto-generated method stub
		return getListByCriteria(page, rows, "", false, values);
	}

	@Override
	public LayuiFormat<T> getListByCriteria(int page, int rows) {
		// TODO Auto-generated method stub
		return getListByCriteria(page, rows, "", false, null);
	}

	@Override
	public LayuiFormat<T> getListByCriteria(int page, int rows, String orderbyField, boolean order) {
		// TODO Auto-generated method stub
		return getListByCriteria(page, rows, orderbyField, order, null);
	}

	@Override
	public boolean update(int id, String field, String value) {
		// TODO Auto-generated method stub
		String sql = "update " + getEntityClass().getSimpleName() + " set " + field + "='" + value + "' where Id=" + id;
		Query query = entityManager.createNativeQuery(sql);
		return query.executeUpdate() > 0;
	}

	@Override
	public T getByCriteria(Map<String, Object> values) {
		// TODO Auto-generated method stub
		List<T> list = query("", false, values).getResultList();
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<T> getListByCriteria(Map<String, Object> values) {
		// TODO Auto-generated method stub
		return query("", false, values).getResultList();
	}

	@Override
	public int rowCount(Map<String, Object> values) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<T> root = criteria.from(getEntityClass());
		List<Predicate> predicates = buildPredicate(builder, root, values);
		Predicate[] arrayPredicates = new Predicate[predicates.size()];
		criteria.where(predicates.toArray(arrayPredicates));
		arrayPredicates = null;
		predicates.clear();
		criteria.select(builder.count(root));
		return entityManager.createQuery(criteria).getSingleResult().intValue();
	}

	/**
	 * 
	 * @param values
	 * @return
	 */
	private TypedQuery<T> query(String orderbyField, boolean order, Map<String, Object> values) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(getEntityClass());
		Root<T> root = criteria.from(getEntityClass());
		List<Predicate> predicates = buildPredicate(builder, root, values);
		if (!orderbyField.isEmpty()) {// 排序
			if (order) {
				criteria.orderBy(builder.desc(root.get(orderbyField)));
			} else {
				criteria.orderBy(builder.asc(root.get(orderbyField)));
			}
		}
		Predicate[] arrayPredicates = new Predicate[predicates.size()];
		criteria.where(predicates.toArray(arrayPredicates));
		arrayPredicates = null;
		predicates.clear();
		TypedQuery<T> query = entityManager.createQuery(criteria);
		return query;
	}

	/**
	 * 组装条件
	 * 
	 * @param builder
	 * @param root
	 * @param values
	 * @return
	 */
	private List<Predicate> buildPredicate(CriteriaBuilder builder, Root<T> root, Map<String, Object> values) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (values != null && values.size() > 0) {// 条件
			for (Entry<String, Object> item : values.entrySet()) {
				if (item.getValue() != null && !item.getValue().toString().isEmpty()) {
					Class<?> fieldtype = root.get(item.getKey()).getJavaType();
					if (fieldtype.equals(String.class) || fieldtype.equals(char.class)) {
						predicates.add(builder.like(root.get(item.getKey()), "%" + item.getValue() + "%"));
					} else if (fieldtype.equals(Date.class)) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date date = null;
						try {
							date = format.parse(item.getValue().toString());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (date != null) {
							predicates.add(builder.equal(root.get(item.getKey()), new Date(date.getTime())));
						}
					} else {
						predicates.add(builder.equal(root.get(item.getKey()), item.getValue()));
					}
				}
			}
		}
		return predicates;
	}

	@Override
	public boolean contains(T model) {
		// TODO Auto-generated method stub
		return entityManager.contains(model);
	}

	@Override
	public boolean contains(String sql) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList().size() > 0;
	}

	@Override
	public boolean executeupdate(String sql) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(sql);
		return query.executeUpdate() > 0;
	}

	@Override
	public FlowFormat<T> getFormatByCriteria(int page, int rows, Map<String, Object> values) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(getEntityClass());
		Root<T> root = criteria.from(getEntityClass());
		List<Predicate> predicates = buildPredicate(builder, root, values);
		Predicate[] arrayPredicates = new Predicate[predicates.size()];
		criteria.where(predicates.toArray(arrayPredicates));
		arrayPredicates = null;
		predicates.clear();
		TypedQuery<T> query = entityManager.createQuery(criteria);
		int total = rowCount(values);
		int pages = (total + rows - 1) / rows;
		query.setFirstResult((page - 1) * rows);
		query.setMaxResults(rows);
		List<T> list = query.getResultList();
		FlowFormat<T> format = new FlowFormat<T>();
		format.setData(list);
		format.setPagination(pages);
		return format;
	}

	@Override
	public boolean setModelValue(T model) {
		// TODO Auto-generated method stub
		Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		try {
			for (int j = 0; j < field.length; j++) { // 遍历所有属性
				String name = field[j].getName(); // 获取属性的名字
				name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
				String type = field[j].getGenericType().toString(); // 获取属性的类型
				if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
					Method m = model.getClass().getMethod("get" + name);
					String value = (String) m.invoke(model); // 调用getter方法获取属性值
					if (value == null) {
						m = model.getClass().getMethod("set" + name, String.class);
						m.invoke(model, "");
					}
				}
				if (type.equals("class java.lang.Integer")) {
					Method m = model.getClass().getMethod("get" + name);
					Integer value = (Integer) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set" + name, Integer.class);
						m.invoke(model, 0);
					}
				}
				if (type.equals("class java.math.BigDecimal")) {
					Method m = model.getClass().getMethod("get" + name);
					BigDecimal value = (BigDecimal) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set" + name, BigDecimal.class);
						m.invoke(model, new BigDecimal(0.0));
					}
				}
				if (type.equals("class java.lang.Boolean")) {
					Method m = model.getClass().getMethod("get" + name);
					Boolean value = (Boolean) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set" + name, Boolean.class);
						m.invoke(model, false);
					}
				}
				if (type.equals("class java.util.Date") || type.equals("class java.sql.Timestamp")) {
					Method m = model.getClass().getMethod("get" + name);
					Date value = (Date) m.invoke(model);
					if (value == null) {
						if (type.equals("class java.sql.Timestamp")) {
							m = model.getClass().getMethod("set" + name, java.sql.Timestamp.class);
							java.sql.Timestamp timedate = new java.sql.Timestamp(new java.util.Date().getTime());
							m.invoke(model, timedate);
						} else {
							m = model.getClass().getMethod("set" + name, java.util.Date.class);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							java.util.Date time = null;
							time = sdf.parse(sdf.format(new java.util.Date()));
							m.invoke(model, time);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
