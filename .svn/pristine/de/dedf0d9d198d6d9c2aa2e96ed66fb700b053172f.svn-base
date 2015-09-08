package com.shxt.interceptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
public class ExitLoggerInterceptor implements Interceptor {
	
	private ILoggerService loggerService;
	
	private String sessionKey;
	
	private String resultCode;

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
		if("exit".equalsIgnoreCase(methodName)||session.containsKey(sessionKey)){
			
			String result = invocation.invoke();
			//获取Session里面保存的对象
			User user = (User) session.get(sessionKey);
			
			if(user!=null){
				//获取用户帐号
				String account = user.getAccount();
				
				List list = loggerService.getLoginLogger(account);
				
				for(Iterator<LoginLogger> iter = list.iterator();iter.hasNext();){
					LoginLogger log = iter.next();
					
					loggerService.exitLoginLogger(log);
				}
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
