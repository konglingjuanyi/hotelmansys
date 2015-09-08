package com.wx.service;

import java.util.Date;
import java.util.List;

import com.shxt.dao.IBaseDao;
import com.wx.model.Room;
import com.wx.model.RoomStay;
import com.wx.model.RoomStayQuery;
import com.wx.model.RoomType;

public class RoomStayServiceImpl implements IRoomStayService {
	private IBaseDao baseDao;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<RoomType> listAll() {
		String hql = "from RoomType as rt where rt.type_status='1'";
		return (List<RoomType>) baseDao.list(hql);
	}

	public List<Room> listAllRoom(Integer typeId) {
		String hql = "from Room as r where r.room_typeId.type_id=? and r.room_status='1' and r.room_bargain='1'";
		return (List<Room>) baseDao.list(hql, typeId);
	}

	public Room getRoom(Integer roomId) {
		String hql = "from Room as r where r.room_id=?";
		return (Room) baseDao.queryObject(hql, roomId);
	}

	public List<Room> getRoomList(String stayStartDate, String stayQuitDate) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from rj_room room where room.room_id not in (");
		sb.append("select r.room_id from rj_room r,rj_roomstay s where r.room_id=s.stay_roomid and s.stay_prepstatus in ('2','3') ");
		sb.append("and to_date('"+stayStartDate+"','YYYY/MM/DD')<s.stay_quitdate ");
		sb.append("and to_date('"+stayQuitDate+"','YYYY/MM/DD')>s.stay_startdate )");
		sb.append(" and room.room_bargain='1' and room.room_status='1' order by room.room_price");
		return (List<Room>) baseDao.listBySql(sb.toString(), Room.class, true);
	}

	public RoomStay addPrep(RoomStay roomStay) {
		return (RoomStay) baseDao.add(roomStay);
	}

	public List<RoomStay> listAllStay() {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from rj_roomstay t ");
		sb.append("where to_date('"+new Date().toLocaleString().split(" ")[0]+"','YYYY/MM/DD') between t.stay_startdate and t.stay_quitdate ");
		sb.append("and t.stay_prepstatus='3'");
		//System.out.println(sb.toString());
		return (List<RoomStay>) baseDao.listBySql(sb.toString(), RoomStay.class, true);
	}

	public RoomStay load(Integer stayId) {
		String hql = "from RoomStay as rs where rs.stay_id=?";
		return (RoomStay) baseDao.queryObject(hql, stayId);
	}

	public void update(RoomStay rs) {
		baseDao.update(rs);
	}

	public List listPrep(RoomStay roomStay) {
		String sql = "select * from rj_roomstay rs where rs.stay_roomId="+roomStay.getStay_roomId().getRoom_id()+" and rs.stay_prepstatus='2' and to_date('"+roomStay.getStay_startDate()+"','YYYY/MM/DD')<rs.stay_startdate order by rs.stay_startdate";
		return baseDao.listBySql(sql, RoomStay.class, true);
	}

	public List<RoomStay> listAllPrep(RoomStayQuery query) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from rj_roomstay t ");
		if(query!=null){
			if(query.getPrepDate()!=null){
				sb.append("where to_date('"+query.getPrepDate().toLocaleString().split(" ")[0]+"','YYYY/MM/DD') between t.stay_startdate and t.stay_quitdate ");
			}else{
				sb.append("where to_date('"+new Date().toLocaleString().split(" ")[0]+"','YYYY/MM/DD') between t.stay_startdate and t.stay_quitdate ");
			}
		}else{
			sb.append("where to_date('"+new Date().toLocaleString().split(" ")[0]+"','YYYY/MM/DD') between t.stay_startdate and t.stay_quitdate ");
		}
		
		sb.append("and t.stay_prepstatus='2'");
		return (List<RoomStay>) baseDao.listBySql(sb.toString(), RoomStay.class, true);
	}

	public void delete(Integer stayId) {
		String hql = "delete from RoomStay as rs where rs.stay_id=?";
		baseDao.updateByHql(hql, stayId);
	}
}
