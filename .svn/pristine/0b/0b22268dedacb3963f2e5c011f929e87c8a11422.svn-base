package com.wx.action;

import java.io.IOException;
import java.io.PrintWriter;

import com.shxt.action.BaseAction;
import com.wx.service.IFunsionChartService;

public class FunsionChartAction extends BaseAction {
	private IFunsionChartService funsionCharService;
	private String year;
	private String year1;
	
	public void showRoom() throws IOException{
		
		this.response.setContentType("text/html;charset=UTF-8");
		
		String str = funsionCharService.showRoomSQL(year);
		
		PrintWriter out = this.response.getWriter();
		
		out.write(str);
		
		out.flush();
		out.close();
		
	}
	public void showRoom1() throws IOException{
		
		this.response.setContentType("text/html;charset=UTF-8");
		
		String str = funsionCharService.showRoom1SQL(year,year1);
		
		PrintWriter out = this.response.getWriter();
		
		out.write(str);
		
		out.flush();
		out.close();
		
	}
	public void showProduct() throws IOException{
		this.response.setContentType("text/html;charset=UTF-8");
		
		String str = funsionCharService.showProductSQL(year);
		
		PrintWriter out = this.response.getWriter();
		
		out.write(str);
		
		out.flush();
		out.close();
	}
	public void showProduct1() throws IOException{
		this.response.setContentType("text/html;charset=UTF-8");
		
		String str = funsionCharService.showProduct1SQL(year);
		
		PrintWriter out = this.response.getWriter();
		
		out.write(str);
		
		out.flush();
		out.close();
	}
	public IFunsionChartService getFunsionCharService() {
		return funsionCharService;
	}

	public void setFunsionCharService(IFunsionChartService funsionCharService) {
		this.funsionCharService = funsionCharService;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	public String getYear1() {
		return year1;
	}
	public void setYear1(String year1) {
		this.year1 = year1;
	}
	
}
