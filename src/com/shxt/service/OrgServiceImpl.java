package com.shxt.service;

import java.util.List;

import com.shxt.dao.IBaseDao;
import com.shxt.model.Org;
import com.shxt.model.OrgQuery;

public class OrgServiceImpl implements IOrgService {
	private IBaseDao baseDao ;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Org> listAll(OrgQuery query) {
		String hql = "from Org as o where 1=1 ";
		if(query!=null){
			if(query.getOrgName()!=null&&query.getOrgName().trim().length()>0){
				hql +=" and o.org_name like '%"+query.getOrgName().trim()+"%'";
			}
		}
		return (List<Org>) baseDao.list(hql);
	}

	public List<Org> getOrgByReg(Org org) {
		String hql = "from Org as o where o.org_name=?";
		return (List<Org>) baseDao.list(hql, org.getOrg_name());
	}

	public Org addOrg(Org org) {
		return (Org) baseDao.add(org);
	}

	public Org queryById(int orgId) {
		String hql = "from Org as o where o.org_id=?";
		return (Org) baseDao.queryObject(hql, orgId);
	}

	public List<Org> getOrgByMod(int orgId, String name) {
		
		String hql = "from Org as org where org.org_name=? and org.org_id not in (?)";

		return (List<Org>) baseDao.list(hql, new Object[]{name,orgId});
	}

	public void update(Org org) {
		 baseDao.update(org);
	}
	
	
}
