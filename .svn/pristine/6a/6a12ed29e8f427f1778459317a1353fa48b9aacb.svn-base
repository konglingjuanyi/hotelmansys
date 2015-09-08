package com.wx.action;

import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.action.BaseAction;
import com.shxt.model.Org;
import com.shxt.model.UserQuery;
import com.shxt.utils.PageBean;
import com.shxt.utils.UploadAction;
import com.wx.model.Consumer;
import com.wx.model.ConsumerQuery;
import com.wx.model.ICCard;
import com.wx.model.Room;
import com.wx.model.RoomType;
import com.wx.model.VipCard;
import com.wx.service.IConsumerService;
import com.wx.service.IICCardService;

public class ConsumerAction extends BaseAction {
	//添加时自动生成一张消费卡
	private IICCardService icCardService;
	private ICCard icCard;//成员变量不要只有一个小写字母，也不两个大写
	private IConsumerService consuService;
	private Consumer consumer;
	//用于分页
	private PageBean pageBean;
	//用于条件查询
	private ConsumerQuery query;
	//添加时会员卡 属性驱动
	private Integer vip_id;
	//添加时 提前加载会员卡
	private List<VipCard> vipList;
	
	
	public String findConsu(){
		//需要初始化我们的pageBean
		if(pageBean==null){
			pageBean = new PageBean();
		}
		//调用分页查询方法-- 使用接口回调的形式
		pageBean = consuService.find(pageBean, query);
		
		this.toFolder = "consumer";
		this.toJsp = "findConsu";
		
		return SUCCESS;
	}
	/**
	 * 用户添加页面
	 * @return
	 */
	public String addConsu(){
		
		ActionContext.getContext().put("vipList", consuService.getVipList());
		
		this.toFolder = "consumer";
		this.toJsp = "addConsu";
		
		return SUCCESS;
	}
	/**
	 * 真正的用户添加
	 * @return
	 * @throws IOException 
	 */
	public String toAdd() {
		VipCard vip = consuService.getVip(vip_id);
		consumer.setConsu_vipId(vip);
		
		consumer = consuService.addConsu(consumer);
		
		this.toFolder = "consumer";
		this.message = "顾客添加成功";
		this.toJsp = "message";
		this.flag = "add";
		return SUCCESS;
	}
	/**
	 * 修改
	 * 
	 * @return
	 */
	public String modConsu(){
		consumer = consuService.queryById(consumer.getConsu_id());
		//在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("vipList", consuService.getVipList());
		ActionContext.getContext().put("consumer", consumer);
		this.toFolder = "consumer";
		this.toJsp = "modConsu";
		return SUCCESS;
	}
	/**
	 * 正真的修改
	 * @return
	 */
	public String toMod(){
		Consumer c = consuService.queryById(consumer.getConsu_id());
		
		VipCard vip = consuService.getVip(vip_id);
		consumer.setConsu_vipId(vip);
		c.setConsu_vipId(vip);
		
		c.setConsu_identify(consumer.getConsu_identify());
		c.setConsu_name(consumer.getConsu_name());
		c.setConsu_say(consumer.getConsu_say());
		c.setConsu_status("1");
		c.setConsu_telphone(consumer.getConsu_telphone());

		consuService.update(c);
		this.toFolder = "consumer";
		this.toJsp = "message";
		this.flag = "toMod";
		this.message = "信息修改成功!";
		
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delConsu(){
		
		consumer= consuService.queryById(consumer.getConsu_id());
		consumer.setConsu_status("2");
		consuService.update(consumer);
		
		this.toFolder = "consumer";
		this.toJsp = "message";
		this.message = "删除成功!";
		this.flag = "del";
		
		return SUCCESS;
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
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public ConsumerQuery getQuery() {
		return query;
	}
	public void setQuery(ConsumerQuery query) {
		this.query = query;
	}

	public Integer getVip_id() {
		return vip_id;
	}
	public void setVip_id(Integer vipId) {
		vip_id = vipId;
	}
	public List<VipCard> getVipList() {
		return vipList;
	}
	public void setVipList(List<VipCard> vipList) {
		this.vipList = vipList;
	}
	public IICCardService getIcCardService() {
		return icCardService;
	}
	public void setIcCardService(IICCardService icCardService) {
		this.icCardService = icCardService;
	}
	public ICCard getIcCard() {
		return icCard;
	}
	public void setIcCard(ICCard icCard) {
		this.icCard = icCard;
	}
	
}
