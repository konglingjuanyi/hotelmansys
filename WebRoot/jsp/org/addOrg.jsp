<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  			var org_name = $("#org_name").val();
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "org.org_name="+org_name;
  			$.ajax({
  				type:"post",
  				url :"orgJsonJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#org_name_id").html("<font color='red' size='-1'>&otimes;部门已经存在！</font>");
  					}else{
  						$("#org_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		$(function(){
			$("#org_name").focus(function(){
				$("#org_name_id").html("");
			});
			
		});
		function validate(){
			if($("#org_name").attr("value")==""||$("#org_name").attr("value")==null){
				$("#org_name_id").html("<font color='red'><b>部门名称不能为空!</b></font>");
				return false;
			}
			toJSONAjax();
			if(!msg){
				return false;
			}
			return true;
		}
		function validateAll(){
			return validate();
		}
	</script>
  </head>
  
  <body>
    <form action="toAddOrgAction.action" method="post" onsubmit="return validateAll()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>添加部门</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>部门名称:</td>
	    				<td><input type="text" name="org.org_name" id="org_name" onblur="validate()" /></td>
	    				<td width="150px" id="org_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>部门描述:</td>
	    				<td colspan="2"><textarea cols="30" rows="5" name="org.org_desc"></textarea></td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<br /><br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
