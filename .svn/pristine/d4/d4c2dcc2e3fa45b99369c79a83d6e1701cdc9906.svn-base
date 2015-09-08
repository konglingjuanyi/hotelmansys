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
	<script src="<%=path %>/resource/My97DatePicker/WdatePicker.js"></script>
	<style type="text/css">
		tr { height: 45px;}
	</style>
	<script type="text/javascript">
		var msg = false;
		var msg1 = false;
		//验证名称是否存在
		function toJSONAjax(){
  			var room_name = $("#room_name").val();
  			var room_id = '<s:property value="%{#room.room_id}" />';
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "room_name="+room_name+"&room.room_id="+room_id;
  			$.ajax({
  				type:"post",
  				url :"modRoomJsonJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#room_name_id").html("<font color='red'><b>&otimes;名称已经存在！</b></font>");
  						msg = false;
  					}else{
  						$("#room_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		//验证房间号是否存在
		function toJSONAjax1(){
  			var room_site = $("#room_site").val();
  			var room_id = '<s:property value="%{#room.room_id}" />';
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "room_site="+room_site+"&room.room_id="+room_id;
  			$.ajax({
  				type:"post",
  				url :"modRoomSiteJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#room_site_id").html("<font color='red'><b>&otimes;房间号已经存在！</b></font>");
  						msg1 = false;
  					}else{
  						$("#room_site_id").html("<font color='green'>&radic;</font>");
  						msg1 = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		function nameBlur(){
			if($("#room_name").attr("value")==""||$("#room_name").attr("value")==null){
				$("#room_name_id").html("<font color='red'><b>名称不能为空!</b></font>");
				return false;
			}else{
				toJSONAjax();
				if(!msg){
					return false;
				}
			}
			return true;
		}
		function siteBlur(){
			if($("#room_site").attr("value")==""||$("#room_site").attr("value")==null){
				$("#room_site_id").html("<font color='red'><b>地址不能为空!</b></font>");
				return false;
			}
			if(!$("#room_site").attr("value").validateSignlessIntegral()){
				$("#room_site_id").html("<font color='red'><b>地址为整数!</b></font>");
				return false;
			}
			toJSONAjax1();
			if(!msg1){
				return false;
			}
			$("#room_site_id").html("<font color='green'>&radic;</font>");
			return true;
		}
		function priBlur(){
			if($("#room_price").attr("value")==""||$("#room_price").attr("value")==null){
				$("#room_price_id").html("<font color='red'><b>价格不能为空!</b></font>");
				return false;
			}
			if(!$("#room_price").attr("value").validateSignlessDecimal()){
				$("#room_price_id").html("<font color='red'><b>价格为正实数!</b></font>");
				return false;
			}
			$("#room_price_id").html("<font color='green'>&radic;</font>");
			return true;
		}
		
		function barpriceBlur(){
			//alert($("#room_barprice").attr("value"));
			if(!$("#room_barprice").attr("value").validateSignlessDecimal()){
					$("#room_barprice_id").html("<font color='red'><b>优惠价格为正实数!</b></font>");
					return false;
				}
			if($("#room_barprice").attr("value")>0){
				if(parseInt($("#room_barprice").attr("value"))>parseInt($("#room_price").attr("value"))){
					$("#room_barprice_id").html("<font color='red'><b>请认真填写优惠价格!</b></font>");
					return false;
				}
			}else{
				$("#room_barprice_id").html("<font color='red'><b>请认真填写优惠价格!</b></font>");
				return false;
			}
			return true;
		}
		
		function bargainChange(t){
			var room_barprice = document.getElementById("room_barprice");
			var startDate = document.getElementById("startDate");
			var endDate = document.getElementById("endDate");
			if(t=='1'){
				room_barprice.setAttribute("disabled","disabled");
				startDate.setAttribute("disabled","disabled");
				endDate.setAttribute("disabled","disabled");
				
			}else{
				room_barprice.removeAttribute("disabled");//删除属性
				startDate.removeAttribute("disabled");
				endDate.removeAttribute("disabled");
			}
		}
		$(function(){
			//加载时 判断是否特价 优惠价格为只读
			bargainChange('<s:property value="#room.room_bargain" />');
			$("#room_name").focus(function(){
				$("#room_name_id").html("");
			});
			$("#room_price").focus(function(){
				$("#room_price_id").html("");
			});
			$("#room_site").focus(function(){
				$("#room_site_id").html("");
			});
			$("#room_barprice").focus(function(){
				$("#room_barprice_id").html("");
			});
		});
		function validate(){
			if($("#room_bargain").val()=='2'){
				if($("#startDate").val()==""||$("#endDate").val()==""||$("#startDate").val()>=$("#endDate").val()){
					alert(" 请认真填写时间!");
					return false;
				}
			}
			return nameBlur()&&siteBlur()&&priceBlur()&&barpriceBlur();
		}
	</script>
  </head>
  
  <body>
    <form action="toModRoomAction.action?room.room_id=<s:property value="#room.room_id" />" method="post" name="roomForm" onsubmit="return validate()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>修改房间</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>房间名称:</td>
	    				<td><input type="text" name="room.room_name" id="room_name" onblur="nameBlur()" value='<s:property value="#room.room_name" />' /></td>
	    				<td width="150px" id="room_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>房间地址:</td>
	    				<td><input type="text" name="room.room_site" id="room_site" onblur="siteBlur()" value='<s:property value="#room.room_site" />' /></td>
	    				<td width="150px" id="room_site_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>房间类型:</td>
	    				<td colspan="2">
   							<s:select list="#typeList" listKey="type_id" listValue="type_name" name="type_id" id="type" value="%{#room.room_typeId.type_id}"></s:select>  				
   						</td>
	    			</tr>
	    			<tr>
	    				<td>房间容量:</td>
	    				<td colspan="2">
	    					<s:radio list="#{'1':'1人','2':'2人','3':'3人','4':'4人','5':'5人'}" name="room.room_capacity" value="%{#room.room_capacity}"></s:radio>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>房间价格:</td>
	    				<td><input type="text" name="room.room_price" id="room_price" onblur="priBlur()" value='<s:property value="#room.room_price" />' />元</td>
	    				<td width="150px" id="room_price_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>是否特价:</td>
	    				<td colspan="2">
	    					<s:select id="room_bargain" list="#{'1':'否','2':'是'}" value="%{#room.room_bargain}" name="room.room_bargain" onclick="bargainChange(this.value)"></s:select>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>优惠价格:</td>
	    				<td><input type="text" name="room.room_barprice" id="room_barprice" value='<s:property value="#room.room_barprice" />' onblur="barpriceBlur()" />元</td>
	    				<td width="150px" id="room_barprice_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>特价起始日期:</td>
	    				<td colspan="2">
	    					<input name="room.bar_startDate" id="startDate" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})" value='<s:date name="#room.bar_startDate" format="yyyy-MM-dd" />'/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>特价结束日期:</td>
	    				<td colspan="2">
	    					<input name="room.bar_endDate" id="endDate" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})" value='<s:date name="#room.bar_endDate" format="yyyy-MM-dd" />'/>
	    				</td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
