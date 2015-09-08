package com.shxt.model;

import java.util.HashSet;
import java.util.Set;

public class Menus {
	/**私有的属性，公有的方法**/
	
	/**主键ID*/
	private int menu_id;
	/**菜单名*/
	private String menu_name;
	/**菜单路径*/
	private String menu_url;
	/**父节点ID*/
	private Integer parent_id;
	/**菜单状态 1：激活 2：禁用*/
	private String menu_status = "1";
	/**图标*/
	private String menu_icon ;
	/**扩展属性*/
	private String menu_position;
	private String parent_name;
	
	private Set<Role> roleSet = new HashSet<Role>();
	
	
	
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menuId) {
		menu_id = menuId;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menuName) {
		menu_name = menuName;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menuUrl) {
		menu_url = menuUrl;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parentId) {
		parent_id = parentId;
	}
	public String getMenu_status() {
		return menu_status;
	}
	public void setMenu_status(String menuStatus) {
		menu_status = menuStatus;
	}
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menuIcon) {
		menu_icon = menuIcon;
	}
	public String getMenu_position() {
		return menu_position;
	}
	public void setMenu_position(String menuPosition) {
		menu_position = menuPosition;
	}
	
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parentName) {
		parent_name = parentName;
	}
	@Override
	public String toString() {
		return "Menus [menu_icon=" + menu_icon + ", menu_id=" + menu_id
				+ ", menu_name=" + menu_name + ", menu_position="
				+ menu_position + ", menu_status=" + menu_status
				+ ", menu_url=" + menu_url + ", parent_id=" + parent_id + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
