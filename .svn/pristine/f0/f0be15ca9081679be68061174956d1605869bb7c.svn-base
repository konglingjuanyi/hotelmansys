package com.wx.service;

import java.util.List;

import com.shxt.dao.IBaseDao;
import com.shxt.utils.PageBean;
import com.wx.model.Consumer;
import com.wx.model.ConsumerQuery;
import com.wx.model.VipCard;

public class ConsumerServiceImpl implements IConsumerService{
	private IBaseDao baseDao;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public PageBean find(PageBean pageBean, ConsumerQuery query) {
		String hql = "from Consumer as c where 1=1";
		//注意查询提交的拼接
		if(query!=null){
			if(query.getConsuName()!=null&&query.getConsuName().trim().length()>0){
				hql += " and c.consu_name like '%"+query.getConsuName().trim()+"%'";
			}
			if(query.getVipName()!=null&&query.getVipName().trim().length()>0){
				hql += " and c.consu_vipId.vip_name = '"+query.getVipName()+"' ";
			}
		}
		return baseDao.find(hql, pageBean);
	}

	public List<VipCard> getVipList() {
		String hql = "from VipCard as vc";
		return (List<VipCard>) baseDao.list(hql);
	}

	public VipCard getVip(Integer vipId) {
		String hql = "from VipCard as vc where vc.vip_id=?";
		return (VipCard) baseDao.queryObject(hql, vipId);
	}

	public Consumer addConsu(Consumer consumer) {
		return (Consumer) baseDao.add(consumer);
	}

	public List getNameByReg(String consuName) {
		String hql = "from Consumer as c where c.consu_name=?";
		return baseDao.list(hql, consuName);
	}

	public Consumer queryById(Integer consuId) {
		String hql = "from Consumer as c where c.consu_id=?";
		return (Consumer) baseDao.queryObject(hql, consuId);
	}

	public List getNameByMod(Integer consuId, String consuName) {
		String hql = "from Consumer as c where c.consu_name=? and c.consu_id not in (?)";
		return baseDao.list(hql, new Object[]{consuName,consuId});
	}

	public void update(Consumer c) {
		baseDao.update(c);
	}

	public List getConsuById(Consumer consumer) {
		String hql = "from Consumer as c where c.consu_id=?";
		return baseDao.list(hql, consumer.getConsu_id());
	}


	public Consumer loadConsumer(Integer consuId) {
		String hql = "from Consumer as c where c.consu_id=?";
		return (Consumer) baseDao.queryObject(hql, consuId);
	}

	
}
