package com.shxt.interceptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.shxt.model.LoginLogger;
import com.shxt.model.User;
import com.shxt.service.ILoggerService;
import com.shxt.service.LoggerServiceImpl;
/**
 * 
 * @author 刘文铭
 * @desc  用户的登录日志记录
 * 2013-7-15 上午11:00:46
 *
 */
public class LoginLoggerInterceptor implements Interceptor {
	
	private String sessionKey;
	
	private String resultCode;

	ILoggerService loggerService ;
	
	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		//通过ActionInvocation获取Session
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		//获取调用的方法子
		String methodName = invocation.getProxy().getMethod();
		
		
		//排除不进行Session验证Action方法
		if("login".equalsIgnoreCase(methodName)||session.containsKey(sessionKey)){
			
			String result = invocation.invoke();
			//获取Session里面保存的对象
			User user = (User) session.get(sessionKey);
			
			if(user!=null){
				//获取用户帐号
				String account = user.getAccount();
				String userName = user.getUserName();
				//登录时间
				Long loginTime = new Date().getTime();
				Timestamp time = new Timestamp(loginTime);
				//获取IP地址
				String ipAddress = ServletActionContext.getRequest().getRemoteAddr();
				
				LoginLogger log = new LoginLogger();
				log.setAccount(account);
				log.setUserName(userName);
				log.setIpAddress(ipAddress);
				log.setLoginTime(time);
				
				
				if(user.getLoginTime()==null){
					user.setLoginTime(loginTime);
				}
				if(loginTime==user.getLoginTime()){
					loggerService.addLoginLogger(log);
				}
				
				
				//看到时间格式感觉不太顺眼可以改造一下，编程字符串的最好
				
			}
			
			
			return result;
		}else{
			
			return resultCode;
		}
		
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public ILoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(ILoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	

}
