package com.wx.model;

import java.util.Date;
import java.util.Set;

/**
 * @author 王雪
 * @desc客房信息表  跟入住roomstay 多对多     跟客房类型#多对一
 * 2013-7-25
 */
public class Room {
	/**入住客房主键*/
	private Integer room_id;
	/**客房名称*/
	private String room_name;
	/**客房地址*/
	private String room_site;
	/**客房类型*/
	private RoomType room_typeId;
	/**客房容量*/
	private String room_capacity;
	/**客房价格*/
	private float room_price=0.0f;
	/**是否特价 2是 1否*/
	private String room_bargain = "1";
	/**特价价格*/
	private float room_barprice=0.0f;
	/**2禁用1空闲*/
	private String room_status="1";
	
	/**特价起始日期*/
	private Date bar_startDate ;
	/**特价截止日期*/
	private Date bar_endDate;
	
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer roomId) {
		room_id = roomId;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String roomName) {
		room_name = roomName;
	}
	
	public RoomType getRoom_typeId() {
		return room_typeId;
	}
	public void setRoom_typeId(RoomType roomTypeId) {
		room_typeId = roomTypeId;
	}
	
	public float getRoom_price() {
		return room_price;
	}
	public void setRoom_price(float roomPrice) {
		room_price = roomPrice;
	}
	
	public float getRoom_barprice() {
		return room_barprice;
	}
	public void setRoom_barprice(float roomBarprice) {
		room_barprice = roomBarprice;
	}
	

	public String getRoom_site() {
		return room_site;
	}
	public void setRoom_site(String roomSite) {
		room_site = roomSite;
	}
	public String getRoom_capacity() {
		return room_capacity;
	}
	public void setRoom_capacity(String roomCapacity) {
		room_capacity = roomCapacity;
	}
	public String getRoom_bargain() {
		return room_bargain;
	}
	public void setRoom_bargain(String roomBargain) {
		room_bargain = roomBargain;
	}
	public String getRoom_status() {
		return room_status;
	}
	public void setRoom_status(String roomStatus) {
		room_status = roomStatus;
	}
	
	public Date getBar_startDate() {
		return bar_startDate;
	}
	public void setBar_startDate(Date barStartDate) {
		bar_startDate = barStartDate;
	}
	public Date getBar_endDate() {
		return bar_endDate;
	}
	public void setBar_endDate(Date barEndDate) {
		bar_endDate = barEndDate;
	}
	public Room() {
	}
}
