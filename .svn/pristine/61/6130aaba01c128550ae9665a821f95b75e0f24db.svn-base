<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>顾客退货界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/base.css"/>
	<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
	<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
	<script src="<%=path %>/resource/common/tips.js"></script>
	<script src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/validate.js"></script>
	<style type="text/css">
		td {text-align:center;}
		tr {height: 50px;}
 	</style>
 	<script type="text/javascript">
 		var msg = false;
 		function proAjax(){
 			var pro_id = $("#pro_id").val();
			if(pro_id==""){
				$("#pro_name").html("<font color='red'>请填写商品编号!</font>");
  				msg = false;
  				return 0;
  			}
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "product.pro_id="+pro_id;
  			$.ajax({
  				type:"post",
  				url :"decreaseJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
	  				if(data==null||data==""){
	  					$("#pro_name").html("<font color='red'>该商品编号不存在!</font>");
	  					msg = false;
	  				}else{
	  					$("#pro_name").html(data.pro_name);
  						msg = true;
	  				}
  				}
  				//error: function(data) {return false; }// 请求失败时调用
  			});
 		}
 		
 		
 		function validate(){
 			proAjax();
 			if(msg==false){
 				return false;
 			}
 			if($("#pro_num").val()==""){
 				alert("请选择商品数量!");
 				return false;
 			}
 			return true;
 		}
 	</script>
  </head>
  
  <body>
    <center>
    	<form action="decreaseICCardAction.action" method="post" onsubmit="return validate()">
    		<table class="maintable">
    			<caption><font color="green">退货界面</font></caption>
    			<tr>
    				<th>商品编号：</th>
    				<td>RJproduct<input type="text" name="product.pro_id" id="pro_id" onBlur="proAjax()" /></td>
    			</tr>
    			<tr>
    				<th>退货数量:</th>
    				<td>
    					<s:select id="pro_num" list="#{'1':'1','2':'2','3':'3'}" name="pro_num" headerKey="" headerValue="请选择..."></s:select>
    				</td>
    			</tr>
    			<tr>
    				<th id="pro_name">&nbsp;</th>
    				<td>
    					<input type="submit" value="提   交" /></td>
    				</td>
    			</tr>
    		</table>
    	</form>
    </center>
  </body>
</html>
