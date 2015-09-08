/**
 * 
 */
package com.shxt.action;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.model.User;
import com.shxt.service.IUserService;
import com.shxt.service.UserServiceImpl;
import com.shxt.utils.PageBean;

/**
 * 
 * @author 王雪
 * @desc 该Action只是做登录和注销操作
 * 2013-7-13 上午11:24:13
 *
 */
public class LoginAction extends BaseAction {
	
	private User user;
	
	private IUserService userService;
	
	//用于分页
	private PageBean pageBean;
	
	public String login(){
		try {
			user = userService.getUserByLogin(user);
			if(user!=null){
				this.session.put("session_user", user);
				//this.request.getSession().setAttribute("session_user", user);
			}
			this.toFolder = "main";
			this.toJsp = "main";
		} catch (Exception e) {
			this.message = e.getMessage();
			return INPUT;
		}
		return SUCCESS;
	}
	
	/***
	 * 查询日志
	 * @return
	 */
	public String findLogger(){
		
		//需要初始化我们的pageBean
		if(pageBean==null){
			pageBean = new PageBean();
			pageBean.setSize(10);
		}
		
		//调用分页查询方法-- 使用接口回调的形式
		pageBean = userService.find(pageBean);
		
		this.toFolder = "logger";
		this.toJsp = "findLogger";
		
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

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	

}
