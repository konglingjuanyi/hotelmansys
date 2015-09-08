package com.wx.model;

import java.util.HashSet;
import java.util.Set;

/***
 * 设置关联
 * @author 王雪
 * @desc商品类型  跟商品一对多
 * 2013-7-25
 */
public class ProductType {
	/**商品类型id*/
	private Integer type_id;
	/**商品名称*/
	private String type_name;
	/**商品*/
	private Set<Product> type_proId = new HashSet<Product>();
	
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer typeId) {
		type_id = typeId;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String typeName) {
		type_name = typeName;
	}
	public Set<Product> getType_proId() {
		return type_proId;
	}
	public void setType_proId(Set<Product> typeProId) {
		type_proId = typeProId;
	}
	public ProductType() {
	}
	public ProductType(Integer typeId, String typeName, Set<Product> typeProId) {
		super();
		type_id = typeId;
		type_name = typeName;
		type_proId = typeProId;
	}

}
