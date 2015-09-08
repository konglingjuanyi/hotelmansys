package com.wx.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.action.BaseAction;
import com.wx.model.ProductType;
import com.wx.model.ProductTypeQuery;
import com.wx.model.RoomType;
import com.wx.model.RoomTypeQuery;
import com.wx.service.IProductTypeService;

public class ProductTypeAction extends BaseAction {
	private IProductTypeService typeService;
	private ProductType productType;
	private ProductTypeQuery query;
	private List<ProductType> productTypeList;

	/**
	 * 不分页 查询
	 * 
	 * @return
	 */
	public String listProType() {
		productTypeList = typeService.listAll(query);

		this.toFolder = "product";
		this.toJsp = "listProType";

		return SUCCESS;
	}

	/*
	 * 添加类型
	 */
	public String addProductType() {

		this.toFolder = "product";
		this.toJsp = "addProductType";

		return SUCCESS;
	}

	/**
	 * 真正的类型添加
	 * 
	 * @return
	 */
	public String toAdd() {

		typeService.addProductType(productType);

		this.toFolder = "product";
		this.toJsp = "message";
		this.flag = "add";
		this.message = "商品类型添加成功!";

		return SUCCESS;
	}

	/**
	 * 修改房间类型
	 * 
	 * @return
	 */
	public String modProductType() {

		productType = typeService.queryById(productType.getType_id());

		// 在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("productType", productType);
		this.toFolder = "product";
		this.toJsp = "modProductType";

		return SUCCESS;
	}

	/**
	 * 正真的修改
	 * 
	 * @return
	 */
	public String toMod() {
		ProductType pt = typeService.queryById(productType.getType_id());
		pt.setType_name(productType.getType_name());

		typeService.update(pt);

		this.toFolder = "product";
		this.toJsp = "message";
		this.flag = "toMod";
		this.message = "商品类型修改成功!";

		return SUCCESS;
	}

	/**
	 * 删除类型
	 * 
	 * @return
	 */
	public String delProductType() {

		try {
			typeService.deleteType(productType.getType_id());
		} catch (Exception e) {
			this.toFolder = "product";
			this.toJsp = "message";
			this.message = e.getMessage();
			this.flag = "del";
			return INPUT;
		}
		this.toFolder = "product";
		this.toJsp = "message";
		this.message = "删除成功!";
		this.flag = "del";
		return SUCCESS;
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

	public ProductTypeQuery getQuery() {
		return query;
	}

	public void setQuery(ProductTypeQuery query) {
		this.query = query;
	}

	public List<ProductType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}

}
