package com.shxt.service;

import java.util.List;

import com.shxt.dao.BaseDaoImpl;
import com.shxt.dao.IBaseDao;
import com.shxt.model.Menus;
import com.shxt.model.MenusQuery;
import com.shxt.model.User;

public class MenuServiceImpl implements IMenuService{

	private IBaseDao baseDao ;
	/**
	 * 根据该用户id 查询本身的子菜单
	 */
	public List<Menus> listMenusById(int accountId) {
		
		String hql  = "select distinct m from User as u ,Role as r,Menus as m where u.accountId=?  and r in elements(u.roleSet) and m in elements(r.menusSet) order by m.menu_id";
		
		return (List<Menus>) baseDao.list(hql, accountId);
	}
	/**
	 * 根据id 查询本身的父菜单
	 */
	public List<Menus> listParentMenu(int accountId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select t.* from web_sys_menus t ");
		sb.append(" where t.menu_id in ( ");
		sb.append(" select distinct sm.parent_id  from web_sys_menus sm ");
		sb.append(" where sm.menu_id in ( ");
		sb.append(" select distinct rm.menu_id  from link_role_menu rm ");
		sb.append(" where rm.role_id in ( ");
		sb.append(" select ar.role_id  from link_user_role ar where ar.user_id =");
		sb.append(accountId);
		sb.append(" ))) ");
		sb.append(" order by t.menu_id ");
		
		List<Menus> parentList = (List<Menus>) baseDao.listBySql(sb.toString(), Menus.class, true);
	
		return parentList;
	}
	/**
	 * 根据相应角色 查询已经分配的菜单(此时不包括父菜单)
	 */
	public List<Menus> listSelectedMenus(int roleId) {
		
		String hql = "select m from Role as r ,Menus as m where r.role_id=? and m in elements(r.menusSet) and m.parent_id is not null ";
		
		return (List<Menus>) baseDao.list(hql, roleId);
	}
	/**
	 * 根据相应角色 查询没有被分配的角色(此时不包括父菜单)
	 */
	public List<Menus> listUnSelectedMenus(int roleId) {
		
		String hql = "select m from Role as r ,Menus as m where r.role_id=? and m   not in elements(r.menusSet) and m.parent_id is not null";
		
		return (List<Menus>) baseDao.list(hql, roleId);
	}

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	public List<Menus> listAll(MenusQuery query) {
		String hql = "from Menus as m where 1=1 ";
		if(query!=null){
			if(query.getMenuName()!=null&&query.getMenuName().trim().length()>0){
				hql +=" and m.menu_name like '%"+query.getMenuName().trim()+"%'";
			}
		}
		
		return (List<Menus>) baseDao.list(hql);
	}
	

}
