package com.wx.service;

import java.util.List;

import com.shxt.utils.PageBean;
import com.wx.model.Consumer;
import com.wx.model.ConsumerQuery;
import com.wx.model.VipCard;

public interface IConsumerService {
	//分页条件查询
	public PageBean find(PageBean pageBean, ConsumerQuery query);
	//获取会员卡
	public List<VipCard> getVipList();
	//获取对象
	public VipCard getVip(Integer vipId);
	//添加
	public Consumer addConsu(Consumer consumer);
	//添加 判断姓名是否重复
	public List getNameByReg(String consuName);
	//获取对象
	public Consumer queryById(Integer consuId);
	//修改时 判断名称是否重复
	public List getNameByMod(Integer consuId, String consuName);
	//修改
	public void update(Consumer c);
	//根据顾客id 查询是否存在
	public List getConsuById(Consumer consumer);
	//根据顾客查询
	public Consumer loadConsumer(Integer consuId);

}
