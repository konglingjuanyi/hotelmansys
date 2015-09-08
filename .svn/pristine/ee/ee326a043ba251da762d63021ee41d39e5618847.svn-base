package com.wx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 王雪
 * @desc客房类型 跟客房一对多
 * 2013-7-25
 */
public class RoomType {
	/**客房主键*/
	private Integer type_id;
	/**客房名称 高雅 舒适 清新 普通*/
	private String type_name;
	
	/**状态1：正常 2：维修*/
	private String type_status = "1";
	/**客房id*/
	private Set<Room> type_roomId = new HashSet<Room>();
	//图片
	private String type_photo;
	
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer typeId) {
		type_id = typeId;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String typeName) {
		type_name = typeName;
	}
	

	public String getType_status() {
		return type_status;
	}
	public void setType_status(String typeStatus) {
		type_status = typeStatus;
	}
	public Set<Room> getType_roomId() {
		return type_roomId;
	}
	
	public String getType_photo() {
		return type_photo;
	}
	public void setType_photo(String typePhoto) {
		type_photo = typePhoto;
	}
	@Override
	public String toString() {
		return "RoomType [type_id=" + type_id + ", type_name=" + type_name
				+ ", type_status="
				+ type_status + "]";
	}
	public void setType_roomId(Set<Room> typeRoomId) {
		type_roomId = typeRoomId;
	}
	public RoomType() {
	}
	
}
