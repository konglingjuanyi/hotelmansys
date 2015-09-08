package com.shxt.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.shxt.utils.PageBean;
import com.wx.model.Chart;

@SuppressWarnings("unchecked")
public class BaseDaoImpl implements IBaseDao {

	private SessionFactory sessionFactory;
	
	
	private Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Object add(Object object) {
		this.getSession().save(object);
		return object;
	}

	public Object load(Class<?> clz, int id) {
		return this.getSession().get(clz, id);
	}

	public void delete(Class<?> clz, int id) {
		this.getSession().delete(this.load(clz, id));

	}

	public void update(Object object) {
		this.getSession().update(object);
	}

	public void updateSql(String sql){
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
	public PageBean find(String hql, Object[] args, PageBean pageBean) {
		return this.find(hql, args, null, pageBean);
	}

	public PageBean find(String hql, Object arg, PageBean pageBean) {
		return this.find(hql, new Object[] { arg }, pageBean);
	}

	public PageBean find(String hql, PageBean pageBean) {
		return this.find(hql, null, pageBean);
	}

	public PageBean find(String hql, Object[] args, Map<String, Object> alias,
			PageBean pageBean) {
		Session session = this.getSession();
		// HQL编程查询数据条数
		String countHQL = this.getCountHql(hql, true);
		Query countQuery = session.createQuery(countHQL);
		this.setAliasParameters(countQuery, alias);
		this.setParameter(countQuery, args);

		Query query = session.createQuery(hql);
		this.setAliasParameters(query, alias);
		this.setParameter(query, args);

		// 获取总记录数
		Long total = (Long) countQuery.uniqueResult();
		pageBean.setTotal(total);
		// 总页数
		Long totalPages = total % pageBean.getSize() == 0 ? total
				/ pageBean.getSize() : total / pageBean.getSize() + 1;
		pageBean.setTotalPages(totalPages);

		pageBean.setDatas(query.setFirstResult(
				(pageBean.getOffset() - 1) * pageBean.getSize())
				.setMaxResults(pageBean.getSize()).list());

		return pageBean;
	}

	public PageBean findByAlias(String hql, Map<String, Object> alias,
			PageBean pageBean) {
		return this.find(hql, null, alias, pageBean);
	}

	public PageBean findByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity, PageBean pageBean) {
		return this.findBySql(sql, null, alias, clz, hasEntity, pageBean);
	}

	public PageBean findBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity, PageBean pageBean) {
		return this.findBySql(sql, args, null, clz, hasEntity, pageBean);
	}

	public PageBean findBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity, PageBean pageBean) {
		return this.findBySql(sql, new Object[] { arg }, clz, hasEntity,
				pageBean);
	}

	public PageBean findBySql(String sql, Class<?> clz, boolean hasEntity,
			PageBean pageBean) {
		return this.findBySql(sql, null, clz, hasEntity, pageBean);
	}

	public PageBean findBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity,
			PageBean pageBean) {
		 
		Session session = this.getSession();
		String countSql = getCountHql(sql, false);
		SQLQuery sql_query = session.createSQLQuery(sql);
		this.setAliasParameters(sql_query, alias);
		this.setParameter(sql_query, args);

		SQLQuery count_sql_query = session.createSQLQuery(countSql);
		this.setAliasParameters(count_sql_query, alias);
		this.setParameter(count_sql_query, args);

		if (hasEntity) {
			sql_query.addEntity(clz);
		} else {
			sql_query.setResultTransformer(Transformers.aliasToBean(clz));
		}

		// 获取总记录数
		Long total = (Long) count_sql_query.uniqueResult();
		pageBean.setTotal(total);
		// 总页数
		Long totalPages = total % pageBean.getSize() == 0 ? total
				/ pageBean.getSize() : total / pageBean.getSize() + 1;
		pageBean.setTotalPages(totalPages);

		pageBean.setDatas(sql_query.setFirstResult(
				(pageBean.getOffset() - 1) * pageBean.getSize())
				.setMaxResults(pageBean.getSize()).list());

		return pageBean;
		
	}

	public List<Object> list(String hql, Object[] args) {

		return this.listByAlias(hql, args, null);
	}

	public List<Object> list(String hql, Object arg) {
		return this.list(hql, new Object[] { arg });
	}

	public List<Object> list(String hql) {
		return this.list(hql, null);
	}

	public List<Object> listByAlias(String hql, Map<String, Object> alias) {

		return this.listByAlias(hql, null, alias);
	}

	public List<Object> listByAlias(String hql, Object[] args,
			Map<String, Object> alias) {
		
		Query query = this.getSession().createQuery(hql);
		this.setAliasParameters(query, alias);
		this.setParameter(query, args);

		return query.list();
	}

	public List<Object> listByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, alias, clz, hasEntity);
	}

	public List<Object> listBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, args, null, clz, hasEntity);
	}

	public List<Object> listBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, new Object[] { arg }, clz, hasEntity);
	}

	public List<Object> listBySql(String sql, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, null, clz, hasEntity);
	}

	public List<Object> listBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
		this.setAliasParameters(sqlQuery, alias);
		this.setParameter(sqlQuery, args);
		if (hasEntity) {
			sqlQuery.addEntity(clz);
		} else {
			sqlQuery.setResultTransformer(Transformers.aliasToBean(clz));
		}

		return sqlQuery.list();
	}

	public Object queryObject(String hql, Object[] args) {
		return this.queryObject(hql, args, null);
	}

	public Object queryObject(String hql, Object arg) {
		return this.queryObject(hql, new Object[] { arg });
	}

	public Object queryObject(String hql) {
		return this.queryObject(hql, null);
	}

	public Object queryObject(String hql, Object[] args,
			Map<String, Object> alias) {
		Query query = this.getSession().createQuery(hql);
		this.setAliasParameters(query, alias);
		this.setParameter(query, args);
		return query.uniqueResult();
	}

	public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
		return this.queryObject(hql, null, alias);
	}

	public void updateByHql(String hql, Object[] args) {
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		this.setParameter(query, args);
		query.executeUpdate();

	}

	public void updateByHql(String hql, Object arg) {
		this.updateByHql(hql, new Object[] { arg });

	}

	public void updateByHql(String hql) {
		this.updateByHql(hql, null);

	}

	private void setAliasParameters(Query query, Map<String, Object> alias) {
		if (alias != null) {
			// 先设置别名
			Set<String> keys = alias.keySet();
			for (String key : keys) {
				Object val = alias.get(key);
				if (val instanceof Collection) {
					// 查询条件是列表
					query.setParameterList(key, (Collection) val);
				} else {
					query.setParameter(key, val);
				}
			}
		}
	}

	private void setParameter(Query query, Object[] args) {
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
	}

	/**
	 * 判断是否是HQL语句，针对HQL语句和SQL语句，变成Count(*) 提供效率
	 * 
	 * @param hql
	 * @param isHql
	 * @return
	 */
	private String getCountHql(String hql, boolean isHql) {
		// 1、获取from前面的字符串
		String f = hql.substring(0, hql.indexOf("from"));
		// 2、将from前面的字符串替换为select count(*)
		if (f.equals("")) {
			hql = "select count(*) " + hql;
		} else {
			hql = hql.replace(f, "select count(*) ");
		}
		// 3、将fetch替换为""，因为抓取查询不能使用count(*)
		if (isHql) {
			hql = hql.replace("fetch", " ");
		}

		return hql;
	}
	//funsionChar
	public List<Chart> listBySQLChart(String sql, Object[] args) {
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
		this.setParameter(sqlQuery, args);
		List<Object[]> list = sqlQuery.list();
		List<Chart> chatList = new ArrayList<Chart>();
		for(Object[] objs : list){
			Chart chart = new Chart();
			chart.setXname(objs[0].toString());
			chart.setYvalue(objs[1].toString());
			chatList.add(chart);
		}
		return chatList;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
