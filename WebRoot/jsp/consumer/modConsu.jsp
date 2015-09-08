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
		//验证名称是否存在
		function toJSONAjax(){
  			var consu_name = $("#consu_name").val();
  			var consu_id = '<s:property value="%{#consumer.consu_id}" />';
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "consu_name="+consu_name+"&consumer.consu_id="+consu_id;
  			$.ajax({
  				type:"post",
  				url :"modConsuJsonJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#consu_name_id").html("<font color='red'><b>&otimes;名称已经存在！</b></font>");
  						msg = false;
  					}else{
  						$("#consu_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		function nameBlur(){
			if($("#consu_name").attr("value")==""||$("#consu_name").attr("value")==null){
				$("#consu_name_id").html("<font color='red'><b>姓名不能为空!</b></font>");
				return false;
			}else{
				toJSONAjax();
				if(!msg){
					return false;
				}
			}
			return true;
		}
		function telphoneBlur(){
			if($("#consu_telphone").attr("value")==""||$("#consu_telphone").attr("value")==null){
				$("#consu_telphone_id").html("<font color='red'><b>电话不能为空!</b></font>");
				return false;
			}
			if(!$("#consu_telphone").attr("value").isMobile()){
				$("#consu_telphone_id").html("<font color='red'><b>电话号码不正确!</b></font>");
				return false;
			}
			$("#consu_telphone_id").html("<font color='green'>&radic;</font>");
			return true;
		}
		function identifyBlur(){
			if($("#consu_identify").attr("value")==""||$("#consu_identify").attr("value")==null){
				$("#consu_identify_id").html("<font color='red'><b>身份证不能为空!</b></font>");
				return false;
			}
			if(checkIdcard($("#consu_identify").attr("value"))==true){
				return true;
			}else{
				var result = checkIdcard($("#consu_identify").attr("value"));
				$("#consu_identify_id").html("<font color='red' size='-1'><b>"+result+"</b></font>");
				return false;
			}
			$("#consu_identify_id").html("<font color='green'>&radic;</font>");
			return true;
		}
		$(function(){
			$("#consu_name").focus(function(){
				$("#consu_name_id").html("");
			});
			$("#consu_telphone").focus(function(){
				$("#consu_telphone_id").html("");
			});
			$("#consu_identify").focus(function(){
				$("#consu_identify_id").html("");
			});
		});
		function validate(){
			return nameBlur()&&telphoneBlur()&&identifyBlur();
		}
		
	</script>
  </head>
  
  <body>
    <form action="toModConsumerAction.action?consumer.consu_id=<s:property value="#consumer.consu_id" />" method="post" name="consuForm" onsubmit="return validate()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>修改顾客信息</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>顾客姓名:</td>
	    				<td><input value='<s:property value="#consumer.consu_name" />' type="text" name="consumer.consu_name" id="consu_name" onblur="nameBlur()" /></td>
	    				<td width="150px" id="consu_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>电话:</td>
	    				<td><input value='<s:property value="#consumer.consu_telphone" />' type="text" name="consumer.consu_telphone" id="consu_telphone" onblur="telphoneBlur()" /></td>
	    				<td width="150px" id="consu_telphone_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>身份证:</td>
	    				<td><input value='<s:property value="#consumer.consu_identify" />' type="text" name="consumer.consu_identify" id="consu_identify" onblur="identifyBlur()" /></td>
	    				<td width="150px" id="consu_identify_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>会员卡</td>
	    				<td colspan="2">
   							<s:select value='%{#consumer.consu_vipId.vip_id}' list="#vipList" listKey="vip_id" listValue="vip_name" name="vip_id" id="vip"></s:select>  				
   						</td>
	    			</tr>
	    			<tr>
	    				<td>会员留言:</td>
	    				<td colspan="2">
	    					<textarea cols="35" rows="3" name="consumer.consu_say"><s:property value="#consumer.consu_say" /></textarea>
	    				</td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<br /><br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
