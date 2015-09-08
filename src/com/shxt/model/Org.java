package com.shxt.model;

import java.util.Set;



public class Org {
	/**私有的属性，公有的方法**/
	
	/**主键ID*/
	private int org_id;
	/**部门名称*/
	private String org_name;
	/**部门描述*/
	private String org_desc;
	private Set<User> userSet;
	//1激活 2禁用
	private String org_status="1";
	
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int orgId) {
		org_id = orgId;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String orgName) {
		org_name = orgName;
	}
	public String getOrg_desc() {
		return org_desc;
	}
	public void setOrg_desc(String orgDesc) {
		org_desc = orgDesc;
	}
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	
	public String getOrg_status() {
		return org_status;
	}
	public void setOrg_status(String orgStatus) {
		org_status = orgStatus;
	}
	@Override
	public String toString() {
		return "Org [org_desc=" + org_desc + ", org_id=" + org_id
				+ ", org_name=" + org_name + ", userSet=" + userSet + "]";
	}

	
	
}
