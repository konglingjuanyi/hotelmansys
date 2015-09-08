package com.wx.action;

import com.opensymphony.xwork2.ActionContext;
import com.shxt.action.BaseAction;
import com.shxt.model.User;
import com.shxt.model.UserQuery;
import com.shxt.utils.PageBean;
import com.wx.model.Product;
import com.wx.model.ProductQuery;
import com.wx.model.ProductType;
import com.wx.model.RoomType;
import com.wx.service.IProductService;

public class ProductAction extends BaseAction {
	private IProductService productService;
	private Product product;
	// 用于分页
	private PageBean pageBean;
	// 用于条件查询
	private ProductQuery query;
	// 添加时商品类型 属性驱动
	private Integer productType_id;

	public String findProduct() {

		// 需要初始化我们的pageBean
		if (pageBean == null) {
			pageBean = new PageBean();
		}

		// 调用分页查询方法-- 使用接口回调的形式
		pageBean = productService.find(pageBean, query);

		this.toFolder = "product";
		this.toJsp = "findProduct";

		return SUCCESS;
	}
	/*
	 * 添加
	 */
	public String addProduct(){
		
		ActionContext.getContext().put("typeList",productService.getTypeList());
		
		this.toFolder = "product";
		this.toJsp = "addProduct";
		
		return SUCCESS;
	}
	/**
	 * 真正的类型添加
	 * @return
	 */
	public String toAdd(){
		
		ProductType pt = productService.getProductType(productType_id);
		product.setPro_typeId(pt);
		productService.addProduct(product);
		this.toFolder = "product";
		this.toJsp = "message";
		this.flag = "add";
		this.message = "商品添加成功!";
		
		return SUCCESS;
	}
	/**
	 * 修改产品
	 * 
	 * @return
	 */
	public String modProduct() {

		product = productService.queryById(product.getPro_id());

		// 在action里得到的值，要想往前台页面传值，需要放进session里
		ActionContext.getContext().put("product", product);
		ActionContext.getContext().put("typeList",productService.getTypeList());
		this.toFolder = "product";
		this.toJsp = "modProduct";

		return SUCCESS;
	}

	/**
	 * 正真的修改
	 * 
	 * @return
	 */
	public String toMod() {
		Product p = productService.queryById(product.getPro_id());
		
		ProductType pt = productService.getProductType(productType_id);
		p.setPro_typeId(pt);
		
		p.setPro_name(product.getPro_name());
		p.setPro_price(product.getPro_price());
		p.setPro_status("1");
		p.setPro_store(product.getPro_store());
		p.setPro_unit(product.getPro_unit());
		p.setPro_startDate(product.getPro_startDate());
		p.setPro_endDate(product.getPro_endDate());
		p.setPro_inprice(product.getPro_inprice());
		
		productService.updateProduct(p);

		this.toFolder = "product";
		this.toJsp = "message";
		this.flag = "toMod";
		this.message = "商品修改成功!";

		return SUCCESS;
	}
	public String delProduct(){
		
		Product p = productService.queryById(product.getPro_id());
		p.setPro_status("2");
		productService.updateProduct(p);
		
		this.toFolder = "product";
		this.toJsp = "message";
		this.flag = "del";
		this.message = "商品删除成功!";

		return SUCCESS;
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

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public ProductQuery getQuery() {
		return query;
	}

	public void setQuery(ProductQuery query) {
		this.query = query;
	}

	public Integer getProductType_id() {
		return productType_id;
	}

	public void setProductType_id(Integer productTypeId) {
		productType_id = productTypeId;
	}

}
