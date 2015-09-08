package com.shxt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shxt.model.Org;
import com.shxt.model.Role;
import com.shxt.model.User;
import com.shxt.service.IOrgService;
import com.shxt.service.IRoleService;
import com.shxt.service.IUserService;
import com.wx.model.Consumer;
import com.wx.model.ICCard;
import com.wx.model.Product;
import com.wx.model.ProductType;
import com.wx.model.Room;
import com.wx.model.RoomType;
import com.wx.model.VipCard;
import com.wx.service.IConsumerService;
import com.wx.service.IICCardService;
import com.wx.service.IProductService;
import com.wx.service.IProductTypeService;
import com.wx.service.IRoomService;
import com.wx.service.IRoomStayService;
import com.wx.service.IRoomTypeService;
import com.wx.service.IVipCardService;

public class JsonAjaxAction extends BaseAction {
	// 用于用户
	private IUserService userService;
	private User user;
	private IOrgService orgService;
	private Org org;
	// 部门名称 用于修改
	private String name;
	// 用具角色
	private IRoleService roleService;
	private Role role;
	private String role_name;
	// 用于房间类型
	private IRoomTypeService roomTypeService;
	private RoomType roomType;
	private String roomType_name;
	// 用于房间
	private IRoomService roomService;
	private Room room;
	private String room_name;
	private String room_site;
	//用于商品类型
	private IProductTypeService typeService;
	private ProductType productType;
	private String productType_name;
	//用于商品
	private IProductService productService;
	private Product product;
	private String product_name;
	private List<Product> productList;
	// 用于vipCard 会员卡
	private IVipCardService vipCardService;
	private VipCard vipCard;
	private String vipCard_name;
	//用于会员
	private IConsumerService consuService;
	private Consumer consumer;
	private String consu_name;
	//用于入住
	private IRoomStayService roomStayService;
	private List<Room> roomList;
	//用于消费
	private IICCardService icCardService;
	private List<ICCard> icCardList;
	/***
	 * 退货查询商品名称
	 */
	public String decrease(){
		product = productService.queryById(product.getPro_id());
		this.jsonResult = product;
		return JSON;
	}
	/**
	 * 根据编号 查询顾客
	 */
	public String consuValidate(){
		consumer = icCardService.getConsumerById(consumer.getConsu_id());
		this.jsonResult = consumer;
		
		return JSON;
	}
	/***
	 * 商品类型改变 查询商品
	 */
	public String proTypeChange(){
		if(productType.getType_id()==null){
			productList = icCardService.listAll();
			this.jsonResult = productList;
		}else{
			productList = icCardService.listAll(productType.getType_id());
			this.jsonResult = productList;
		}
		return JSON;
	}
	/**
	 * 客房类型改变 获取对应的房间集
	 * @return
	 */
	public String typeChange(){
		roomList = roomStayService.listAllRoom(roomType.getType_id());
		this.jsonResult = roomList;
		return JSON;
	}
	//房间号改变 获取对应房间
	public String roomChange(){
		
		room = roomStayService.getRoom(room.getRoom_id());
		
		this.jsonResult = room;
		return JSON;
	}
	/**
	 * 验证用户账号是否存在 根据用户id
	 * 
	 * @return
	 */
	public String consuVal() {

		consumer = icCardService.getConsumerById(consumer.getConsu_id());
		this.jsonResult = consumer;
		return JSON;
	}
	/**
	 * 验证用户账号是否存在根据用户名
	 * 
	 * @return
	 */
	public String showJSONStruts() {

		Map<String, Object> map = new HashMap<String, Object>();

		List list = userService.getUserByReg(user);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 添加时 验证部门名称是否存在
	 * 
	 * @return
	 */
	public String orgJson() {

		Map<String, Object> map = new HashMap<String, Object>();

		List list = orgService.getOrgByReg(org);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 修改时 验证部门名称是否存在
	 * 
	 * @return
	 */
	public String orgJsonMod() {

		Map<String, Object> map = new HashMap<String, Object>();
		List list = orgService.getOrgByMod(org.getOrg_id(), name);

		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 添加时 验证角色名称是否存在
	 * 
	 * @return
	 */
	public String roleJson() {

		Map<String, Object> map = new HashMap<String, Object>();

		List list = roleService.getRoleByReg(role);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 修改时 验证角色名称是否重复
	 * 
	 * @return
	 */
	public String roleJsonMod() {
		
		Map<String, Object> map = new HashMap<String, Object>();

		List list = roleService.getRoleByMod(role.getRole_id(), role_name);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 添加时 验证房间类型名称是否存在
	 * 
	 * @return
	 */
	public String addRoomTypeJson() {

		Map<String, Object> map = new HashMap<String, Object>();

		List list = roomTypeService.getTypeByReg(roomType);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 修改时 验证客房类型是否存在
	 * 
	 * @return
	 */
	public String modRoomTypeJson() {

		Map<String, Object> map = new HashMap<String, Object>();
		List list = roomTypeService.getRoomTypeByMod(roomType.getType_id(),
				roomType_name);

		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 添加时 验证房间名称是否存在
	 * 
	 * @return
	 */
	public String addRoomJson() {

		Map<String, Object> map = new HashMap<String, Object>();

		List list = roomService.getNameByReg(room);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 添加时 验证房间号是否存在
	 * 
	 * @return
	 */
	public String addRoomSite() {

		Map<String, Object> map = new HashMap<String, Object>();

		List list = roomService.getSiteByReg(room);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 修改时 验证客房名称是否存在
	 * 
	 * @return
	 */
	public String modRoomJson() {

		Map<String, Object> map = new HashMap<String, Object>();
		List list = roomService.getRoomByMod(room.getRoom_id(), room_name);

		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 修改时 验证客房号是否存在
	 * 
	 * @return
	 */
	public String modRoomSite() {

		Map<String, Object> map = new HashMap<String, Object>();
		List list = roomService.getRoomSiteByMod(room.getRoom_id(), room_site);

		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}

	/**
	 * 添加时 验证商品类型名称是否存在
	 * 
	 * @return
	 */
	public String addProductType() {

		Map<String, Object> map = new HashMap<String, Object>();

		List list = typeService.getNameByReg(productType);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 修改时 验证商品类型是否存在
	 * 
	 * @return
	 */
	public String modProductType() {

		Map<String, Object> map = new HashMap<String, Object>();
		List list = typeService.getTypeByMod(productType.getType_id(), productType_name);

		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 添加时 验证商品名称是否存在
	 * 
	 * @return
	 */
	public String addProductJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		List list = productService.getNameByReg(product);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 修改时 验证商品名称是否存在
	 * 
	 * @return
	 */
	public String modProductJson() {

		Map<String, Object> map = new HashMap<String, Object>();
		List list = productService.getNameByMod(product.getPro_id(), product_name);

		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 添加时 验证商品名称是否存在
	 * 
	 * @return
	 */
	public String addVipCardJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		List list = vipCardService.getNameByReg(vipCard);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 修改时 验证商品名称是否存在
	 * 
	 * @return
	 */
	public String modVipCardJson(){
		Map<String, Object> map = new HashMap<String, Object>();
		List list = vipCardService.getNameByMod(vipCard.getVip_id(), vipCard_name);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 添加时 验证商品名称是否存在
	 * 
	 * @return
	 */
	public String addconsuJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		List list = consuService.getNameByReg(consumer.getConsu_name());
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	/**
	 * 修改时 验证商品名称是否存在
	 * 
	 * @return
	 */
	public String modConsuJson(){
		Map<String, Object> map = new HashMap<String, Object>();
		List list = consuService.getNameByMod(consumer.getConsu_id(), consu_name);
		if (list.size() > 0) {
			map.put("flag", "error");
		} else {
			map.put("flag", "ok");
		}
		this.jsonResult = map;
		return JSON;
	}
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IOrgService getOrgService() {
		return orgService;
	}

	public void setOrgService(IOrgService orgService) {
		this.orgService = orgService;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
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

	public String getRoomType_name() {
		return roomType_name;
	}

	public void setRoomType_name(String roomTypeName) {
		roomType_name = roomTypeName;
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

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String roomName) {
		room_name = roomName;
	}

	public String getRoom_site() {
		return room_site;
	}

	public void setRoom_site(String roomSite) {
		room_site = roomSite;
	}

	public IProductTypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(IProductTypeService typeService) {
		this.typeService = typeService;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getProductType_name() {
		return productType_name;
	}

	public void setProductType_name(String productTypeName) {
		productType_name = productTypeName;
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String productName) {
		product_name = productName;
	}

	public IVipCardService getVipCardService() {
		return vipCardService;
	}

	public void setVipCardService(IVipCardService vipCardService) {
		this.vipCardService = vipCardService;
	}

	public VipCard getVipCard() {
		return vipCard;
	}

	public void setVipCard(VipCard vipCard) {
		this.vipCard = vipCard;
	}

	public String getVipCard_name() {
		return vipCard_name;
	}

	public void setVipCard_name(String vipCardName) {
		vipCard_name = vipCardName;
	}

	public IConsumerService getConsuService() {
		return consuService;
	}

	public void setConsuService(IConsumerService consuService) {
		this.consuService = consuService;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public String getConsu_name() {
		return consu_name;
	}

	public void setConsu_name(String consuName) {
		consu_name = consuName;
	}
	public IRoomStayService getRoomStayService() {
		return roomStayService;
	}
	public void setRoomStayService(IRoomStayService roomStayService) {
		this.roomStayService = roomStayService;
	}
	public List<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	public IICCardService getIcCardService() {
		return icCardService;
	}
	public void setIcCardService(IICCardService icCardService) {
		this.icCardService = icCardService;
	}
	public List<ICCard> getIcCardList() {
		return icCardList;
	}
	public void setIcCardList(List<ICCard> icCardList) {
		this.icCardList = icCardList;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
