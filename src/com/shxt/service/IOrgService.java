package com.shxt.service;

import java.util.List;

import com.shxt.model.Org;
import com.shxt.model.OrgQuery;


public interface IOrgService {
	/**
	 * 部门 无分页查询
	 * @param query
	 * @return
	 */
	public List<Org> listAll(OrgQuery query);
	/**
	 * 添加时 判断部门是否存在
	 * @param org
	 * @return
	 */
	public List<Org> getOrgByReg(Org org);
	/**
	 * 添加部门
	 * @param org
	 */
	public Org addOrg(Org org);
	/**
	 * 根据id查询部门
	 * @param orgId
	 * @return
	 */
	public Org queryById(int orgId);
	/**
	 * 修改时  查询部门名称是否重复
	 * @param org
	 * @return
	 */
	public List<Org> getOrgByMod(int orgId, String name);
	/**
	 * 更新部门
	 * @param org
	 */
	public void update(Org org);

}
