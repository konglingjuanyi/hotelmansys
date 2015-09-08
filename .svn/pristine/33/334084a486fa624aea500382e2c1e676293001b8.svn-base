package com.shxt.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.shxt.dao.IBaseDao;
import com.shxt.model.LoginLogger;

public class LoggerServiceImpl implements ILoggerService {
	
	private IBaseDao baseDao ;
	public void addLoginLogger(LoginLogger logger) {
		
		try {
			
			baseDao.add(logger);
		} catch (Exception e) {
			// 该信息控制输出
			e.printStackTrace();
		}
	}
	public void exitLoginLogger(LoginLogger logger) {
		
		try {
			LoginLogger loginLogger = (LoginLogger) baseDao.load(LoginLogger.class,logger.getId());
			//登出时间
			Timestamp timeOut = new Timestamp(new Date().getTime());
			
			loginLogger.setLoginOutTime(timeOut);
			baseDao.update(loginLogger);
		} catch (Exception e) {
			// 该信息控制输出
			e.printStackTrace();
		}
	}
	public List getLoginLogger(String account) {
		String hql = "from LoginLogger as l where l.account=? and l.loginOutTime IS NULL";
		return baseDao.list(hql, account);
		
	}
	public LoginLogger load(Class<LoginLogger> clz, int id) {
		return (LoginLogger) baseDao.load(clz, id);
	}
	public IBaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}
