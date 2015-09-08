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
  			var role_name = $("#role_name").val();
  			var role_id = '<s:property value="%{#role.role_id}" />';
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "role_name="+role_name+"&role.role_id="+role_id;
  			$.ajax({
  				type:"post",
  				url :"roleJsonModJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					//alert(data.flag);
  					if(data.flag=='error'){
  						$("#role_name_id").html("<font color='red' size='-1'>&otimes;角色已经存在！</font>");
  						msg = false;
  						
  					}else{
  						$("#role_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  				
  			});
  		}
		function nameFocus(){
			$("#role_name_id").html("");
		}
		function nameBlur(){
			if($("#role_name").attr("value")==""||$("#role_name").attr("value")==null){
				$("#role_name_id").html("<font color='red'><b>角色名称不能为空!</b></font>");
				return false;
			}
			toJSONAjax();
			if(msg==true){
				return true;
			}else{
				return false;
			}
		}
		
		
	</script>
  </head>
  
  <body>
    <form action="toModRoleAction.action?role.role_id=<s:property value="#role.role_id" />" method="post" onsubmit="return nameBlur()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>修改角色</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>部门名称:</td>
	    				<td><input value=<s:property value="#role.role_name" /> type="text"  name="role.role_name" id="role_name" onfocus="nameFocus()" onblur="nameBlur()" /></td>
	    				<td width="150px" id="role_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>部门描述:</td>
	    				<td colspan="2"><textarea cols="30" rows="5" name="role.role_desc"><s:property value="#role.role_desc" /></textarea></td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<br /><br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
