package com.shxt.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.model.Org;
import com.shxt.model.Role;
import com.shxt.model.User;
import com.shxt.model.UserQuery;
import com.shxt.service.IUserService;
import com.shxt.service.UserServiceImpl;
import com.shxt.utils.PageBean;
import com.shxt.utils.UploadAction;

public class UserAction extends BaseAction {
	private User user;
	//用于分页
	private PageBean pageBean;
	//用于条件查询
	private UserQuery query;
	
	private IUserService userService;
	//分配角色时提前加载角色
	private int[] selectedRoles;
	private int[] unselectedRoles;
	//用户添加是提前加载角色
	private List<Org> orgList;
	//用于上传图片
	private File photo ;
	private String photoFileName;
	private String photoContentType;
	//添加时 部门 属性驱动
	private Integer org_id;
	
	public String find(){
		this.logger.info("进入分页查询方法");
		
		//需要初始化我们的pageBean
		if(pageBean==null){
			pageBean = new PageBean();
		}
		
		//调用分页查询方法-- 使用接口回调的形式
		pageBean = userService.find(pageBean, query);
		
		this.toFolder = "user";
		this.toJsp = "list";
		
		return SUCCESS;
	}
	/**
	 * 提前加载角色
	 * @return
	 * @throws Exception
	 */
	public String showRoleJSP() throws Exception{
		
		user = userService.queryById(user.getAccountId());
		List<Role> roleList = userService.listUnSelectedRoleList(user.getAccountId());
		
		ActionContext.getContext().put("selectedRoles", user.getRoleSet());
		ActionContext.getContext().put("unselectedRoles", roleList);
		
		this.toFolder="user";
		this.toJsp="selectRole";
		
		return SUCCESS;
	}
	/**
	 * 用户更新角色
	 * @return
	 */
	public String updateRoles(){
		
		userService.updateRoles(selectedRoles, user.getAccountId());
		
		this.flag = "toRole";
		this.message="用户分配角色成功!";
		this.toFolder="user";
		this.toJsp="message";
		return SUCCESS;
	}
	/**
	 * 用户添加页面
	 * @return
	 */
	public String addUser(){
		
		ActionContext.getContext().put("orgList", userService.getOrgList());
		
		this.toFolder = "user";
		this.toJsp = "addUser";
		
		return SUCCESS;
	}
	/**
	 * 真正的用户添加
	 * @return
	 * @throws IOException 
	 */
	public String toAdd() {
		
		UploadAction action = new UploadAction(photo, photoFileName, photoContentType);
		String result = "ERROR";
		try {
			result = action.load();
			user.setPhoto(action.getImgName());
			
			Org org = userService.getOrg(org_id);
			user.setOrg(org);
			
			userService.addUser(user);
			
			this.toFolder = "user";
			this.message = "用户添加成功";
			this.toJsp = "message";
			this.flag = "add";

		} catch (IOException e) {
			this.message = e.getMessage();
		}
		return result;
	}
	/**
	 * 用户修改
	 * @return
	 * @throws Exception 
	 */
	public String modUser() throws Exception{
		
		user = userService.queryById(user.getAccountId());
		ActionContext.getContext().put("orgList", userService.getOrgList());
		//在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("user", user);
		this.toFolder = "user";
		this.toJsp = "modUser";
		return SUCCESS;
	}
	/**
	 * 真正修改用户信息
	 * @return
	 * @throws Exception 
	 */
	public String toMod(){
		
		this.toFolder = "user";
		this.message = "用户更新成功";
		this.toJsp = "message";
		this.flag = "toMod";
		
		User u;
		try {
			u = userService.queryById(user.getAccountId());
			u.setEmail(user.getEmail());
			u.setHomePage(user.getHomePage());
			u.setIdentity(user.getIdentity());
			Org org = userService.getOrg(org_id);
			u.setOrg(org);
			u.setPassword(user.getPassword());
			u.setPosition(user.getPosition());
			u.setSex(user.getSex());
			u.setTelphone(user.getTelphone());
			u.setUserName(user.getUserName());
			//判断是否重传照片
			if(this.photoFileName==""||this.photoFileName==null){
				//System.out.println("user.getPhoto()"+user.getPhoto());
				userService.modUser(u);
			}else{
				UploadAction action = new UploadAction(photo, photoFileName, photoContentType);
				//首先删除原来照片文件
				String path = ServletActionContext.getServletContext().getRealPath("/upload");
				
				File file = new File(path+"\\"+u.getPhoto());
				if(file.exists()){
					file.delete();
				}
				//上传新照片
				action.load();
				u.setPhoto(action.getImgName());
				
				userService.modUser(u);
			
			}
		} catch (Exception e1) {
			
			this.message = e1.getMessage();
		}
			return SUCCESS;
	}
	/**
	 * 删除用户
	 * @return
	 * @throws Exception 
	 */
	public String delUser() throws Exception{
		//System.out.println(user.getAccountId());
		user = userService.queryById(user.getAccountId());
		user.setAccountStatus("2");
		userService.modUser(user);
		
		this.toFolder = "user";
		this.toJsp = "message";
		this.message = "删除成功!";
		this.flag = "del";
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public UserQuery getQuery() {
		return query;
	}

	public void setQuery(UserQuery query) {
		this.query = query;
	}

	public int[] getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(int[] selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	public int[] getUnselectedRoles() {
		return unselectedRoles;
	}

	public void setUnselectedRoles(int[] unselectedRoles) {
		this.unselectedRoles = unselectedRoles;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public List<Org> getOrgList() {
		return orgList;
	}
	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public Integer getOrg_id() {
		return org_id;
	}
	public void setOrg_id(Integer orgId) {
		org_id = orgId;
	}
	
}
