package com.wx.service;

import java.util.List;

import com.shxt.utils.PageBean;
import com.wx.model.Product;
import com.wx.model.ProductQuery;
import com.wx.model.ProductType;

public interface IProductService {
	//分页查询商品
	public PageBean find(PageBean pageBean, ProductQuery query);
	//提前加载 商品类型
	public List getTypeList();
	//添加 判断商品名称是否重复
	public List getNameByReg(Product product);
	//获取 对象
	public ProductType getProductType(Integer productTypeId);
	//添加
	public Product addProduct(Product product);
	//获取对象
	public Product queryById(Integer proId);
	//修改 判断商品名称是否重复
	public List getNameByMod(Integer proId, String productName);
	//更新
	public void updateProduct(Product p);
	//根据id获取对象
	public Product getProductById(Integer proId);

}
