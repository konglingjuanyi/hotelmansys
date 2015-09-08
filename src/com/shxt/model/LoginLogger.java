package com.shxt.model;

import java.sql.Timestamp;
import java.util.Date;

/***
 * 
 * @author 刘文铭
 * @desc 记录登录日志
 * 2013-7-15 上午11:10:38
 *
 */
public class LoginLogger {
	
	private Integer id;
	private String account;
	private String userName;
	private String ipAddress;
	private Timestamp loginTime = new Timestamp(new Date().getTime());
	private Timestamp loginOutTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	
	public Timestamp getLoginOutTime() {
		return loginOutTime;
	}
	public void setLoginOutTime(Timestamp loginOutTime) {
		this.loginOutTime = loginOutTime;
	}
	@Override
	public String toString() {
		return "LoginLogger [account=" + account + ", id=" + id
				+ ", ipAddress=" + ipAddress + ", loginOutTime=" + loginOutTime
				+ ", loginTime=" + loginTime + ", userName=" + userName + "]";
	}
	

}
