package com.shxt.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class User {
	/**私有的属性，公有的方法**/
	
	/**主键ID*/
	private int accountId;
	/**账号*/
	private String account;
	/**用户姓名*/
	private String userName;
	/**用户密码*/
	private String password;
	/**联系电话*/
	private String telphone;
	/**用户性别： 0:未知 1:男 2:女*/
	private String sex = "1";
	/**职务名称*/
	private String position;
	/**创建日期*/
	private Date createTime = new Date();
	/**身份证*/
	private String identity;
	/**访问的页面*/
	private String homePage;
	/**电子邮件*/
	private String email;
	/**删除标识 0:可删 1:不可以*/
	private String isDel = "0";
	/**用户状态: 1:可用 2:禁用*/
	private String accountStatus = "1";
	/**用户头像*/
	private String photo;
	
	private Org org;
	
	private Set<Role> roleSet = new HashSet<Role>();
	//用于登录日志    刷新页面不重复记录日志
	private Long loginTime;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	

	public Long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", accountId=" + accountId
				+ ", accountStatus=" + accountStatus + ", createCount="
				+ identity + ", createTime=" + createTime + ", email="
				+ email + ", homePage=" + homePage + ", isDel=" + isDel
				+ ", password=" + password + ", photo=" + photo + ", position="
				+ position + ", sex=" + sex + ", telphone=" + telphone
				+ ", userName=" + userName + "]";
	}
	
	
	
	
	
	
}
