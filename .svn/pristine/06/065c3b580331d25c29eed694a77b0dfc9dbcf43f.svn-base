package com.wx.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.action.BaseAction;
import com.wx.model.ProductType;
import com.wx.model.VipCard;
import com.wx.model.VipCardQuery;
import com.wx.service.IVipCardService;

public class VipCardAction extends BaseAction {
	private IVipCardService vipCardService;
	private VipCard vipCard;
	private VipCardQuery query;
	private List<VipCard> vipCardList;
	/**
	 * 不分页 查询
	 * 
	 * @return
	 */
	public String listVipCard(){
		vipCardList = vipCardService.listAll(query);
		this.toFolder = "vipCard";
		this.toJsp = "listVipCard";
		return SUCCESS;
	}
	/**
	 * 添加类型
	 */
	public String addVipCard() {
		this.toFolder = "vipCard";
		this.toJsp = "addVipCard";
		return SUCCESS;
	}

	/**
	 * 真正的类型添加
	 * 
	 * @return
	 */
	public String toAdd() {
		vipCardService.addVipCard(vipCard);
		this.toFolder = "vipCard";
		this.toJsp = "message";
		this.flag = "add";
		this.message = "会员卡添加成功!";
		return SUCCESS;
	}
	/**
	 * 修改会员卡
	 * 
	 * @return
	 */
	public String modVipCard() {
		vipCard = vipCardService.queryById(vipCard.getVip_id());
		ActionContext.getContext().put("vipCard", vipCard);
		this.toFolder = "vipCard";
		this.toJsp = "modVipCard";
		return SUCCESS;
	}

	/**
	 * 正真的修改
	 * 
	 * @return
	 */
	public String toMod() {
		VipCard vc = vipCardService.queryById(vipCard.getVip_id());
		vc.setVip_name(vipCard.getVip_name());
		vc.setVip_discount(vipCard.getVip_discount());
		
		vipCardService.update(vc);

		this.toFolder = "vipCard";
		this.toJsp = "message";
		this.flag = "toMod";
		this.message = "会员卡修改成功!";

		return SUCCESS;
	}
	/**
	 * 删除类型
	 * @return
	 */
	public String delVipCard(){
		try {
			vipCardService.deleteVipCard(vipCard.getVip_id());
		} catch (Exception e) {
			this.toFolder = "vipCard";
			this.toJsp = "message";
			this.message = e.getMessage();
			this.flag = "del";
			return INPUT;
		}
		this.toFolder = "vipCard";
		this.toJsp = "message";
		this.message = "删除成功!";
		this.flag = "del";
		return SUCCESS;
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

	public VipCardQuery getQuery() {
		return query;
	}

	public void setQuery(VipCardQuery query) {
		this.query = query;
	}

	public List<VipCard> getVipCardList() {
		return vipCardList;
	}

	public void setVipCardList(List<VipCard> vipCardList) {
		this.vipCardList = vipCardList;
	}
	
}
