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
    
    <title>My JSP 'bargainStay.jsp' starting page</title>
    
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
  					
  					if(data==null){
  						$("#consu_id").html("<font color='red'><b>&otimes;该账号不存在！</b></font>");
  						msg = false;
  					}else{
  						$("#consu_id").html("<font color='green'>"+data.consu_name+"</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		function toBargain(room_id,quit_date){
			if($("#c").val()==""){
				$("#consu_id").html("<font color='red'><b>请填写顾客编号!</b></font>");
			}else{
				consuValidate();
				if(msg==true){
					location.href = "toBargainRoomStayAction.action?room.room_id="+room_id+"&roomStay.stay_quitDate="+quit_date+"&consu.consu_id="+$("#c").val();
				}
				
			}
			
		}
	</script>
  </head>
  
  <body>
    <form action="#" method="post" name="roomForm">
	   		<table class="maintable">
	    		<tr>
	    				<th><font color="green" size="4px"><b>顾客编号:RG2203485</b></font></td>
	    				<td>
	    					<input size="5" type="text" id="c" onblur="consuValidate()" />
	    					<font color="red">*</font>
	    				</td>
	    		</tr>
    			<tr>
    				<th>
	    				<a href="javascript:void(0)" onclick="consuValidate()">验证</a>
	    			</th>
    				<td><td id="consu_id">&nbsp;</td>
    			</tr>
    			<tr>
    				<td>&nbsp;</td>
    				<td>
				<a href="javascript:void(0)" onclick="toBargain('<s:property value="#room.room_id"/>','<s:property value="#quit_date"/>')">提交入住</a>
					</td>
    			</tr>
	   		</table>
	</form>
  </body>
</html>
