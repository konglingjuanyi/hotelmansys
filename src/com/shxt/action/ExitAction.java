package com.shxt.action;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.model.User;
import com.shxt.service.IUserService;
import com.shxt.service.UserServiceImpl;

public class ExitAction extends BaseAction {
	
	private User user;
	private IUserService userService;
	public String exit(){
		this.toFolder = "main";
		this.toJsp = "login";
	
		this.toFolder = "main";
		this.toJsp = "login";
		
		try {
			user = userService.getUserByLogin(user);
			ActionContext.getContext().getSession().remove("session_user");
		} catch (Exception e) {
			this.message = e.getMessage();
			return INPUT;
		}
		
		
		
		//request.getSession().removeAttribute("session_user");
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public IUserService getUserService() {
		return userService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
}
