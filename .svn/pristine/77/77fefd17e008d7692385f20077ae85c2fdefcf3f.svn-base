package com.shxt.service;

import java.util.HashSet;
import java.util.List;

import com.shxt.dao.BaseDaoImpl;
import com.shxt.dao.IBaseDao;
import com.shxt.model.Org;
import com.shxt.model.Role;
import com.shxt.model.User;
import com.shxt.model.UserQuery;
import com.shxt.utils.PageBean;

public class UserServiceImpl implements IUserService {

	private IBaseDao baseDao ;
	public IBaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	/**
	 * 登录校验
	 */
	public User getUserByLogin(User user) throws Exception {
		String hql = "from User as u where u.account=? and u.password=? and u.accountStatus='1'";
		user = (User)baseDao.queryObject(hql, new Object[]{user.getAccount(),user.getPassword()});
		
		if(user==null){
			throw new Exception("用户名或者密码错误");
		}else{
			return user;
		}
	}
	/**
	 * 按条件 分页查询
	 */
	public PageBean find(PageBean pageBean, UserQuery query) {
		String hql = "from User as u where u.accountStatus = '1' ";
		//注意查询提交的拼接
		if(query!=null){
			if(query.getUserName()!=null&&query.getUserName().trim().length()>0){
				hql += " and u.userName like '%"+query.getUserName().trim()+"%'";
			}
		}
		hql += "order by u.accountId desc";
		return baseDao.find(hql, pageBean);
	}
	/**
	 * 查询该用户没有选择的角色
	 * @param account_id
	 * @return
	 */
	public List<Role> listUnSelectedRoleList(int accountId) {
		//查询没有选中的角色
		String hql = "select r from User as u ,Role as r where u.accountId=? and r not in elements(u.roleSet) ";
		
		return (List<Role>) baseDao.list(hql, accountId);
	}
	/**
	 * 查询用户对象
	 */
	public User queryById(int accountId) throws Exception {
		return (User) baseDao.load(User.class, accountId);
	}
	/**
	 * 更新用户角色
	 * @param selectedRoles
	 * @param account_id
	 */
	public void updateRoles(int[] selectedRoles, int accountId) {
		
		User user = (User) baseDao.load(User.class, accountId);
		
		user.setRoleSet(new HashSet<Role>());
		
		//获取角色
		for(int role_id : selectedRoles){
			Role role = (Role) baseDao.load(Role.class, role_id);
			user.getRoleSet().add(role);
		}
		
		
		baseDao.update(user);
		
	}
	/**
	 * 得到组织
	 * @return
	 */
	public List<Org> getOrgList() {
		String hql = "from Org as org where org.org_status='1'";
		return (List<Org>) baseDao.list(hql);
	}
	public Org getOrg(int org_id){
		String hql = "from Org as o where o.org_id = ?";
		return (Org) baseDao.load(Org.class, org_id);
	}
	public User addUser(User user) {
		return (User) baseDao.add(user);
	}
	/**
	 * 添加用户判断账号是否存在
	 */
	public List<User> getUserByReg(User user) {
		String hql = "from User as u where u.accountStatus='1' and u.account=?";
		return (List<User>) baseDao.list(hql, user.getAccount());
	}
	/**
	 * 更新用户
	 */
	public void modUser(User user) {
		baseDao.update(user);
	}
	public PageBean find(PageBean pageBean) {
		String hql = "from LoginLogger as l order by l.id desc";
		return baseDao.find(hql, pageBean);
	}
	
}
