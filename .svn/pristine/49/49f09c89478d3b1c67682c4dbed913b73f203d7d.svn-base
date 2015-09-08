package com.shxt.service;

import java.util.List;

import com.shxt.model.LoginLogger;

public interface ILoggerService {
	/**
	 * 添加登陆日志
	 * @param logger
	 */
	public void addLoginLogger(LoginLogger logger);
	/**
	 * 添加登出日志
	 * @param logger
	 */
	public void exitLoginLogger(LoginLogger logger);
	/**
	 * 根据用户账号和姓名查出日志id
	 * @param logger
	 */
	public List getLoginLogger(String account);
	
	/**
	 * 根据id查到日志对象
	 */
	public LoginLogger load(Class<LoginLogger> clz,int id);
	
}
