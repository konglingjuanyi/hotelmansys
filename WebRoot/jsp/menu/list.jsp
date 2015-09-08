<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
   <head>
		<base href="<%=basePath%>" />
		
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/base.css"/>
		<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
		<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
		<script src="<%=path %>/resource/common/tips.js"></script>
	</head>
	<body>
		<!-- 如果页面有滚动条，或将来有可能出现滚动条，需要加上此div。*如果没有滚动条加上也无妨 -->
		<div class="div_bk">
			<!-- 标题、功能区域 -->
			<table id="pagehead" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="130"><h1>菜单管理</h1></td>
				</tr>
			</table>
			<!-- 搜索区 -->
			<form action="listMenuAction.action" method="post" name="menuQueryForm">
				<table class="maintable">
	   				<tr>
	   					<th>菜单名称</th>
	   					<td colspan="3" ><input type="text" class="text" name="query.menuName" value="<s:property value="query.menuName" />" /></td>
	   				</tr>
	   				<tr align="center">
	   					<td colspan="4" ><input type="submit" value="查询" /></td>
	   				</tr>
	   			</table>
   			</form>
   			
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="100">序号</th>
   					<th width="120">菜单名称</th>
   					<th width="120">父菜单名称</th>
   					<th width="180">菜单地址</th>
   				</tr>
   				<s:iterator value="menuList" var="menus" status="st">
   					<tr>
   					<td align="center"><s:property value="#st.index+1"/></td>
   					<td align="center"><s:property value="#menus.menu_name"/></td>
   					<td align="center"><s:property value="#menus.parent_name" default="父菜单" /></td>
   					<td align="center"><s:property value="#menus.menu_url" default="暂无" /></td>
   				</tr>
   				</s:iterator>
   				
   			</table>
   			
		</div>
	</body>
</html>
