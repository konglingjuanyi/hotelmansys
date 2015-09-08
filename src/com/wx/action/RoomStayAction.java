package com.wx.action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.action.BaseAction;
import com.wx.model.Consumer;
import com.wx.model.Room;
import com.wx.model.RoomStay;
import com.wx.model.RoomStayQuery;
import com.wx.model.RoomType;
import com.wx.model.VipCard;
import com.wx.service.IConsumerService;
import com.wx.service.IICCardService;
import com.wx.service.IRoomService;
import com.wx.service.IRoomStayService;

public class RoomStayAction extends BaseAction {
	private IRoomStayService roomStayService;
	private RoomStay roomStay;
	private List<RoomStay> roomStayList;
	private RoomStayQuery query;
	//房间类型
	private List<RoomType> roomTypeList;
	private RoomType roomType;
	private Integer type_id;
	
	//房间
	private IRoomService roomService;
	private List<Room> roomList;
	private Integer room_id;
	private Room room;
	//开始时间 结束时间
	private String start_date;
	private String quit_date;
	//顾客
	private IConsumerService consuService;
	private Consumer consu;
	private Integer consu_id;
	private IICCardService icCardService;
	/**
	 * 今日特价 查询房间
	 */
	public String listBar(){
		
		roomList = roomService.listBarRoom(query);
		ActionContext.getContext().put("roomList", roomList);
		
		this.toFolder = "stay";
		this.toJsp = "listBargainToday";
		return SUCCESS;
	}
	/**
	 * 特价 入住页面
	 */
	public String bargain(){
		room = roomService.getRoomById(room.getRoom_id());
		ActionContext.getContext().put("room", room);
		ActionContext.getContext().put("quit_date", quit_date);
		this.toFolder = "stay";
		this.toJsp = "bargainStay";
		return SUCCESS;
	}
	/***
	 * 真正的特价入住
	 * @throws ParseException 
	 */
	public String toBargain() throws ParseException{
		Integer days = 0;
		//通过前台获取的截止时间  计算顾客住的天数
		long time = roomStay.getStay_quitDate().getTime()-new Date().getTime();
		if(time%(1000*60*60*24)>0){
			days = Integer.parseInt(String.valueOf(time/(1000*60*60*24)))+1;
		}else{
			days = Integer.parseInt(String.valueOf(time/(1000*60*60*24)));
		}
		
			room = roomService.getRoomById(room.getRoom_id());
			consu = consuService.loadConsumer(consu.getConsu_id());
			
			RoomStay rs = new RoomStay();
			rs.setStay_consuId(consu);
			rs.setStay_roomId(room);
			rs.setStay_prepStatus("3");
			float price = room.getRoom_barprice()*days;
			rs.setStay_days(days);
			rs.setStay_money(price);
			rs.setStay_quitDate(roomStay.getStay_quitDate());
			rs.setStay_startDate(new Date());
			
			rs = roomStayService.addPrep(rs);
			
			//修改数据库特价时间
			if(room.getBar_endDate().toLocaleString().equals(roomStay.getStay_quitDate().toLocaleString())){
				room.setRoom_bargain("1");
				room.setRoom_barprice(0.0f);
			}else{
				room.setBar_startDate(roomStay.getStay_quitDate());
			}
			roomService.update(room);
			
			ActionContext.getContext().put("roomStay", rs);
			this.flag = "toBar";
			this.toFolder = "stay";
			this.toJsp = "message";
			DecimalFormat df = new DecimalFormat("###.00");
			this.message = "房间 入住成功!顾客会员卡:"+consu.getConsu_vipId().getVip_name()+",折扣率："+consu.getConsu_vipId().getVip_discount()+",金额为"+df.format(price*consu.getConsu_vipId().getVip_discount());
		
		return SUCCESS;
	}
	/**
	 * 获取roomTypeList
	 * @return
	 */
	public String listRoom(){
		//获取所有客房类型
		roomTypeList = roomStayService.listAll();
		ActionContext.getContext().put("roomTypeList",roomTypeList);
		/*try {
			//获取所有房间
			if(roomTypeList!=null){
				roomList = roomStayService.listAllRoom(roomTypeList.get(0).getType_id());
				ActionContext.getContext().put("roomList",roomList);
			}
			
		} catch (Exception e) {
			this.message = e.getMessage();
		}*/
		
		this.toFolder = "stay";
		this.toJsp = "listRoom";
		return SUCCESS;
	}
	//开始房间预订
	public String prepRoom(){
		//把预订时间化成年月日字符串
		start_date = roomStay.getStay_startDate().toLocaleString().split(" ")[0];
		quit_date = roomStay.getStay_quitDate().toLocaleString().split(" ")[0];
		
		roomList = roomStayService.getRoomList(start_date,quit_date);
		
		ActionContext.getContext().put("roomList",roomList);
		ActionContext.getContext().put("start_date",start_date);
		ActionContext.getContext().put("quit_date",quit_date);
		this.toFolder = "stay";
		this.toJsp = "prepRoom";
		return SUCCESS;
	}
	//真正预订房间
	public String toPrep(){
		room = roomService.getRoomById(room_id);
		roomStay.setStay_roomId(room);
		//获取时间计算天数
		long time = roomStay.getStay_quitDate().getTime()-roomStay.getStay_startDate().getTime();
		Integer days = Integer.parseInt(String.valueOf(time/(1000*60*60*24)));
		float price = room.getRoom_price()*days;
		
		roomStay.setStay_prepStatus("2");
		roomStay.setStay_days(days);
		roomStayService.addPrep(roomStay);
		
		this.flag = "toPrep";
		this.toFolder = "stay";
		this.toJsp = "message1";
		this.message = "房间预订成功!";
		return SUCCESS;
	}
	//开始房间入住
	public String stayRoom(){
		//把预订时间化成年月日字符串
		start_date = roomStay.getStay_startDate().toLocaleString().split(" ")[0];
		quit_date = roomStay.getStay_quitDate().toLocaleString().split(" ")[0];
		
		roomList = roomStayService.getRoomList(start_date,quit_date);
		
		ActionContext.getContext().put("roomList",roomList);
		ActionContext.getContext().put("start_date",start_date);
		ActionContext.getContext().put("quit_date",quit_date);
		this.toFolder = "stay";
		this.toJsp = "stayRoom";
		return SUCCESS;
	}
	//真正的入住房间
	public String toStay(){
		//获取房间对象
		room = roomService.getRoomById(room_id);
		roomStay.setStay_roomId(room);
		//获取顾客对象
		consu = consuService.loadConsumer(consu_id);
		roomStay.setStay_consuId(consu);
		
		long time = roomStay.getStay_quitDate().getTime()-roomStay.getStay_startDate().getTime();
		Integer days = Integer.parseInt(String.valueOf(time/(1000*60*60*24)));
		float price = room.getRoom_price()*days;
		
		roomStay.setStay_days(days);
		roomStay.setStay_money(price*consu.getConsu_vipId().getVip_discount());
		
		roomStay.setStay_prepStatus("3");
		
		roomStayService.addPrep(roomStay);
		
		ActionContext.getContext().put("roomStay",roomStay);
		this.flag = "toStay";
		this.toFolder = "stay";
		this.toJsp = "message";
		DecimalFormat df = new DecimalFormat("###.00");
		this.message = "房间 入住成功!顾客会员卡:"+consu.getConsu_vipId().getVip_name()+",折扣率："+consu.getConsu_vipId().getVip_discount()+",金额为"+df.format(price*consu.getConsu_vipId().getVip_discount());
		return SUCCESS;
	}
	/***
	 * 查询今日入住 
	 * @return
	 */
	public String listStay(){
		
		roomStayList = roomStayService.listAllStay();
		ActionContext.getContext().put("roomStayList", roomStayList);
		this.toFolder = "stay";
		this.toJsp = "listStayToday";

		return SUCCESS;
		
	}
	/***
	 * 退房界面
	 * @return
	 */
	public String exitRoom(){
		roomStay = roomStayService.load(roomStay.getStay_id());
		ActionContext.getContext().put("roomStay", roomStay);
		
		this.toFolder = "stay";
		this.toJsp = "exitStay";
		return SUCCESS;
	}
	/**
	 * 真正退房
	 * @return
	 */
	public String toExit(){
		RoomStay rs = roomStayService.load(roomStay.getStay_id());
		rs.setStay_quitDate(roomStay.getStay_quitDate());
		
		long time = roomStay.getStay_quitDate().getTime()-rs.getStay_startDate().getTime();
		Integer days = Integer.parseInt(String.valueOf(time/(1000*60*60*24)));
		float price = rs.getStay_money()/rs.getStay_days()*days;
		//提前赋值
		DecimalFormat df = new DecimalFormat("###.00");
		this.message = "房间 退订成功!退订金额："+df.format(rs.getStay_money()-price);
		
		rs.setStay_days(days);
		rs.setStay_money(price);
		
		roomStayService.update(rs);
		
		ActionContext.getContext().put("roomStay", rs);
		this.flag = "toExit";
		this.toFolder = "stay";
		this.toJsp = "message";
		
		return SUCCESS;
	}
	/**
	 * 续住界面
	 * @return
	 */
	public String contiRoom(){
		roomStay = roomStayService.load(roomStay.getStay_id());
		ActionContext.getContext().put("roomStay", roomStay);
		
		//查看该房有预定否
		List list =  roomStayService.listPrep(roomStay);
		ActionContext.getContext().put("list", list);
		
		this.toFolder = "stay";
		this.toJsp = "contiStay";
		return SUCCESS;
	}
	/**
	 * 真正续房
	 * @return
	 */
	public String toConti(){
		RoomStay rs = roomStayService.load(roomStay.getStay_id());
		rs.setStay_quitDate(roomStay.getStay_quitDate());
		
		long time = roomStay.getStay_quitDate().getTime()-rs.getStay_startDate().getTime();
		Integer days = Integer.parseInt(String.valueOf(time/(1000*60*60*24)));
		float price = rs.getStay_money()/rs.getStay_days()*days;
		DecimalFormat df = new DecimalFormat("###.00");
		this.message = "房间 续订成功!续订金额："+df.format(price-rs.getStay_money());
		
		rs.setStay_days(days);
		rs.setStay_money(price);
		
		roomStayService.update(rs);
		
		ActionContext.getContext().put("roomStay",rs);
		this.flag = "toConti";
		this.toFolder = "stay";
		this.toJsp = "message";
		
		return SUCCESS;
	}
	/**查询今日预定*/
	public String listPrep(){
		//System.out.println("-----------"+query.getPrepDate());
		roomStayList = roomStayService.listAllPrep(query);
		ActionContext.getContext().put("roomStayList", roomStayList);
		this.toFolder = "stay";
		this.toJsp = "listPrepToday";

		return SUCCESS;
		
	}
	/***开始预定签到界面*/
	public String signRoom(){
		
		roomStay = roomStayService.load(roomStay.getStay_id());
		ActionContext.getContext().put("roomStay", roomStay);
		
		this.toFolder = "stay";
		this.toJsp = "signPrep";
		return SUCCESS;
	}
	/**真正预订签到 入住*/
	public String toSign(){
		//从前一页面获取
		Consumer c = consuService.loadConsumer(consu_id);
		RoomStay rs = roomStayService.load(roomStay.getStay_id());
		
		rs.setStay_consuId(c);
		float price = rs.getStay_days()*rs.getStay_roomId().getRoom_price();
		DecimalFormat df = new DecimalFormat("###.00");
		this.message = "房间 入住成功!顾客会员卡:"+c.getConsu_vipId().getVip_name()+",折扣率："+c.getConsu_vipId().getVip_discount()+",金额为"+df.format(price*c.getConsu_vipId().getVip_discount());
		
		rs.setStay_prepStatus("3");
		rs.setStay_money(price);
		
		roomStayService.update(rs);
		
		ActionContext.getContext().put("roomStay",rs);
		this.flag = "toSign";
		this.toFolder = "stay";
		this.toJsp = "message";
		
		return SUCCESS;
	}
	/**解除预订*/
	public String cancleRoom(){
		roomStayService.delete(roomStay.getStay_id());
		
		this.flag = "cancle";
		this.toFolder = "stay";
		this.toJsp = "message1";
		this.message = "预订解除成功!";
		return SUCCESS;
	}
	public IRoomStayService getRoomStayService() {
		return roomStayService;
	}
	public void setRoomStayService(IRoomStayService roomStayService) {
		this.roomStayService = roomStayService;
	}
	
	public RoomStay getRoomStay() {
		return roomStay;
	}
	public void setRoomStay(RoomStay roomStay) {
		this.roomStay = roomStay;
	}
	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}
	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}


	public List<Room> getRoomList() {
		return roomList;
	}


	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}


	public Integer getType_id() {
		return type_id;
	}


	public void setType_id(Integer typeId) {
		type_id = typeId;
	}


	public Integer getRoom_id() {
		return room_id;
	}


	public void setRoom_id(Integer roomId) {
		room_id = roomId;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String startDate) {
		start_date = startDate;
	}
	public String getQuit_date() {
		return quit_date;
	}
	public void setQuit_date(String quitDate) {
		quit_date = quitDate;
	}
	public IRoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(IRoomService roomService) {
		this.roomService = roomService;
	}
	public Integer getConsu_id() {
		return consu_id;
	}
	public void setConsu_id(Integer consuId) {
		consu_id = consuId;
	}
	public IConsumerService getConsuService() {
		return consuService;
	}
	public void setConsuService(IConsumerService consuService) {
		this.consuService = consuService;
	}
	public Consumer getConsu() {
		return consu;
	}
	public void setConsu(Consumer consu) {
		this.consu = consu;
	}
	public List<RoomStay> getRoomStayList() {
		return roomStayList;
	}
	public void setRoomStayList(List<RoomStay> roomStayList) {
		this.roomStayList = roomStayList;
	}
	public RoomStayQuery getQuery() {
		return query;
	}
	public void setQuery(RoomStayQuery query) {
		this.query = query;
	}
	public IICCardService getIcCardService() {
		return icCardService;
	}
	public void setIcCardService(IICCardService icCardService) {
		this.icCardService = icCardService;
	}
	

}
