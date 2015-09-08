package com.shxt.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.model.Org;
import com.shxt.model.Role;
import com.shxt.model.RoleQuery;
import com.shxt.service.IMenuService;
import com.shxt.service.IRoleService;
import com.shxt.service.MenuServiceImpl;
import com.shxt.service.RoleServiceImpl;

public class RoleAction extends BaseAction {
	private Role role;
	
	private List<Role> roleList ;
	/**用于保存查询提交*/
	private RoleQuery query;
	
	private IRoleService roleService ;
	
	private IMenuService menuService ;
	
	/**选中的菜单ID集合*/
	private int[] selectedMenus;
	private int[] unselectedMenus;
	/**
	 * 无分页角色查询
	 * @return
	 */
	public String list() {
		
		roleList = roleService.listAll(query);
		
		this.toFolder = "role";
		this.toJsp = "list";
		
		return SUCCESS;
	}
	
	public String showMenusJsp(){
		ActionContext.getContext().put("selectedMenus", menuService.listSelectedMenus(role.getRole_id()));
		ActionContext.getContext().put("unselectedMenus", menuService.listUnSelectedMenus(role.getRole_id()));
		this.toFolder="role";
		this.toJsp="selectedMenus";
		return SUCCESS;
	}
	public String updateMenusByRoleId(){
		
		roleService.updateMenusByRoleId(selectedMenus, role.getRole_id());
		
		this.flag = "toMenus";
		this.message="用户分配菜单成功";
		this.toFolder="role";
		this.toJsp="message";
		
		return SUCCESS;
	}
	/*
	 * 添加角色
	 */
	public String addRole(){
		
		this.toFolder = "role";
		this.toJsp = "addRole";
		
		return SUCCESS;
	}
	/**
	 * 真正的角色添加
	 * @return
	 */
	public String toAdd(){
		
		roleService.addRole(role);
		
		this.toFolder = "role";
		this.toJsp = "message";
		this.flag = "add";
		this.message = "角色添加成功!";
		
		return SUCCESS;
	}
	/**
	 * 修改角色
	 * 
	 * @return
	 */
	public String modRole(){
		
		role = roleService.queryById(role.getRole_id());
		
		//在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("role", role);
		this.toFolder = "role";
		this.toJsp = "modRole";
		
		return SUCCESS;
	}
	/**
	 * 正真的修改角色
	 * @return
	 */
	public String toMod(){
		//System.out.println("-------------"+org.getOrg_id());
		Role r = roleService.queryById(role.getRole_id());
		r.setRole_name(role.getRole_name());
		r.setRole_desc(role.getRole_desc());
		r.setRole_status("1");
		
		roleService.update(r);
		
		this.toFolder = "role";
		this.toJsp = "message";
		this.flag = "toMod";
		this.message = "角色修改成功!";
		
		return SUCCESS;
	}
	/**
	 * 删除部门
	 * @return
	 */
	public String delRole(){
		
		role= roleService.queryById(role.getRole_id());
		role.setRole_status("2");
		roleService.update(role);
		
		this.toFolder = "role";
		this.toJsp = "message";
		this.message = "删除成功!";
		this.flag = "del";
		return SUCCESS;
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public RoleQuery getQuery() {
		return query;
	}

	public void setQuery(RoleQuery query) {
		this.query = query;
	}

	public int[] getSelectedMenus() {
		return selectedMenus;
	}

	public void setSelectedMenus(int[] selectedMenus) {
		this.selectedMenus = selectedMenus;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public int[] getUnselectedMenus() {
		return unselectedMenus;
	}

	public void setUnselectedMenus(int[] unselectedMenus) {
		this.unselectedMenus = unselectedMenus;
	}
	
}
