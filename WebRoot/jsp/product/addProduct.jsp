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
	<script type="text/javascript" src="<%=path %>/resource/My97DatePicker/WdatePicker.js"></script>
	<style type="text/css">
		tr { height: 50px;}
	</style>
	<script type="text/javascript">
		var msg = false;
		//验证账号是否存在
		function toJSONAjax(){
  			var product_name = $("#pro_name").val();
  			
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "product.pro_name="+product_name;
  			$.ajax({
  				type:"post",
  				url :"addProductJsonJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#pro_name_id").html("<font color='red' size='-1'>&otimes;名称已经存在！</font>");
  						msg = false;
  					}else{
  						$("#pro_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		$(function(){
			$("#pro_name").focus(function(){
				$("#pro_name_id").html("");
			});
			$("#pro_price").focus(function(){
				$("#pro_price_id").html("");
			});
			$("#pro_inprice").focus(function(){
				$("#pro_inprice_id").html("");
			});
			$("#pro_store").focus(function(){
				$("#pro_store_id").html("");
			});
			$("#pro_startDate").focus(function(){
				$("#pro_startDate_id").html("");
			});
			$("#pro_endDate").focus(function(){
				$("#pro_endDate_id").html("");
			});
			
		});
		function nameBlur(){
			if($("#pro_name").attr("value")==""||$("#pro_name").attr("value")==null){
				$("#pro_name_id").html("<font color='red'><b>商品名称不能为空!</b></font>");
				return false;
			}
			toJSONAjax();
			if(!msg){
				return false;
			}
			return true;
		}
		function inpriceBlur(){
			if($("#pro_inprice").attr("value")==""||$("#pro_inprice").attr("value")==null){
				$("#pro_inprice_id").html("<font color='red'><b>商品进价不能为空!</b></font>");
				return false;
			}
			if(!$("#pro_inprice").attr("value").validateSignlessDecimal()){
				$("#pro_inprice_id").html("<font color='red'><b>商品进价为正实数!</b></font>");
				return false;
			}
			return true;
		}
		function priceBlur(){
			if($("#pro_price").attr("value")==""||$("#pro_price").attr("value")==null){
				$("#pro_price_id").html("<font color='red'><b>商品售价不能为空!</b></font>");
				return false;
			}
			if(!$("#pro_price").attr("value").validateSignlessDecimal()){
				$("#pro_price_id").html("<font color='red'><b>商品售价为正实数!</b></font>");
				return false;
			}
			if(parseFloat($("#pro_price").attr("value"))<parseFloat($("#pro_inprice").attr("value"))){
				$("#pro_price_id").html("<font color='red'><b>请认真填写商品售价!</b></font>");
				return false;
			}
			return true;
		}
		function storeBlur(){
			if($("#pro_store").attr("value")==""||$("#pro_store").attr("value")==null){
				$("#pro_store_id").html("<font color='red'><b>商品库存不能为空!</b></font>");
				return false;
			}
			if(!$("#pro_store").attr("value").validateSignlessIntegral()){
				$("#pro_store_id").html("<font color='red'><b>商品库存为正整数!</b></font>");
				return false;
			}
			return true;
		}
		function validate(){
			if($("#pro_startDate").attr("value")==""||$("#pro_startDate").attr("value")==null){
				$("#pro_startDate_id").html("<font color='red'><b>商品生产日期不能为空!</b></font>");
				return false;
			}
			if($("#pro_endDate").attr("value")==""||$("#pro_endDate").attr("value")==null){
				$("#pro_endDate_id").html("<font color='red'><b>商品过期日期不能为空!</b></font>");
				return false;
			}
			return nameBlur()&&priceBlur()&&inpriceBlur()&&storeBlur();
		}
		
	</script>
  </head>
  
  <body>
    <form action="toAddProductAction.action" method="post" onsubmit="return validate()">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>添加商品</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>商品名称:</td>
	    				<td><input type="text" name="product.pro_name" id="pro_name" onblur="nameBlur();" /></td>
	    				<td width="150px" id="pro_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>商品类型:</td>
	    				<td colspan="2">
	    					<s:select list="#typeList" listKey="type_id" listValue="type_name" name="productType_id" ></s:select>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>商品进价:</td>
	    				<td><input type="text" name="product.pro_inprice" id="pro_inprice" onblur="inpriceBlur()" /></td>
	    				<td width="150px" id="pro_inprice_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>商品售价:</td>
	    				<td><input type="text" name="product.pro_price" id="pro_price" onblur="priceBlur()" /></td>
	    				<td width="150px" id="pro_price_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>商品库存:</td>
	    				<td>
	    					<input type="text" name="product.pro_store" id="pro_store" onblur="storeBlur()" />
	    					<s:select list="#{'罐':'罐','瓶':'瓶','袋':'袋','个':'个'}" name="product.pro_unit" id="pro_unit"></s:select>
	    				</td>
	    				<td width="150px" id="pro_store_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>生产日期:</td>
	    				<td>
	    					<input id="pro_startDate" name="product.pro_startDate" class="Wdate" type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
	    				</td>
	    				<td width="150px" id="pro_startDate_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>过期日期:</td>
	    				<td>
	    					<input name="product.pro_endDate" id="pro_endDate" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d+1}'})"/>
	    				</td>
	    				<td width="150px" id="pro_endDate_id">&nbsp;</td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<br /><br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
