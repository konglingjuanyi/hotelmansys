package com.shxt.task;

import java.util.Date;
import java.util.List;

import com.shxt.dao.IBaseDao;
import com.shxt.model.User;
import com.wx.model.Product;
import com.wx.model.Room;


public class TaskTest {
	private IBaseDao baseDao;
	public void update(){
		String sql = "select * from rj_room r where r.room_bargain='2' and r.bar_enddate <= to_date('"+new Date().toLocaleString().split(" ")[0]+"','yyyy-MM-dd') ";
		List<Room> roomList = (List<Room>) baseDao.listBySql(sql, Room.class, true);
		if(roomList!=null&&roomList.size()>0){
			for(Room room : roomList){
				String sql1 = "update rj_room r set r.room_bargain = '1' where r.room_id="+room.getRoom_id()+" ";
				baseDao.updateSql(sql1);
			}
		}
	}
	
	public void test(){
		String sql="select * from rj_product p where p.pro_enddate <= to_date('"+new Date().toLocaleString().split(" ")[0]+"','yyyy-MM-dd')";
		List<Product> productList = (List<Product>) baseDao.listBySql(sql, Product.class, true);
		if(productList!=null&&productList.size()>0){
			for(Product pro : productList){
				String sql_p = "update rj_product p set p.pro_status = '2' where p.pro_id = "+pro.getPro_status();
				baseDao.updateSql(sql_p);
			}
		}
	}
	
	
	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	
}
