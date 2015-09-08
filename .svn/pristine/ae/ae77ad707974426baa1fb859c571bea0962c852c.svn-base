package com.wx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 王雪
 * @desc会员卡类型  跟顾客一对多
 * 2013-7-25
 */
public class VipCard {
	/**vip主键*/
	private Integer vip_id;
	/**会员卡类型*/
	private String vip_name;
	/**会员卡折扣*/
	private float vip_discount;
	/**顾客id*/
	private Set<Consumer> vip_consuId = new HashSet<Consumer>();
	
	public Integer getVip_id() {
		return vip_id;
	}
	public void setVip_id(Integer vipId) {
		vip_id = vipId;
	}
	public String getVip_name() {
		return vip_name;
	}
	public void setVip_name(String vipName) {
		vip_name = vipName;
	}
	public float getVip_discount() {
		return vip_discount;
	}
	public void setVip_discount(float vipDiscount) {
		vip_discount = vipDiscount;
	}
	
	public Set<Consumer> getVip_consuId() {
		return vip_consuId;
	}
	public void setVip_consuId(Set<Consumer> vipConsuId) {
		vip_consuId = vipConsuId;
	}
	public VipCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VipCard(Integer vipId, String vipName, float vipDiscount,
			Set<Consumer> vipConsuId, Integer vipIntegral) {
		vip_id = vipId;
		vip_name = vipName;
		vip_discount = vipDiscount;
		vip_consuId = vipConsuId;
	}
	@Override
	public String toString() {
		return "VipCard [vip_discount=" + vip_discount + ", vip_id=" + vip_id
				+ ", vip_name=" + vip_name + "]";
	}
	
}
