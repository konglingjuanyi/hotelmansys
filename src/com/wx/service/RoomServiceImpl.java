package com.wx.service;

import java.util.Date;
import java.util.List;

import com.shxt.dao.IBaseDao;
import com.shxt.utils.PageBean;
import com.wx.model.Room;
import com.wx.model.RoomQuery;
import com.wx.model.RoomStayQuery;
import com.wx.model.RoomType;

public class RoomServiceImpl implements IRoomService {
	private IBaseDao baseDao ;
	public IBaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	/**
	 * 按条件 分页查询
	 */
	public PageBean find(PageBean pageBean, RoomQuery query) {
		String hql = "from Room as r where 1=1";
		//注意查询提交的拼接
		if(query!=null){
			if(query.getRoomName()!=null&&query.getRoomName().trim().length()>0){
				hql += " and r.room_name like '%"+query.getRoomName().trim()+"%'";
			}
			if(query.getRoomSite()!=null&&query.getRoomSite().trim().length()>0){
				hql += " and r.room_site = '"+query.getRoomSite()+"' ";
			}
		}
		return baseDao.find(hql, pageBean);
	}
	public List<RoomType> getTypeList() {
		String hql = "from RoomType as rt where rt.type_status='1'";
		return (List<RoomType>) baseDao.list(hql);
	}
	public List getNameByReg(Room room) {
		String hql = "from Room as r where r.room_name=?";
		return baseDao.list(hql, room.getRoom_name());
	}
	public Room addRoom(Room room) {
		
		return (Room) baseDao.add(room);
	}
	public List getSiteByReg(Room room) {
		String hql = "from Room as r where r.room_site=?";
		return baseDao.list(hql, room.getRoom_site());
	}
	public Room queryById(Integer roomId) {
		String hql = "from Room as r where r.room_id=?";
		return (Room) baseDao.queryObject(hql, roomId);
	}
	public List getRoomByMod(Integer roomId, String roomName) {
		String hql = "from Room as r where r.room_name=? and r.room_id not in (?)";
		return baseDao.list(hql, new Object[]{roomName,roomId});
	}
	public List getRoomSiteByMod(Integer roomId, String roomSite) {
		String hql = "from Room as r where r.room_site=? and r.room_id not in (?)";
		return baseDao.list(hql, new Object[]{roomSite,roomId});
	}
	public void update(Room r) {
		baseDao.update(r);
	}
	public RoomType getRoomType(Integer typeId) {
		String hql = "from RoomType as rt where rt.type_id=?";
		return (RoomType) baseDao.queryObject(hql, typeId);
	}
	public Room getRoomById(Integer roomId) {
		String hql = "from Room as r where r.room_id=?";
		return (Room) baseDao.queryObject(hql, roomId);
	}
	public void deleteRoom(Integer roomId) throws Exception {
		String h = "from RoomStay as rs where rs.stay_roomId.room_id = ?";
		List l = baseDao.list(h, roomId); 
		if(l!=null&&l.size()>0){
			h += " and rs.stay_prepStatus in ('2','3')";
			List list = baseDao.list(h,roomId);
			if(list!=null&&list.size()>0){
				throw new Exception("该房间已经被分配!");
			}else{
				String hql = "update Room as r set r.room_status='2' where r.room_id=?";
				baseDao.updateByHql(hql, roomId);
			}
		}else{
			String hql = "update Room as r set r.room_status='2' where r.room_id=?";
			baseDao.updateByHql(hql, roomId);
		}
	}
	public List<Room> listBarRoom(RoomStayQuery query) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rj_room r where r.room_status='1' and r.room_bargain='2' ");
		
		//注意查询提交的拼接
		if(query!=null){
			if(query.getBarDate()!=null){
				sb.append(" and r.bar_startDate <= to_date('"+query.getBarDate().toLocaleString().split(" ")[0]+"','YYYY/MM/DD')");
				sb.append(" and r.bar_enddate > to_date('"+query.getBarDate().toLocaleString().split(" ")[0]+"', 'YYYY/MM/DD')");
				sb.append(" and r.room_id not in(select r.room_id from rj_room  r,rj_roomstay s where r.room_status='1' and r.room_bargain='2'");
				sb.append(" and r.bar_startDate <= to_date('"+query.getBarDate().toLocaleString().split(" ")[0]+"','YYYY/MM/DD')");
			}
		}else{
			sb.append(" and r.bar_startDate <= to_date('"+new Date().toLocaleString().split(" ")[0]+"','YYYY/MM/DD')");
			sb.append(" and r.bar_enddate > to_date('"+new Date().toLocaleString().split(" ")[0]+"', 'YYYY/MM/DD')");
			sb.append(" and r.room_id not in(select r.room_id from rj_room  r,rj_roomstay s where r.room_status='1' and r.room_bargain='2'");
			sb.append(" and r.bar_startDate <= to_date('"+new Date().toLocaleString().split(" ")[0]+"','YYYY/MM/DD')");
		}
		sb.append(" and s.stay_roomid=r.room_id and s.stay_prepstatus in ('2','3') and r.bar_enddate between s.stay_startdate and s.stay_quitdate)");
		System.out.println("------------"+sb.toString());;
		return (List<Room>) baseDao.listBySql(sb.toString(), Room.class, true);
	}
	
}
