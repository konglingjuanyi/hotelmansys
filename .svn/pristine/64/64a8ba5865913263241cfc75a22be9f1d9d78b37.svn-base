package com.wx.service;

import java.util.List;

import com.wx.model.ProductType;
import com.wx.model.ProductTypeQuery;

public interface IProductTypeService {
	//不分页查询
	public List<ProductType> listAll(ProductTypeQuery query);
	//添加时 判断名称是否重复
	public List getNameByReg(ProductType productType);
	//添加
	public ProductType addProductType(ProductType productType);
	//获取对象
	public ProductType queryById(Integer typeId);
	//更新
	public void update(ProductType pt);
	//修改时验证商品类型名称是否重复
	public List getTypeByMod(Integer typeId, String productTypeName);
	//物理删除
	public void deleteType(Integer typeId) throws Exception;

}
