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
		//验证账号是否存在
		function toJSONAjax(){
  			var vip_name = $("#vip_name").val();
  			var vip_id = '<s:property value="%{#vipCard.vip_id}" />';
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "vipCard_name="+vip_name+"&vipCard.vip_id="+vip_id;
  			$.ajax({
  				type:"post",
  				url :"modVipCardJsonJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#vip_name_id").html("<font color='red' size='-1'><b>&otimes;会员卡已经存在！</b></font>");
  						msg = false;
  					}else{
  						$("#vip_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		$(function(){
			$("#vip_name").focus(function(){
				$("#vip_name_id").html("");
			});
			$("#vip_discount").focus(function(){
				$("#vip_discount_id").html("");
			});
			
		});
		function nameBlur(){
			if($("#vip_name").attr("value")==""||$("#vip_name").attr("value")==null){
				$("#vip_name_id").html("<font color='red'><b>会员卡名称不能为空!</b></font>");
				return false;
			}
			toJSONAjax();
			if(!msg){
				return false;
			}
			return true;
		}
		function discountBlur(){
			if($("#vip_discount").attr("value")==""||$("#vip_discount").attr("value")==null){
				$("#vip_discount_id").html("<font color='red'><b>折扣率不能为空!</b></font>");
				return false;
			}
			if(!$("#vip_discount").attr("value").roundOne()||!$("#vip_discount").attr("value").roundTwo()){
				$("#vip_discount_id").html("<font color='red'><b>折扣率最多有两位有效数字!</b></font>");
				return false;
			}
			if(parseFloat($("#vip_discount").attr("value"))>1||parseFloat($("#vip_discount").attr("value"))<0.3){
				$("#vip_discount_id").html("<font color='red'><b>请认真填写折扣率!</b></font>");
				return false;
			}
			return true;
		}
		function validate(){
			
			return nameBlur()&&discountBlur();
		}
		
	</script>
  </head>
  
  <body>
    <form action="toModVipCardAction.action?vipCard.vip_id=<s:property value="#vipCard.vip_id" />" method="post" onsubmit="return validate()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>修改会员卡</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>会员卡名称:</td>
	    				<td><input value='<s:property value="#vipCard.vip_name" />' type="text" name="vipCard.vip_name" id="vip_name" onblur="nameBlur()" /></td>
	    				<td width="150px" id="vip_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>会员卡折扣率:</td>
	    				<td><input value='<s:property value="#vipCard.vip_discount" />' type="text" name="vipCard.vip_discount" id="vip_discount" onblur="discountBlur()" /></td>
	    				<td width="150px" id="vip_discount_id">&nbsp;</td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<br /><br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
