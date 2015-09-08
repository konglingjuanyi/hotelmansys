package com.wx.service;

import java.util.List;

import com.shxt.dao.IBaseDao;
import com.shxt.utils.PageBean;
import com.wx.model.Product;
import com.wx.model.ProductQuery;
import com.wx.model.ProductType;
import com.wx.model.RoomType;

public class ProductServiceImpl implements IProductService {
	private IBaseDao baseDao ;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public PageBean find(PageBean pageBean, ProductQuery query) {
		String hql = "from Product as p where p.pro_status='1' ";
		//注意查询提交的拼接
		if(query!=null){
			if(query.getProName()!=null&&query.getProName().trim().length()>0){
				hql += " and p.pro_name like '%"+query.getProName().trim()+"%'";
			}
		}
		return baseDao.find(hql, pageBean);
	}

	public List getTypeList() {
		String hql = "from ProductType as pt ";
		return  baseDao.list(hql);
	}

	public List getNameByReg(Product product) {
		String hql = "from Product as p where p.pro_name=?";
		return baseDao.list(hql, product.getPro_name());
	}

	public ProductType getProductType(Integer productTypeId) {
		String hql = "from ProductType as pt where pt.type_id=?";
		return (ProductType) baseDao.queryObject(hql, productTypeId);
	}

	public Product addProduct(Product product) {
		return (Product) baseDao.add(product);
	}

	public Product queryById(Integer proId) {
		String hql = "from Product as p where p.pro_id=?"; 
		return (Product) baseDao.queryObject(hql, proId);
	}

	public List getNameByMod(Integer proId, String productName) {
		String hql = "from Product as p where p.pro_name=? and p.pro_id not in (?)";
		return baseDao.list(hql, new Object[]{productName,proId});
	}

	public void updateProduct(Product p) {
		baseDao.update(p);
	}

	public Product getProductById(Integer proId) {
		String hql = "from Product as p where p.pro_id=?";
		return (Product) baseDao.queryObject(hql, proId);
	}

}
