package com.wx.service;

import java.util.List;
import java.util.Random;

import com.shxt.dao.IBaseDao;
import com.wx.model.Chart;

public class FunsionChartServiceImpl implements IFunsionChartService {
	private IBaseDao baseDao;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public String showRoomSQL(String year) {
		String sql = "select to_char(rs.stay_startdate,'mm') xname,sum(rs.stay_money) yvalue from rj_roomstay rs "+
					 "where rs.stay_startdate between to_date('"+year+"-01-01','yyyy-MM-dd') and to_date('"+year+"-12-31','yyyy-MM-dd') "+
					 "group by to_char(rs.stay_startdate,'mm') order by xname";
		try {
			List<Chart> chartList =  (List<Chart>) baseDao.listBySQLChart(sql, null);
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<chart palette=\"2\" caption=\"统计按年房间收入情况\" xAxisName=\"月份\" yAxisName=\"元\" showValues=\"1\" useroundedges=\"4\" >");
			for(Chart chart : chartList){
				sb.append("<set label=\""+chart.getXname()+"\" value=\""+chart.getYvalue()+"\" color=\"#ccffff\"/>");
			}
			sb.append("</chart>");
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String showRoom1SQL(String year,String year1) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<chart palette=\"2\" caption=\"统计按年房间收入情况\" xAxisName=\"月份\" yAxisName=\"元\" showValues=\"1\" useroundedges=\"4\" >");
		
		sb.append("<categories>");
		sb.append("<category label=\"1月\"/>");
		sb.append("<category label=\"2月\"/>");
		sb.append("<category label=\"3月\"/>");
		sb.append("<category label=\"4月\"/>");
		sb.append("<category label=\"5月\"/>");
		sb.append("<category label=\"6月\"/>");
		sb.append("<category label=\"7月\"/>");
		sb.append("<category label=\"8月\"/>");
		sb.append("<category label=\"9月\"/>");
		sb.append("<category label=\"10月\"/>");
		sb.append("<category label=\"11月\"/>");
		sb.append("<category label=\"12月\"/>");
		sb.append("</categories>");
		
		String y = "";
		for(int k = 0 ; k < 2 ; k ++){
			if(k==0){
				y = year;
			}else{
				y = year1;
			}
			try {
				sb.append("<dataset seriesName=\""+y+"\">");
				for(int i = 1 ; i <= 12 ; i ++){
					String days = "";
					switch(i){
						case 1:
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:
						case 12:
							days = "31";
							break;
						case 4:
						case 6:
						case 9:
						case 11:
							days = "30";
							break;
							default:days = "30";break;
					}
					if(i==2){
						if(Integer.parseInt(y)%400==0||Integer.parseInt(y)%4==0){
							days = "29";
						}else{
							days = "28";
						}
					}
					String sql = "select to_char(rs.stay_startdate,'mm') xname,sum(rs.stay_money) yvalue from rj_roomstay rs "+
					 "where rs.stay_startdate between to_date('"+y+"-"+i+"-1','yyyy-MM-dd') and to_date('"+y+"-"+i+"-"+days+"','yyyy-MM-dd') "+
					 "group by to_char(rs.stay_startdate,'mm') order by xname";
					
					List<Chart> chartList =  (List<Chart>) baseDao.listBySQLChart(sql, null);
					if(k==0){
						if(chartList!=null&&chartList.size()>0){
							sb.append("<set value=\""+chartList.get(0).getYvalue()+"\" color=\"#ccffff\"/>");
						}else{
							sb.append("<set value=\""+0+"\" color=\"#ccffff\"/>");
						}
					}else{
						if(chartList!=null&&chartList.size()>0){
							sb.append("<set value=\""+chartList.get(0).getYvalue()+"\" />");
						}else{
							sb.append("<set value=\""+0+"\" />");
						}
					}
				}
				sb.append("</dataset>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sb.append("</chart>");
		return sb.toString();
	}

	public String showProductSQL(String year) {
		String sql = "select to_char(ic.ic_time,'mm') xname,sum(ic.ic_outmoney) yvalue from rj_iccard ic "+
				"where ic.ic_time between to_date('"+year+"-01-01','yyyy-MM-dd') and to_date('"+year+"-12-31','yyyy-MM-dd') "+
				"group by to_char(ic.ic_time,'mm') order by xname";
		try {
			List<Chart> chartList =  (List<Chart>) baseDao.listBySQLChart(sql, null);
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<chart palette=\"2\" caption=\"统计按年超市收入情况\" xAxisName=\"月份\" yAxisName=\"元\" showValues=\"1\" useroundedges=\"4\" >");
			for(Chart chart : chartList){
				sb.append("<set label=\""+chart.getXname()+"\" value=\""+chart.getYvalue()+"\" color=\"#ccffff\"/>");
			}
			sb.append("</chart>");
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String showProduct1SQL(String year) {
		String sql = "select to_char(ic.ic_time,'mm') xname, sum(ic.ic_outmoney-p.pro_inprice*ic.ic_pronum) yvalue from rj_iccard ic,rj_product p "+
		"where ic.ic_proname=p.pro_name and ic.ic_time between to_date('"+year+"-01-01','yyyy-MM-dd') and to_date('"+year+"-12-31','yyyy-MM-dd') "+
		"group by to_char(ic.ic_time,'mm') order by xname";
		try {
			List<Chart> chartList =  (List<Chart>) baseDao.listBySQLChart(sql, null);
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<chart palette=\"2\" caption=\"统计按年超市收入情况\" xAxisName=\"月份\" yAxisName=\"元\" showValues=\"1\" useroundedges=\"4\" >");
			for(Chart chart : chartList){
				sb.append("<set label=\""+chart.getXname()+"\" value=\""+chart.getYvalue()+"\" color=\"#ccffff\"/>");
			}
			sb.append("</chart>");
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
