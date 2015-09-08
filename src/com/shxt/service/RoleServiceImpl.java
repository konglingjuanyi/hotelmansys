package com.shxt.service;

import java.util.HashSet;
import java.util.List;

import com.shxt.dao.BaseDaoImpl;
import com.shxt.dao.IBaseDao;
import com.shxt.model.Menus;
import com.shxt.model.Org;
import com.shxt.model.Role;
import com.shxt.model.RoleQuery;

public class RoleServiceImpl implements IRoleService {

	private IBaseDao baseDao ;
	
	public List<Role> listAll(RoleQuery query) {
		String hql = "from Role as r where 1=1 ";
		if(query!=null){
			if(query.getRoleName()!=null&&query.getRoleName().trim().length()>0){
				hql +=" and r.role_name like '%"+query.getRoleName().trim()+"%'";
			}
			
		}
		
		return (List<Role>) baseDao.list(hql);
	}

	public void updateMenusByRoleId(int[] selectedMenus, int roleId) {
		Role role = (Role) baseDao.load(Role.class, roleId);
		
		//清空原来的数据
		role.setMenusSet(new HashSet<Menus>());
		
		for(int menus_id:selectedMenus){
			Menus menu = (Menus) baseDao.load(Menus.class, menus_id);
			role.getMenusSet().add(menu);
		}
		baseDao.update(role);
	}

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List getRoleByReg(Role role) {
		String hql = "from Role as r where r.role_name=?";
		return baseDao.list(hql, role.getRole_name());
	}

	public Role addRole(Role role) {
		
		return (Role) baseDao.add(role);
	}

	public Role queryById(int roleId) {
		String hql = "from Role as r where r.role_id=?";
		return (Role) baseDao.queryObject(hql, roleId);
	}

	public void update(Role r) {
		baseDao.update(r);
		
	}

	public List getRoleByMod(int roleId, String roleName) {
		String hql = "from Role as r where r.role_name=? and r.role_id not in (?)";
		return baseDao.list(hql, new Object[]{roleName,roleId});
	}

}
