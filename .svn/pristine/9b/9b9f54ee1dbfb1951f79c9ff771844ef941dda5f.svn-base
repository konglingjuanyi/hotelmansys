package com.wx.model;

import java.util.HashSet;
import java.util.Set;

/***
 * 设置双向关联  一对多： 该属性在多的一方。应该在一方的设置 inverse=true 
 * @author 王雪
 * @desc顾客信息表 跟会员卡#多对一      跟入住一对多
 * 2013-7-25
 */
public class Consumer {
	/**主键id*/
	private Integer consu_id;
	/**顾客姓名*/
	private String consu_name;
	/**顾客电话*/
	private String consu_telphone;
	/*顾客身份证**/
	private String consu_identify;
	/**vip会员类型卡id*/
	private VipCard consu_vipId;
	/**1:正常2：黑名单*/
	private String consu_status="1";
	/**积分*/
	private Integer consu_integral=0;
	/**留言*/
	private String consu_say;
	/**入住id*/
	private Set<RoomStay> consu_stayId = new HashSet<RoomStay>();
	/**消费卡id*/
	private Set<ICCard> consu_icId;
	
	public Integer getConsu_id() {
		return consu_id;
	}
	public void setConsu_id(Integer consuId) {
		consu_id = consuId;
	}
	public String getConsu_name() {
		return consu_name;
	}
	public void setConsu_name(String consuName) {
		consu_name = consuName;
	}
	public String getConsu_telphone() {
		return consu_telphone;
	}
	public void setConsu_telphone(String consuTelphone) {
		consu_telphone = consuTelphone;
	}
	public String getConsu_identify() {
		return consu_identify;
	}
	public void setConsu_identify(String consuIdentify) {
		consu_identify = consuIdentify;
	}
	public VipCard getConsu_vipId() {
		return consu_vipId;
	}
	public void setConsu_vipId(VipCard consuVipId) {
		consu_vipId = consuVipId;
	}
	
	public String getConsu_status() {
		return consu_status;
	}
	public void setConsu_status(String consuStatus) {
		consu_status = consuStatus;
	}
	
	public Integer getConsu_integral() {
		return consu_integral;
	}
	public void setConsu_integral(Integer consuIntegral) {
		consu_integral = consuIntegral;
	}
	public String getConsu_say() {
		return consu_say;
	}
	public void setConsu_say(String consuSay) {
		consu_say = consuSay;
	}
	public Set<RoomStay> getConsu_stayId() {
		return consu_stayId;
	}
	public void setConsu_stayId(Set<RoomStay> consuStayId) {
		consu_stayId = consuStayId;
	}
	
	public Set<ICCard> getConsu_icId() {
		return consu_icId;
	}
	public void setConsu_icId(Set<ICCard> consuIcId) {
		consu_icId = consuIcId;
	}
	public Consumer() {
	}
	public Consumer(Integer consuId, String consuName, String consuTelphone,
			String consuIdentify, VipCard consuVipId, String consuStatus,
			String consuOther, String consuSay, Set<RoomStay> consuStayId) {
		super();
		consu_id = consuId;
		consu_name = consuName;
		consu_telphone = consuTelphone;
		consu_identify = consuIdentify;
		consu_vipId = consuVipId;
		consu_status = consuStatus;
		consu_say = consuSay;
		consu_stayId = consuStayId;
	}
	
}
