package com.shxt.utils;

import java.util.List;

public class PageBean {
	
	/**
	 * 分页的大小
	 */
	private Integer size = 5;
	/**
	 * 分页的起始页
	 */
	private Integer offset = 1;
	/**
	 * 总记录数
	 */
	private Long total;
	/**
	 * 分页的数据
	 */
	private List<Object> datas;
	
	/***
	 * 总页数
	 */
	private Long totalPages;
	/**
	 * 排序
	 */
	private String order ="asc";
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<Object> getDatas() {
		return datas;
	}
	public void setDatas(List<Object> datas) {
		this.datas = datas;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
	

}
