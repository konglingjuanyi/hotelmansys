package com.wx.service;

import java.util.List;

import com.wx.model.VipCard;
import com.wx.model.VipCardQuery;

public interface IVipCardService {
	//无分页查询
	public List<VipCard> listAll(VipCardQuery query);
	//判断名称是否冲锋衣
	public List getNameByReg(VipCard vipCard);
	//添加
	public VipCard addVipCard(VipCard vipCard);
	//获取对象
	public VipCard queryById(Integer vipId);
	//修改判断名称是否重复
	public List getNameByMod(Integer vipId, String vipCardName);
	//修改
	public void update(VipCard vc);
	//删除
	public void deleteVipCard(Integer vipId) throws Exception;

}
