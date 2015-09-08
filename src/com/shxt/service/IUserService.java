package com.shxt.service;

import java.util.List;

import com.shxt.model.Org;
import com.shxt.model.Role;
import com.shxt.model.User;
import com.shxt.model.UserQuery;
import com.shxt.utils.PageBean;

public interface IUserService {
	public User getUserByLogin(User user)throws Exception;
	/**
	 * 使用查询提交分页
	 * @param pageBean
	 * @param query
	 * @return
	 */
	public PageBean find(PageBean pageBean,UserQuery query);
	/**
	 * 查询用户对象
	 */
	public User queryById(int account_id)throws Exception;
	/**
	 * 查询该用户没有选择的角色
	 * @param account_id
	 * @return
	 */
	public List<Role> listUnSelectedRoleList(int account_id);
	/**
	 * 更新用户角色
	 * @param selectedRoles
	 * @param account_id
	 */
	public void updateRoles(int[] selectedRoles , int account_id);
	/**
	 * 查询部门
	 */
	public List<Org> getOrgList();
	/**
	 * 查询部门
	 */
	public Org getOrg(int org_id);
	/**
	 * 添加用户
	 */
	public User addUser(User user);
	/**
	 * 添加用户判断账号是否存在
	 * @param user
	 */
	public List<User> getUserByReg(User user);
	/**
	 * 更新用户
	 */
	public void modUser(User user);
	/**
	 * 查询日志
	 * @param pageBean
	 * @return
	 */
	public PageBean find(PageBean pageBean); 
}
