package com.wx.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.utils.PageBean;
import com.wx.model.Room;
import com.wx.model.RoomQuery;
import com.wx.model.RoomType;
import com.wx.service.IRoomService;

public class RoomAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private IRoomService roomService;
	private Room room;
	private RoomQuery query;
	//用于分页
	private PageBean pageBean;
	//用户添加是提前加载类型
	private List<RoomType> typeList;
	//添加时 房间类型  属性驱动
	private Integer type_id;
	/**
	 * 分页 查询
	 * 
	 * @return
	 */
	public String find(){
		//需要初始化我们的pageBean
		if(pageBean==null){
			pageBean = new PageBean();
		}
		//调用分页查询方法-- 使用接口回调的形式
		try {
			pageBean = roomService.find(pageBean, query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.toFolder = "room";
		this.toJsp = "listRoom";
		return SUCCESS;
	}
	/*
	 * 添加房间
	 */
	public String addRoom(){
		ActionContext.getContext().put("typeList", roomService.getTypeList());
		this.toFolder = "room";
		this.toJsp = "addRoom";
		return SUCCESS;
	}
	/**
	 * 真正的添加
	 * @return
	 */
	public String toAdd(){
		
		RoomType rt = roomService.getRoomType(type_id);
		room.setRoom_typeId(rt);
		roomService.addRoom(room);
		this.toFolder = "room";
		this.toJsp = "message";
		this.flag = "add";
		this.message = "客房添加成功!";
		
		return SUCCESS;
	}
	/**
	 * 修改房间
	 * 
	 * @return
	 */
	public String modRoom(){
		room = roomService.queryById(room.getRoom_id());
		//在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("room", room);
		ActionContext.getContext().put("typeList", roomService.getTypeList());
		this.toFolder = "room";
		this.toJsp = "modRoom";
		
		return SUCCESS;
	}
	/**
	 * 正真的修改
	 * @return
	 */
	public String toMod(){
		Room r = roomService.queryById(room.getRoom_id());
		
		RoomType rt = roomService.getRoomType(type_id);
		r.setRoom_typeId(rt);
		r.setRoom_bargain(room.getRoom_bargain());
		r.setRoom_barprice(room.getRoom_barprice());
		r.setRoom_capacity(room.getRoom_capacity());
		r.setRoom_name(room.getRoom_name());
		r.setBar_startDate(room.getBar_startDate());
		r.setBar_endDate(room.getBar_endDate());
		r.setRoom_price(room.getRoom_price());
		r.setRoom_site(room.getRoom_site());
		r.setRoom_status("1");
		
		roomService.update(r);
		
		this.toFolder = "room";
		this.toJsp = "message";
		this.flag = "toMod";
		this.message = "房间修改成功!";
		
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delRoom(){
		
		try {
			roomService.deleteRoom(room.getRoom_id());
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
	public IRoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(IRoomService roomService) {
		this.roomService = roomService;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public RoomQuery getQuery() {
		return query;
	}
	public void setQuery(RoomQuery query) {
		this.query = query;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public List<RoomType> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<RoomType> typeList) {
		this.typeList = typeList;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer typeId) {
		type_id = typeId;
	}

}
