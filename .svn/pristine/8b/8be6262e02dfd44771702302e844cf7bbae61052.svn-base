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
  </head>
  
  <body>
  
  	<div id="content">
  	<h2 align="center">
		<s:property value="message"/>
	</h2>
	<input type="button" value="关闭窗口" onclick="rootWinClose()">&nbsp;&nbsp;&nbsp;&nbsp;
 	</div>
  </body>
</html>