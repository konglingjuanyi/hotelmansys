package com.wx.service;

import java.util.List;

import com.shxt.utils.PageBean;
import com.wx.model.Room;
import com.wx.model.RoomQuery;
import com.wx.model.RoomStayQuery;
import com.wx.model.RoomType;

public interface IRoomService {
	//分页查询房间 
	public PageBean find(PageBean pageBean, RoomQuery query);
	//用于提前加载类型
	public List<RoomType> getTypeList();
	//添加 判断名称是否重复
	public List getNameByReg(Room room);
	//添加
	public Room addRoom(Room room);
	//添加 判断房间号是否重复
	public List getSiteByReg(Room room);
	//添加时 获取房间类型
	public RoomType getRoomType(Integer typeId);
	//查询
	public Room queryById(Integer roomId);
	//修改 判断房间名称是否重复
	public List getRoomByMod(Integer roomId, String roomName);
	//修改 判断房间号是否存在
	public List getRoomSiteByMod(Integer roomId, String roomSite);
	//修改
	public void update(Room r);
	//根据id获取房间对象
	public Room getRoomById(Integer room_id);
	//修改房间状态
	public void deleteRoom(Integer roomId) throws Exception;
	//获取特价房间
	public List<Room> listBarRoom(RoomStayQuery query);
	

}
