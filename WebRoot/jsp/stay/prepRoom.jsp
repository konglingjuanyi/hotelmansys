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
				$("#stay_prepTel_id").html("");
			});
		});	
		
		function toPrep(room_id){
			if($("#c").val()==""){
				$("#stay_prepTel_id").html("<font color='red'><b>请填写电话号码!</b></font>");
			}else if(!$("#c").val().isMobile()){
				$("#stay_prepTel_id").html("<font color='red'><b>电话号码不正确!</b></font>");
			}else{
				
				location.href = "toPrepRoomStayAction.action?room_id="+room_id+"&roomStay.stay_startDate="+$("#a").val()+"&roomStay.stay_quitDate="+$("#b").val()+"&roomStay.stay_prepTel="+$("#c").val();
			}
			
		}
	</script>
  </head>
  <style type="text/css">
		tr { height: 45px;}
		.t td{font-family:cursive; color:green;size: 4px}
 </style>
  <body>
  	<center>
	    <form action="" method="post" name="myForm">
	    	<input id="a" name="roomStay.stay_startDate" type="hidden" value='<s:property value="#start_date" />' />
	    	<input id="b" name="roomStay.stay_quitDate" type="hidden" value='<s:property value="#quit_date" />' />
	    	<table class="maintable">
	    		<tr>
	    				<td><font color="green" size="4px"><b>时间为:</b></font></td>
	    				<td><font color="green" size="4px"><b><s:property value="#start_date" /></b></font></td>
	    				<td><font color="red" size="4px"><b>--</b></font></td>
	    				<td><font color="green" size="4px"><b><s:property value="#quit_date" /></b></font></td>
	    				<td>&nbsp;</td>
	    				<td><font color="green" size="4px"><b>预订者电话:</b></font></td>
	    				<td><input type="text" name="roomStay.stay_prepTel" id="c"/><font color="red">*</font></td>
	    				<td width="100px" id="stay_prepTel_id">&nbsp;</td>
	    		</tr>
	   		</table>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<tbody>
	    			<tr class="t">
	   					<td width="120">序号</td>
	   					<td width="130">房间名称</td>
	   					<td width="120">房间号</td>
	   					<td width="100">房间容量</td>
	   					<td width="120">房间单价</td>
	   					<td >操作</td>
   					</tr>
	    			<s:iterator value="roomList" var="room" status="st">
	    				<tr>
	    					<td ><s:property value="#st.index+1"/></td>
		   					<td ><s:property value="#room.room_name"/></td>
		   					<td ><s:property value="#room.room_site"/></td>
		   					<td ><s:property value="#room.room_capacity"/></td>
		   					<td ><s:property value="#room.room_price"/></td>
		   					<td >
		   						<a href="javascript:void(0)" onclick="toPrep('<s:property value="#room.room_id"/>')">提交预订</a>
	   						</td>
	    				</tr>
	    			</s:iterator>
	    		</tbody>
	    </table>
	    </form>
    </center>
  </body>
</html>
