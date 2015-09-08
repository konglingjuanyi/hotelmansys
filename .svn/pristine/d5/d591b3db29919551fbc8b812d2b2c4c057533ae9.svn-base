package com.wx.service;

import java.util.List;

import com.wx.action.RoomTypeAction;
import com.wx.model.RoomType;
import com.wx.model.RoomTypeQuery;

public interface IRoomTypeService {
	//查询所有
	public List<RoomType> listAll(RoomTypeQuery query);
	//添加验证是否重复
	public List getTypeByReg(RoomType roomType);
	//添加类型
	public RoomType addRoomType(RoomType roomType);
	//获取对象
	public RoomType queryById(Integer typeId);
	//更新类型
	public void update(RoomType rt);
	//修改时判断类型名称是否重复
	public List getRoomTypeByMod(Integer typeId, String roomTypeName);
	
	public void deleteType(int typeID) throws Exception;
	
}
