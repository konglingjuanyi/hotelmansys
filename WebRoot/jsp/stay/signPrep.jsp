<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'prepRoom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
	<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
	<script src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/validate.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#c").focus(function(){
				$("#consu_id").html("");
			});
		});
		var msg = false;
		//校验顾客是否存在
		function consuValidate(){
  			var consu_id = $("#c").val();
  			if(consu_id==""){
  				$("#consu_id").html("<font color='red'>请填写账号!</font>");
  				return ;
  			}
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "consumer.consu_id="+consu_id;
  			$.ajax({
  				type:"post",
  				url :"consuValJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data==""||data==null){
  						$("#consu_id").html("<font color='red'><b>&otimes;该账号不存在！</b></font>");
  						msg = false;
  					}else{
  						$("#consu_id").html("<font color='green'>&radic;"+data.consu_name+"</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		function validate(){
			if($("#c").val()==""){
				$("#consu_id").html("<font color='red'><b>请填写顾客编号!</b></font>");
				return false;
			}
			 consuValidate();
			 return msg;
			
		}
	</script>
  </head>
  <style type="text/css">
		tr { height: 45px;}
 </style>
  <body>
  	<center>
	    <form action="toSignRoomStayAction.action?roomStay.stay_id=<s:property value="#roomStay.stay_id" />" method="post" name="myForm" onsubmit="validate()">
	    	<table >
	    		<tr>		
	    				<td colspan="2"><font color="green" size="4px"><b>顾客编号:RG2203485</b></font></td>
	    				<td colspan="2"><input name="consu_id" size="5" type="text" id="c" onBlur="consuValidate()" /><font color="red">*</font></td>
	    		</tr>
	    		<tr>		
	    				<td colspan="2"><a href="javascript:void(0)" onclick="consuValidate()">验证</a></td>
	    				<td colspan="2" width="100px" id="consu_id">&nbsp;</td>
	    		</tr>
	    		
	    		<tr>
	    			<td colspan="2">&nbsp;</td>
	    			<td colspan="2"><input value="提 交" type="submit" /></td>
	    		</tr>
	    </table>
	    </form>
    </center>
  </body>
</html>
