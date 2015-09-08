package com.wx.service;

import java.util.List;

import com.shxt.dao.IBaseDao;
import com.wx.model.ProductType;
import com.wx.model.ProductTypeQuery;
import com.wx.model.RoomType;

public class ProductTypeServiceImpl implements IProductTypeService{
	private IBaseDao baseDao ;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<ProductType> listAll(ProductTypeQuery query) {
		String hql = "from ProductType as pt where 1=1";
		if(query!=null){
			if(query.getPtName()!=null&&query.getPtName().trim().length()>0){
				hql +=" and pt.type_name like '%"+query.getPtName().trim()+"%'";
			}
		}
		return (List<ProductType>) baseDao.list(hql);
	}

	public List getNameByReg(ProductType productType) {
		String hql = "from ProductType as pt where pt.type_name=? ";
		return baseDao.list(hql, productType.getType_name());
	}

	public ProductType addProductType(ProductType productType) {
		return (ProductType) baseDao.add(productType);
	}

	public ProductType queryById(Integer typeId) {
		String hql = "from ProductType as pt where pt.type_id=?";
		return (ProductType) baseDao.queryObject(hql, typeId);
	}

	public void update(ProductType pt) {
		baseDao.update(pt);
	}

	public List getTypeByMod(Integer typeId, String productTypeName) {
		String hql = "from ProductType as pt where pt.type_name=? and pt.type_id not in (?)";
		return baseDao.list(hql, new Object[]{productTypeName,typeId});
	}

	public void deleteType(Integer typeId) throws Exception {
		String hql = "from Product as p where p.pro_typeId.type_id=?";
		List productList = baseDao.list(hql, typeId);
		if(productList!=null&&productList.size()>0){
			throw new Exception("该商品类型已经分配，并且个数为["+productList.size()+"]个");
		}else{
			hql = "delete from ProductType as pt where pt.type_id=?";
			baseDao.updateByHql(hql, typeId);
		}
		
	}
}
