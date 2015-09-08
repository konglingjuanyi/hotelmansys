package com.shxt.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware ,ServletRequestAware,ServletResponseAware{
	
	private static final long serialVersionUID = 1L;

	protected Logger logger = Logger.getLogger(BaseAction.class);
	
	/**获取Session*/
	protected Map<String, Object> session;
	
	/**获取HTTPRequest*/
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	/**动态跳转到JSP页面*/
	protected String toJsp;
	/**动态的文件夹*/
	protected String toFolder;
	/**提示信息*/
	protected String message;
	/**动态跳转到Action方法*/
	protected String toMethod;
	
	/**用于标识操作*/
	protected String flag;
	
	/**为返回json格式的对象*/
	protected Object jsonResult;
	
	/**定义一个常量字符串*/
	protected final String JSON = "json";
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}

	public String getToJsp() {
		return toJsp;
	}

	public void setToJsp(String toJsp) {
		this.toJsp = toJsp;
	}

	public String getToFolder() {
		return toFolder;
	}

	public void setToFolder(String toFolder) {
		this.toFolder = toFolder;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToMethod() {
		return toMethod;
	}

	public void setToMethod(String toMethod) {
		this.toMethod = toMethod;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Object getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Object jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String getJSON() {
		return JSON;
	}
	
}
