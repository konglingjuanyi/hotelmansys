package com.wx.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 入住客房信息表
 * @author 王雪
 * @desc  跟顾客#多对一  跟客房#多对一  
 * 2013-7-24
 * 
 */
public class RoomStay {
	/**表主键*/
	private Integer stay_id;
	/**1: 2：预订 3:入住*/
	private String stay_prepStatus = "1";
	/**客房id*/
	private Room stay_roomId;
	/**入住时间*/
	private Date stay_startDate;
	/**入住天数*/
	private Integer stay_days;
	/**离开时间*/
	private Date stay_quitDate;
	/**入住金额*/
	private float stay_money;
	/**顾客id*/
	private Consumer stay_consuId;
	/**预订电话*/
	private String stay_prepTel;
	
	public Integer getStay_id() {
		return stay_id;
	}
	public void setStay_id(Integer stayId) {
		stay_id = stayId;
	}
	
	public Room getStay_roomId() {
		return stay_roomId;
	}
	public void setStay_roomId(Room stayRoomId) {
		stay_roomId = stayRoomId;
	}
	public Date getStay_startDate() {
		return stay_startDate;
	}
	public void setStay_startDate(Date stayStartDate) {
		stay_startDate = stayStartDate;
	}
	public float getStay_money() {
		return stay_money;
	}
	public void setStay_money(float stayMoney) {
		stay_money = stayMoney;
	}
	
	public Consumer getStay_consuId() {
		return stay_consuId;
	}
	public void setStay_consuId(Consumer stayConsuId) {
		stay_consuId = stayConsuId;
	}
	
	
	public String getStay_prepStatus() {
		return stay_prepStatus;
	}
	public void setStay_prepStatus(String stayPrepStatus) {
		stay_prepStatus = stayPrepStatus;
	}
	public RoomStay() {
		
	}
	public Integer getStay_days() {
		return stay_days;
	}
	public void setStay_days(Integer stayDays) {
		stay_days = stayDays;
	}
	public Date getStay_quitDate() {
		return stay_quitDate;
	}
	public void setStay_quitDate(Date stayQuitDate) {
		stay_quitDate = stayQuitDate;
	}
	public String getStay_prepTel() {
		return stay_prepTel;
	}
	public void setStay_prepTel(String stayPrepTel) {
		stay_prepTel = stayPrepTel;
	}
	@Override
	public String toString() {
		return "RoomStay [stay_days=" + stay_days + ", stay_id=" + stay_id
				+ ", stay_money=" + stay_money + ", stay_prepStatus="
				+ stay_prepStatus + ", stay_prepTel=" + stay_prepTel
				+ ", stay_quitDate=" + stay_quitDate + ", stay_startDate="
				+ stay_startDate + "]";
	}
	
}
