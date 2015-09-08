package com.wx.service;

import java.util.List;

import com.shxt.dao.IBaseDao;
import com.wx.model.Consumer;
import com.wx.model.ICCard;
import com.wx.model.Product;

public class ICCardServiceImpl implements IICCardService {
	private IBaseDao baseDao;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public ICCard add(ICCard icCard) {
		return (ICCard) baseDao.add(icCard);
	}


	public List<Product> listAll(Integer typeId) {
		String hql = "from Product as p where p.pro_typeId.type_id=? and p.pro_status ='1' and p.pro_store>0";
		return (List<Product>) baseDao.list(hql, typeId);
	}

	public Consumer getConsumerById(Integer consuId) {
		String hql = "from Consumer as c where c.consu_id=?";
		return (Consumer) baseDao.queryObject(hql, consuId);
	}

	public List<Product> listAll() {
		String hql = "from Product as p where p.pro_status ='1' and p.pro_store>0";
		return (List<Product>) baseDao.list(hql);
	}

}
