package com.wx.service;

import java.util.Date;
import java.util.List;

import com.wx.model.Room;
import com.wx.model.RoomStay;
import com.wx.model.RoomStayQuery;
import com.wx.model.RoomType;

public interface IRoomStayService {
	//查询所有
	public List<RoomType> listAll();
	//查询第一个客房类型 的所有可用房间
	public List<Room> listAllRoom(Integer typeId);
	//根基id 获取房间对象 
	public Room getRoom(Integer roomId);
	//查询预订 房间
	public List<Room> getRoomList(String startDate, String quitDate);
	//预订
	public RoomStay addPrep(RoomStay roomStay);
	//查询今日入住
	public List<RoomStay> listAllStay();
	//获取对象
	public RoomStay load(Integer stayId);
	//更新表
	public void update(RoomStay rs);
	//根据
	public List listPrep(RoomStay roomStay);
	//查询今日预定
	public List<RoomStay> listAllPrep(RoomStayQuery query);
	//删除预订
	public void delete(Integer stayId);

}
