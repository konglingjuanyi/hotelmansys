package com.wx.service;

import java.util.List;

import com.shxt.dao.IBaseDao;
import com.wx.model.RoomType;
import com.wx.model.VipCard;
import com.wx.model.VipCardQuery;

public class VipCardServiceImpl implements IVipCardService {
	private IBaseDao baseDao ;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<VipCard> listAll(VipCardQuery query) {
		String hql = "from VipCard as v where 1=1 ";
		if(query!=null){
			if(query.getVipCardName()!=null&&query.getVipCardName().trim().length()>0){
				hql +=" and v.vip_name like '%"+query.getVipCardName().trim()+"%'";
			}
			
		}
		return (List<VipCard>) baseDao.list(hql);
	}

	public List getNameByReg(VipCard vipCard) {
		String hql = "from VipCard as v where v.vip_name=? ";
		return baseDao.list(hql, vipCard.getVip_name());
	}

	public VipCard addVipCard(VipCard vipCard) {
		return (VipCard) baseDao.add(vipCard);
	}

	public VipCard queryById(Integer vipId) {
		String hql = "from VipCard as v where v.vip_id=?";
		return (VipCard) baseDao.queryObject(hql, vipId);
	}

	public List getNameByMod(Integer vipId, String vipCardName) {
		String hql = "from VipCard as v where v.vip_name=? and v.vip_id not in (?)";
		return baseDao.list(hql, new Object[]{vipCardName,vipId});
	}

	public void update(VipCard vc) {
		baseDao.update(vc);
	}

	public void deleteVipCard(Integer vipId) throws Exception {
		String hql = "from Consumer as c where c.consu_vipId.vip_id=?";
		List consuList = baseDao.list(hql, vipId);
		if(consuList!=null&&consuList.size()>0){
			throw new Exception("该会员卡已经分配，并且个数为["+consuList.size()+"]个");
		}else{
			hql = "delete from VipCard as v where v.vip_id=?";
			baseDao.updateByHql(hql, vipId);
		}
	}

}
