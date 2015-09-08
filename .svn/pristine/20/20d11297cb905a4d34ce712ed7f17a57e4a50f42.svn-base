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
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "room.room_name="+room_name;
  			$.ajax({
  				type:"post",
  				url :"addRoomJsonJsonAjaxAction.action",
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
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "room.room_site="+room_site;
  			$.ajax({
  				type:"post",
  				url :"addRoomSiteJsonAjaxAction.action",
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
			bargainChange('1');
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
    <form action="toAddRoomAction.action" method="post" name="roomForm" onsubmit="return validate()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>添加房间</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>房间名称:</td>
	    				<td><input type="text" name="room.room_name" id="room_name" onblur="nameBlur()" /></td>
	    				<td width="150px" id="room_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>房间地址:</td>
	    				<td><input type="text" name="room.room_site" id="room_site" onblur="siteBlur()" /></td>
	    				<td width="150px" id="room_site_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>房间类型:</td>
	    				<td colspan="2">
   							<s:select list="#typeList" listKey="type_id" listValue="type_name" name="type_id" id="type"></s:select>  				
   						</td>
	    			</tr>
	    			<tr>
	    				<td>房间容量:</td>
	    				<td colspan="2">
	    					<s:radio list="#{'1':'1人','2':'2人','3':'3人','4':'4人','5':'5人'}" name="room.room_capacity" value="1"></s:radio>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>房间价格:</td>
	    				<td><input type="text" name="room.room_price" id="room_price" onblur="priBlur()" />元</td>
	    				<td width="150px" id="room_price_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>是否特价:</td>
	    				<td colspan="2">
	    					<s:select id="room_bargain" list="#{'1':'否','2':'是'}" value='1' name="room.room_bargain" onclick="bargainChange(this.value)"></s:select>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>优惠价格:</td>
	    				<td><input type="text" name="room.room_barprice" id="room_barprice" value="0.0" disabled="disabled" onblur="barpriceBlur()" />元</td>
	    				<td width="150px" id="room_barprice_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>特价起始日期:</td>
	    				<td colspan="2">
	    					<input name="room.bar_startDate" id="startDate" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})"/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>特价结束日期:</td>
	    				<td colspan="2">
	    					<input name="room.bar_endDate" id="endDate" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})"/>
	    				</td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
