package com.shxt.dao;


import java.util.List;
import java.util.Map;

import com.shxt.utils.PageBean;
import com.wx.model.Chart;



/**
 * 公共的DAO处理对象，这个对象中包含了Hibernate的所有基本操作和对SQL的操作
 * 
 * @author 王雪
 * @see query开头是返回一个对象 | list开头是返回列表对象  | find 开头是放回分页对象 
 */
public interface IBaseDao {
	/**
	 * 添加对象
	 * 
	 * @param t
	 * @return 保存对象
	 */
	public Object add(Object object);

	/**
	 * 更新对象
	 * 
	 * @param t
	 */
	public void update(Object object);

	/**
	 * 根据id删除对象
	 * 
	 * @param id
	 */
	public void delete(Class<?> clz,int id);

	/**
	 * 根据id加载对象
	 * 
	 * @param id
	 * @return
	 */
	public Object load(Class<?> clz,int id);

	/**
	 * 通过一组查询参数完成查询
	 * 
	 * @param hql
	 *            查询对象的HQL语句
	 * @param args
	 *            
	 * @return 一组不分页的列表对象
	 */
	public List<?> list(String hql, Object[] args);
	/**
	 * 通过一个查询参数完成查询
	 * @param hql
	 * @param arg
	 * @return 一组不分页的列表对象
	 */
	public List<?> list(String hql, Object arg);
	/**
	 * 没有查询参数
	 * @param hql 查询对象的HQL语句
	 * @return 一组不分页的列表对象
	 */
	public List<?> list(String hql);
	/**
	 * 通过别名查询列表
	 * @param hql
	 * @param alias
	 * @return 一组不分页的列表对象
	 */
	public List<?> listByAlias(String hql, Map<String, Object> alias);

	/**
	 * 基于别名和参数的混合列表
	 * 
	 * @param hql
	 * @param args
	 * @param alias
	 * @return 一组不分页的列表对象
	 */
	public List<?> listByAlias(String hql, Object[] args, Map<String, Object> alias);

	/**
	 * HQL分页列表对象:通过一组查询条件
	 * 
	 * @param hql
	 *            查询对象的HQL语句
	 * @param args
	 *            查询参数
	 * @return 一组不分页的列表对象
	 */
	public PageBean find(String hql, Object[] args,PageBean pageBean);
	/**
	 * HQL分页列表对象:一个查询条件
	 * @param hql
	 * @param arg
	 * @param pageBean
	 * @return pageBean
	 */
	public PageBean find(String hql, Object arg,PageBean pageBean);
	/**
	 * HQL分页列表对象:没有查询条件
	 * @param hql
	 * @param pageBean
	 * @return pageBean
	 */
	public PageBean find(String hql,PageBean pageBean);
	/**
	 * HQL分页列表对象:通过别名查询
	 * @param hql
	 * @param alias
	 * @param pageBean
	 * @return pageBean
	 */
	public PageBean findByAlias(String hql, Map<String, Object> alias,PageBean pageBean);

	/**
	 * HQL分页列表对象:基于别名和参数的混合列表
	 * 
	 * @param hql
	 * @param args
	 * @param alias
	 * @return pageBean
	 */
	public PageBean find(String hql, Object[] args, Map<String, Object> alias,PageBean pageBean);

	/**
	 * 根据HQL查询一个对象:通过一组查询条件
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryObject(String hql, Object[] args);
	/**
	 * 根据HQL查询一个对象:通过一个查询条件
	 * @param hql
	 * @param arg
	 * @return
	 */
	public Object queryObject(String hql, Object arg);
	/**
	 * 根据HQL查询一个对象:不通过传递参数
	 * @param hql
	 * @return
	 */
	public Object queryObject(String hql);
	/**
	 * 根据HQL查询一个对象:基于别名和参数的混合列表
	 * @param hql
	 * @param args
	 * @param alias
	 * @return
	 */
	public Object queryObject (String hql,Object[] args ,Map<String, Object> alias);
	/**
	 * 根据HQL查询一个对象:基于别名
	 * @param hql
	 * @param alias
	 * @return
	 */
	public Object queryObjectByAlias(String hql,Map<String, Object> alias);

	/**
	 * 根据HQL更新对象：一组更新
	 * 
	 * @param hql
	 * @param args
	 */
	public void updateByHql(String hql, Object[] args);
	/**
	 * 根据HQL更新对象：跟新一个属性
	 * @param hql
	 * @param args
	 */
	public void updateByHql(String hql, Object args);
	/**
	 *  根据HQL更新对象：不传递参数更新
	 * @param hql
	 */
	public void updateByHql(String hql);

	/**
	 * 根据SLQ查询对象，不关联对象 ： 传递多个参数
	 * 
	 * @param sql
	 *            查询的SQL语句
	 * @param args
	 *            查询条件
	 * @param clz
	 *            查询的实体对象
	 * @param hasEntity
	 *            该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象
	 */
	public List<?> listBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity);
	/**
	 * 根据SLQ查询对象，不关联对象 ： 传递一个参数
	 * @param sql 查询的SQL语句
	 * @param arg 查询条件
	 * @param clz 查询的实体对象
	 * @param hasEntity 该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象列表
	 */
	public List<?> listBySql(String sql, Object arg, Class<?> clz, boolean hasEntity);
	/**
	 * 根据SLQ查询对象，不关联对象 ： 不通过传递参数获取
	 * @param sql 查询的SQL语句
	 * @param clz 查询的实体对象
	 * @param hasEntity 该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象列表
	 */
	public List<?> listBySql(String sql, Class<?> clz, boolean hasEntity);
	/**
	 * 根据SLQ查询对象，不关联对象 ：基于别名和参数的形式
	 * @param sql 查询的SQL语句
	 * @param args 查询条件
	 * @param alias 查询条件
	 * @param clz 查询的实体对象
	 * @param hasEntity 该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象列表
	 */
	public List<?> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz,
	        boolean hasEntity);
	/**
	 * 根据SLQ查询对象，不关联对象 ：基于别名
	 * @param sql 查询的SQL语句
	 * @param alias 查询条件
	 * @param clz 查询的实体对象
	 * @param hasEntity 该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象列表
	 */
	public List<?> listByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity);

	/**
	 * 根据SLQ查询对象，不关联对象
	 * 
	 * @param sql
	 *            查询的SQL语句
	 * @param args
	 *            查询条件
	 * @param clz
	 *            查询的实体对象
	 * @param hasEntity
	 *            该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象
	 */
	public PageBean findBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity,PageBean pageBean);
	/**
	 * 根据SLQ查询对象，不关联对象：一个查询条件
	 * 
	 * @param sql
	 *            查询的SQL语句
	 * @param arg
	 *            查询条件
	 * @param clz
	 *            查询的实体对象
	 * @param hasEntity
	 *            该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象
	 */
	public PageBean findBySql(String sql, Object arg, Class<?> clz, boolean hasEntity,PageBean pageBean);
	/**
	 * 根据SLQ查询对象，不关联对象：不使用预处理方式
	 * 
	 * @param sql
	 *            查询的SQL语句
	 * @param clz
	 *            查询的实体对象
	 * @param hasEntity
	 *            该对象是否是一个Hibernate管理的对象，如果不是，需要使用setResultTransForm查询
	 * @return 返回一组对象
	 */
	public PageBean findBySql(String sql, Class<?> clz, boolean hasEntity,PageBean pageBean);
	/**
	 * 根据SLQ查询对象，不关联对象：基于别名和参数的形式
	 * @param sql
	 * @param args
	 * @param alias
	 * @param clz
	 * @param hasEntity
	 * @param pageBean
	 * @return
	 */
	public PageBean findBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz,
	        boolean hasEntity,PageBean pageBean);
	/**
	 * 根据SLQ查询对象，不关联对象：基于别名
	 * @param sql
	 * @param alias
	 * @param clz
	 * @param hasEntity
	 * @param pageBean
	 * @return
	 */
	public PageBean findByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity,PageBean pageBean);
	
	/***
	 * 统计SQL语句使用
	 */
	public List<Chart> listBySQLChart(String sql,Object[] args);

	public void updateSql(String sql);
}
