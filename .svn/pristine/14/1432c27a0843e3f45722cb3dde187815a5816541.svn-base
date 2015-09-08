package com.wx.service;

import java.util.List;

import com.shxt.dao.IBaseDao;
import com.wx.model.RoomType;
import com.wx.model.RoomTypeQuery;

public class RoomTypeImpl implements IRoomTypeService{
	private IBaseDao baseDao ;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<RoomType> listAll(RoomTypeQuery query) {
		String hql = "from RoomType as rt where 1=1 ";
		if(query!=null){
			if(query.getRtName()!=null&&query.getRtName().trim().length()>0){
				hql +=" and rt.type_name like '%"+query.getRtName().trim()+"%'";
			}
			
		}
		
		return (List<RoomType>) baseDao.list(hql);
	}

	public List getTypeByReg(RoomType roomType) {
		String hql = "from RoomType as rt where rt.type_name = ?";
		return baseDao.list(hql, roomType.getType_name());
	}

	public RoomType addRoomType(RoomType roomType) {
		return (RoomType) baseDao.add(roomType);
	}

	public RoomType queryById(Integer typeId) {
		String hql = "from RoomType as rt where rt.type_id=?";
		return (RoomType) baseDao.queryObject(hql, typeId);
	}

	public void update(RoomType rt) {
		baseDao.update(rt);
	}

	public List getRoomTypeByMod(Integer typeId, String roomTypeName) {
		String hql = "from RoomType as rt where rt.type_name=? and rt.type_id not in (?) ";
		return baseDao.list(hql, new Object[]{roomTypeName,typeId});
	}

	public void deleteType(int typeID) throws Exception {
		String hql = "from Room as r where r.room_typeId.type_id = ? and r.room_status=?";
		List roomList = baseDao.list(hql, new Object[]{typeID,"1"});
		if(roomList!=null&&roomList.size()>0){
			throw new Exception("该房间类型已经被分配，并且个数为["+roomList.size()+"]个");
		}else{
			hql = "update RoomType as rt set rt.type_status='2' where rt.type_id=?";
			baseDao.updateByHql(hql, typeID);
		}
			
	}
	
}
