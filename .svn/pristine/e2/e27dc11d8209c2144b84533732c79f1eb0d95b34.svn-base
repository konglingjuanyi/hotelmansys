package com.shxt.service;

import java.util.List;

import com.shxt.model.Role;
import com.shxt.model.RoleQuery;

public interface IRoleService {
	public List<Role> listAll(RoleQuery query);
	
	public void updateMenusByRoleId(int[] selectedMenus,int role_id);
	/**
	 * 添加角色时 判断角色名称是否重复
	 * @param role
	 * @return
	 */
	public List getRoleByReg(Role role);
	/**
	 * 添加 角色
	 * @param role
	 */
	public Role addRole(Role role);
	/**
	 * 查询角色
	 * @param roleId
	 * @return
	 */
	public Role queryById(int roleId);
	/**
	 * 修改 角色
	 * @param r
	 */
	public void update(Role r);
	/**
	 * 修改 角色判断名称是否重复
	 * @param roleId
	 * @param roleName
	 * @return
	 */
	public List getRoleByMod(int roleId, String roleName);
	
}
