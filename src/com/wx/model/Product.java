package com.wx.model;

import java.util.Date;

/***
 * 
 * @author 王雪
 * @desc7.	商品信息表   跟商品类型 #多对一
 * 2013-7-25
 */
public class Product {
	/**商品id*/
	private Integer pro_id;
	/**商品名称*/
	private String pro_name;
	/**商品价格*/
	private float pro_price;
	/**商品进价*/
	private float pro_inprice;
	/**商品库存*/
	private Integer pro_store;
	/**商品卖出个数*/
	private Integer pro_outstore=0;
	/**商品单位*/
	private String pro_unit;
	/**生产日期*/
	private Date pro_startDate;
	/**过期日期*/
	private Date pro_endDate;
	/**商品类型*/
	private ProductType pro_typeId;
	/**商品状态1:正常 2：禁用*/
	private String pro_status="1";
	
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer proId) {
		pro_id = proId;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String proName) {
		pro_name = proName;
	}
	public float getPro_price() {
		return pro_price;
	}
	public void setPro_price(float proPrice) {
		pro_price = proPrice;
	}
	public Integer getPro_store() {
		return pro_store;
	}
	public void setPro_store(Integer proStore) {
		pro_store = proStore;
	}
	public String getPro_unit() {
		return pro_unit;
	}
	public void setPro_unit(String proUnit) {
		pro_unit = proUnit;
	}
	public Date getPro_startDate() {
		return pro_startDate;
	}
	public void setPro_startDate(Date proStartDate) {
		pro_startDate = proStartDate;
	}
	public Date getPro_endDate() {
		return pro_endDate;
	}
	public void setPro_endDate(Date proEndDate) {
		pro_endDate = proEndDate;
	}
	public ProductType getPro_typeId() {
		return pro_typeId;
	}
	public void setPro_typeId(ProductType proTypeId) {
		pro_typeId = proTypeId;
	}
	
	public float getPro_inprice() {
		return pro_inprice;
	}
	public void setPro_inprice(float proInprice) {
		pro_inprice = proInprice;
	}
	
	public Integer getPro_outstore() {
		return pro_outstore;
	}
	public void setPro_outstore(Integer proOutstore) {
		pro_outstore = proOutstore;
	}
	
	public String getPro_status() {
		return pro_status;
	}
	public void setPro_status(String proStatus) {
		pro_status = proStatus;
	}
	public Product() {
	}
	public Product(Integer proId, String proName, float proPrice,
			Integer proStore, String proUnit, Date proStartDate,
			Date proEndDate, ProductType proTypeId) {
		super();
		pro_id = proId;
		pro_name = proName;
		pro_price = proPrice;
		pro_store = proStore;
		pro_unit = proUnit;
		pro_startDate = proStartDate;
		pro_endDate = proEndDate;
		pro_typeId = proTypeId;
	}
	@Override
	public String toString() {
		return "Product [pro_endDate=" + pro_endDate + ", pro_id=" + pro_id
				+ ", pro_inprice=" + pro_inprice + ", pro_name=" + pro_name
				+ ", pro_price=" + pro_price + ", pro_startDate="
				+ pro_startDate + ", pro_store=" + pro_store + ", pro_unit="
				+ pro_unit + "]";
	}
	

}
