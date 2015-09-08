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
    
    <title>My JSP 'addOrg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/resource/common/validate.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/jquery-1.8.3.min.js"></script>
	
	<style type="text/css">
		tr { height: 50px;}
	</style>
	<script type="text/javascript">
		var msg = false;
		//验证商品名称是否存在
		function toJSONAjax(){
			
  			var productType_name = $("#productType_name").attr("value");
  			var productType_id = '<s:property value="%{#productType.type_id}" />';
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "productType_name="+productType_name+"&productType.type_id="+productType_id;
  			$.ajax({
  				type:"post",
  				url :"modProductTypeJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#productType_name_id").html("<font color='red' size='-1'>&otimes;名称已经存在！</font>");
  						msg = false;
  					}else{
  						$("#productType_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		$(function(){
			$("#productType_name").focus(function(){
				$("#productType_name_id").html("");
			});
			
		});
		function validate(){
			if($("#productType_name").attr("value")==""||$("#productType_name").attr("value")==null){
				$("#productType_name_id").html("<font color='red'><b>类型名称不能为空!</b></font>");
				return false;
			}
			toJSONAjax();
			if(!msg){
				return false;
			}
			return true;
		}
		
	</script>
  </head>
  
  <body>
    <form action="toModProductTypeAction.action?productType.type_id=<s:property value="#productType.type_id" />" method="post" onsubmit="return validate()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>修改商品类型</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>类型名称:</td>
	    				<td><input type="text" value='<s:property value="#productType.type_name" />' name="productType.type_name" id="productType_name" onblur="validate()" /></td>
	    				<td width="150px" id="productType_name_id">&nbsp;</td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<br /><br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
