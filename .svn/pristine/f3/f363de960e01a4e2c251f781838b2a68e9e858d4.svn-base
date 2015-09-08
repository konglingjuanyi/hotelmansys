package com.shxt.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.model.Org;
import com.shxt.model.OrgQuery;
import com.shxt.service.IOrgService;

public class OrgAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Org org;
	private IOrgService orgService;
	private List<Org> orgList;
	/** 用于保存查询提交 */
	private OrgQuery query;

	/**
	 * 不分页部门查询
	 * 
	 * @return
	 */
	public String list() {

		orgList = orgService.listAll(query);

		this.toFolder = "org";
		this.toJsp = "list";

		return SUCCESS;
	}

	/**
	 * 修改部门
	 * 
	 * @return
	 */
	public String modOrg(){
		
		org = orgService.queryById(org.getOrg_id());
		
		//在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("org", org);
		this.toFolder = "org";
		this.toJsp = "modOrg";
		
		return SUCCESS;
	}
	/**
	 * 正真的修改部门
	 * @return
	 */
	public String toMod(){
		//System.out.println("-------------"+org.getOrg_id());
		Org o = orgService.queryById(org.getOrg_id());
		
		o.setOrg_name(org.getOrg_name());
		o.setOrg_desc(org.getOrg_desc());
		o.setOrg_status("1");
		
		orgService.update(o);
		
		this.toFolder = "org";
		this.toJsp = "message";
		this.flag = "toMod";
		this.message = "部门修改成功!";
		
		return SUCCESS;
	}
	/*
	 * 添加部门
	 */
	public String addOrg(){
		
		this.toFolder = "org";
		this.toJsp = "addOrg";
		
		return SUCCESS;
	}
	/**
	 * 真正的部门添加
	 * @return
	 */
	public String toAdd(){
		
		orgService.addOrg(org);
		
		this.toFolder = "org";
		this.toJsp = "message";
		this.flag = "add";
		this.message = "部门添加成功!";
		
		return SUCCESS;
	}
	/**
	 * 删除部门
	 * @return
	 */
	public String delOrg(){
		
		org= orgService.queryById(org.getOrg_id());
		org.setOrg_status("2");
		orgService.update(org);
		
		this.toFolder = "org";
		this.toJsp = "message";
		this.message = "删除成功!";
		this.flag = "del";
		return SUCCESS;
	}
	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public IOrgService getOrgService() {
		return orgService;
	}

	public void setOrgService(IOrgService orgService) {
		this.orgService = orgService;
	}

	public List<Org> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}

	public OrgQuery getQuery() {
		return query;
	}

	public void setQuery(OrgQuery query) {
		this.query = query;
	}

}
