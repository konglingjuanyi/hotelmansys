package com.shxt.service;

import java.util.List;

import com.shxt.model.Menus;
import com.shxt.model.MenusQuery;

public interface IMenuService {
	
	public List<Menus> listParentMenu(int accountId);
	
	public List<Menus> listMenusById(int accountId);
	
	
	public List<Menus> listSelectedMenus(int role_id);
	
	public List<Menus> listUnSelectedMenus(int role_id);

	public List<Menus> listAll(MenusQuery query);

}
