package com.shxt.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.model.Menus;
import com.shxt.model.MenusQuery;
import com.shxt.model.User;
import com.shxt.service.IMenuService;

public class MenuAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	public static Menus menu;
	private IMenuService menuService ;
	private List<Menus> menuList;
	/** 用于保存查询提交 */
	public MenusQuery query;
	
	public String showNav() {
		
		User user = (User) this.session.get("session_user");
		
		//如果是这种保存传值，前台需要使用#获取
		ActionContext.getContext().put("parentMenuList", menuService.listParentMenu(user.getAccountId()));
		System.out.println( menuService.listMenusById(user.getAccountId()));
		ActionContext.getContext().put("nodeMenuList",menuService.listMenusById(user.getAccountId()));
		
		this.toFolder="main";
		this.toJsp="menu";
		
		return SUCCESS;
	}
	/**
	 * 不分页菜单查询
	 * 
	 * @return
	 */
	public String list() {
		menuList = menuService.listAll(query);
		
		this.toFolder = "menu";
		this.toJsp = "list";
		return SUCCESS;
	}
	
	public Menus getMenu() {
		return menu;
	}

	public void setMenu(Menus menu) {
		this.menu = menu;
	}


	public IMenuService getMenuService() {
		return menuService;
	}


	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
	public List<Menus> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menus> menuList) {
		this.menuList = menuList;
	}
	public MenusQuery getQuery() {
		return query;
	}
	public void setQuery(MenusQuery query) {
		this.query = query;
	}
	
}
