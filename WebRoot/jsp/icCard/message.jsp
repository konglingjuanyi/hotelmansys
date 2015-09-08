<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <base href="<%=basePath%>">
    <base target="_self">
    <title>针对模块信息的处理集中营</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/css/admin/main.css"/>
	<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
	<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
	<script src="<%=path %>/resource/common/tips.js"></script>
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
		td {text-align:center;}
 	</style>
  </head>
  
  <body>
  	<h2 align="center">
		<s:property value="message"/>
	</h2>
	<table width="100%" class="listtable stripe">
		<tr>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>购买数量</th>
			<th>金额</th>
		</tr>
		<s:iterator value="#productList" var="pro" status="st">
			<tr>
				<td><s:property value="#pro.pro_name" /></td>
				<td><s:property value="#pro.pro_price" /></td>
				<s:if test='countArr.indexOf(\",\")==-1'>
					<td><s:property value="#count" /></td>
					<td>
						<fmt:formatNumber pattern="#.00" ><s:property value="%{countArr*#pro.pro_price}" /></fmt:formatNumber>
					<!--<s:property value="%{countArr*#pro.pro_price}" />-->
					</td>
				</s:if>
				<s:else>
					   <td><s:property value="#count[#st.index]" /></td>
					   <td><fmt:formatNumber pattern="#.00" ><s:property value="%{#count[#st.index]*#pro.pro_price}" /></fmt:formatNumber></td>
				</s:else>
			</tr>
		</s:iterator>
	</table><br/>
	<center>
		<font color="green" size="4px"><b>总价为：<s:property value="#money" /></b></font>
	</center>
	<br/>
	<input type="button" value="关闭窗口" onclick="rootWinClose()">&nbsp;&nbsp;&nbsp;&nbsp;
  </body>
</html>