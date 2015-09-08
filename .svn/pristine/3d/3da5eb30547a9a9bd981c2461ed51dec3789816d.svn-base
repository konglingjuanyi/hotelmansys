<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <base href="<%=basePath%>">
    <base target="_self">
    <title>针对模块信息的处理集中营</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/base.css"/>
	<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
	<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
	<script src="<%=path %>/resource/common/tips.js"></script>
	<script src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function rootWinClose(){
			var flag = '<s:property value="flag"/>';
			
			art.dialog.data('retValue', flag);// 存储数据
			art.dialog.close();
			
			var obj = new Object();
			obj.flag = flag;
			window.returnValue = obj;
			window.close();
		}
		
		function goRootHistory(){
			window.history.go(-1);
		}
	</script>
	<style type="text/css">
		td {text-align:center; height: 40px;}
		th {text-align: center;height: 40px;}
 	</style>
  </head>
  
  <body>
  	<h2 align="center">
		<s:property value="message"/>
	</h2>
	<table width="90%" class="toptable">
		<tr>
			<th>客房类型:</th>
			<td><s:property value="#roomStay.stay_roomId.room_typeId.type_name" /></td>
		</tr>
		<tr>
			<th>客房名称:</th>
			<td><s:property value="#roomStay.stay_roomId.room_name" /></td>
		</tr>
		<tr>
			<th>客房地址:</th>
			<td><s:property value="#roomStay.stay_roomId.room_site" /></td>
		</tr>
		<tr>
			<th>客房单价:</th>
			<td>
				<s:if test='%{#roomStay.stay_roomId.room_bargain}==\"1\"'>
					<s:property value="#roomStay.stay_roomId.room_barprice" />
				</s:if>
				<s:else>
					<s:property value="#roomStay.stay_roomId.room_price" />
				</s:else>
			</td>
		</tr>
		<tr>
			<th>入住时间:</th>
			<td><s:date name="#roomStay.stay_startDate" format="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<th>离开时间:</th>
			<td><s:date name="#roomStay.stay_quitDate" format="yyyy-MM-dd"/></td>
		</tr>
	</table>
	<br/>
	<center><input type="button" value="关闭窗口" onclick="rootWinClose()"></center>
  </body>
</html>