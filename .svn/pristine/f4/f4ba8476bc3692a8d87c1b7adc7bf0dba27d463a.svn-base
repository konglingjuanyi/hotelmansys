package com.shxt.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateTable {
	public static void main(String[] args) {
		
		//1.读取Hibernate核心配置文件
		Configuration cfg = new Configuration().configure();
		try {
			
			SchemaExport export = new SchemaExport(cfg);
			//script  代表是否在控制台上显示脚本--创建表的SQL语句
			//export  代表是是否在数据库中执行脚本
			export.create(true, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
