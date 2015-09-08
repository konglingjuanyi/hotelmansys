package com.wx.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.model.Org;
import com.shxt.utils.UploadAction;
import com.wx.model.RoomType;
import com.wx.model.RoomTypeQuery;
import com.wx.service.IRoomTypeService;

public class RoomTypeAction extends BaseAction{
	

	private static final long serialVersionUID = 1L;
	private IRoomTypeService roomTypeService;
	private RoomType roomType;
	private RoomTypeQuery query;
	private List<RoomType> roomTypeList;
	//用于上传图片
	private File photo ;
	private String photoFileName;
	private String photoContentType;
	
	/**
	 * 不分页 查询
	 * 
	 * @return
	 */
	public String listRoomType() {
		roomTypeList = roomTypeService.listAll(query);
		
		this.toFolder = "room";
		this.toJsp = "listRoomType";

		return SUCCESS;
	}
	/*
	 * 添加类型
	 */
	public String addRoomType(){
		
		this.toFolder = "room";
		this.toJsp = "addRoomType";
		
		return SUCCESS;
	}
	/**
	 * 真正的类型添加
	 * @return
	 */
	public String toAdd(){

		UploadAction action = new UploadAction(photo, photoFileName, photoContentType);
		String result = "ERROR";
		try {
			result = action.load();
			roomType.setType_photo(action.getImgName());
			roomTypeService.addRoomType(roomType);
			
			this.toFolder = "room";
			this.toJsp = "message";
			this.flag = "add";
			this.message = "客房类型添加成功!";
			return result;

		} catch (IOException e) {
			this.message = e.getMessage();
		}
		return result;
	}
	
	/**
	 * 修改房间类型
	 * 
	 * @return
	 */
	public String modRoomType(){
		
		roomType = roomTypeService.queryById(roomType.getType_id());
		
		//在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("roomType", roomType);
		this.toFolder = "room";
		this.toJsp = "modRoomType";
		
		return SUCCESS;
	}
	/**
	 * 正真的修改
	 * @return
	 */
	public String toMod(){
		RoomType rt = roomTypeService.queryById(roomType.getType_id());
		
		String result = "";
		try {
			if(this.photoFileName==""||this.photoFileName==null){
				System.out.println("photoFileName"+photoFileName);
				rt.setType_name(roomType.getType_name());
				rt.setType_status("1");
				roomTypeService.update(rt);
			}else{
				UploadAction action = new UploadAction(photo, photoFileName, photoContentType);
				
				if(action.load().equals("success")){
					//首先删除原来照片文件
					String path = ServletActionContext.getServletContext().getRealPath("/upload");
					File file = new File(path+File.separator+rt.getType_photo());
					if(file.exists()){
						file.delete();
					}
				}
				rt.setType_name(roomType.getType_name());
				rt.setType_status("1");
				rt.setType_photo(action.getImgName());
				roomTypeService.update(rt);
			}
			this.toFolder = "room";
			this.toJsp = "message";
			this.flag = "toMod";
			this.message = "类型修改成功!";

		} catch (IOException e) {
			this.message = e.getMessage();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 删除类型
	 * @return
	 */
	public String delRoomType(){
		
		//roomType= roomTypeService.queryById(roomType.getType_id());
		//roomType.setType_status("2");
		//roomTypeService.update(roomType);
		
		try {
			roomTypeService.deleteType(roomType.getType_id());
		} catch (Exception e) {
			this.toFolder = "room";
			this.toJsp = "message";
			this.message = e.getMessage();
			this.flag = "del";
			return INPUT;
		}
		this.toFolder = "room";
		this.toJsp = "message";
		this.message = "删除成功!";
		this.flag = "del";
		return SUCCESS;
	}
	public IRoomTypeService getRoomTypeService() {
		return roomTypeService;
	}

	public void setRoomTypeService(IRoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public RoomTypeQuery getQuery() {
		return query;
	}

	public void setQuery(RoomTypeQuery query) {
		this.query = query;
	}

	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
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


}
