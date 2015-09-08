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
    
    <title>My JSP 'listProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/base.css"/>
	<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
	<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
	<script src="<%=path %>/resource/common/tips.js"></script>
	<script src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/validate.js"></script>
	<style type="text/css">
		td {text-align:center;}
 	</style>
	<script type="text/javascript">
		//获取商品
		function typeChange(){
			var type_id = $("#type_id").val();
			/*if(type_id==""){
  				$("#tab").html("");
  			}*/
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "productType.type_id="+type_id;
  			$.ajax({
  				type:"post",
  				url :"proTypeChangeJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					//alert(data);
  					$("#tab").html("");
					
  					for(var i = 0 ;i<data.length;i++){
  						var tr = document.createElement("tr");
  						var td1 = document.createElement("td");
  						var td2 = document.createElement("td");
  						var td3 = document.createElement("td");
  						var td4 = document.createElement("td");
  						var td5 = document.createElement("td");
  						var td6 = document.createElement("td");
  						var td7 = document.createElement("td");
  						td1.width="100px";
  						td2.width="140px";
  						td3.width="150px";
  						td4.width="140px";
  						td5.width="150px";
  						td6.width="150px";
  						td7.width="100px";
  						td1.innerHTML = i+1;
						td2.innerHTML = data[i].pro_name;
						td3.innerHTML = data[i].pro_store;
						td4.innerHTML = data[i].pro_price;
						td5.innerHTML = data[i].pro_startDate.substring(0,10);
						td6.innerHTML = data[i].pro_endDate.substring(0,10);
						td7.innerHTML = '<input type="text" id='+data[i].pro_id+'  />';
						tr.appendChild(td1);
						tr.appendChild(td2);
						tr.appendChild(td3);
						tr.appendChild(td4);
						tr.appendChild(td5);
						tr.appendChild(td6);
						tr.appendChild(td7);
						$("#tab").append(tr);
  					} 
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
	</script>
	<script type="text/javascript">
	$(function(){
		$("#consu_id").focus(function(){
			$("#consu_name").html("");
		});
	});
		
		var msg = false;
		//动态查询顾客姓名
		function consuValidate(){
			var consu_id = $("#consu_id").val();
			if(consu_id==""){
				$("#consu_name").html("<font color='red'>请填写顾客编号!</font>");
  				msg = false;
  				return 0;
  			}
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "consumer.consu_id="+consu_id;
  			$.ajax({
  				type:"post",
  				url :"consuValidateJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
	  				if(data==null||data==""){
	  					$("#consu_name").html("<font color='red'>该顾客编号不存在!</font>");
	  					msg = false;
	  				}else{
	  					$("#consu_name").html(data.consu_name);
  						msg = true;
	  				}
  				}
  				//error: function(data) {return false; }// 请求失败时调用
  			});
  		}
		/**弹出页面处理**/
			function toWindow(type){
				var consu_id = $("#consu_id").val();
				if(consu_id==""){
	  				alert("请填写顾客编号!");
	  			}else{
	  				consuValidate();
					if(msg==false){
						alert("该顾客不存在!");
					}else{
						var path = art.dialog.data('homeDemoPath') || './';// 
						switch(type){
							case 'balance':
								var idArr = new Array();
								var countArr = new Array();
								var i = 0;
								$("#tab tr").each(function(index){
									var r = parseInt($(this).children("td").eq(6).children().val());
									var re = $(this).children("td").eq(6).children().val().validateSignlessIntegral();
									//alert($(this).children("td").eq(6).children().val()=="");
									if(r==""||r==null||re==false){
										return 0;
									}else{
										var id = $(this).children("td").eq(6).children().attr("id");
										var count = $(this).children("td").eq(6).children().val();
										//alert(count);
										if(parseInt(count)>parseInt($(this).children("td").eq(2).text())){
											alert("商品库存不足!");
											return 0;
										}else{
											idArr[i] = id;
											countArr[i] = count;
											i++;
										}
									}
								});
								if(idArr.length!=countArr.length||idArr.length==0){
									alert("请正确选择商品!");
								}else{
									var url = "balanceICCardAction.action?consumer.consu_id="+$("#consu_id").val()+"&idArr="+idArr+"&countArr="+countArr;
								//	alert(url);
									art.dialog.open(url, {
										id: 'ic_add_win',
										title: '购买界面',
										width:500,
										height:300,
									    lock:true,
									    fixed: true,
									    resize: false,
									    // 在open()方法中，init会等待iframe加载完毕后执行
									    init: function () {
									    	var iframe = this.iframe.contentWindow;
									    	var top = art.dialog.top;// 引用顶层页面window对象
									    },
									    close: function () {
											var retValue = art.dialog.data('retValue');// 读取B页面的数据;
											if (retValue !== undefined){
												if(retValue=="balance"){
													window.location="listProTypeICCardAction.action";  
												}
											}
											art.dialog.close();
										}
									},false);
									break;
								}
								
						}
					}
				}
			}
		function decrease(){
			var path = art.dialog.data('homeDemoPath') || './';// 
			art.dialog.open('jsp/icCard/decrease.jsp', {
				id: 'product_des_win',
				title: '顾客退货界面',
				width:400,
				height:250,
			    lock:true,
			    fixed: true,
			    resize: false,
			    // 在open()方法中，init会等待iframe加载完毕后执行
			    init: function () {
			    	var iframe = this.iframe.contentWindow;
			    	var top = art.dialog.top;// 引用顶层页面window对象
			    },
			    close: function () {
					var retValue = art.dialog.data('retValue');// 读取B页面的数据;
					if (retValue !== undefined){
						if(retValue=="toMod"){
							window.parent.frames["main"].location.reload();  
						}
					}
					art.dialog.close();
				}
			},false);
	}
	</script>

  </head>
  
  <body onload="typeChange()">
    	<table class="maintable">
	   		<tr>
	   			<th width="100px">商品类型:</th>
	   			<td width="100px">
	   				<s:select id="type_id" list="#productTypeList" listKey="type_id" listValue="type_name" name="type_id" headerKey="" headerValue="请选择商品类型" onchange="typeChange()"></s:select>
	   			</td>
	   			<th width="300px">顾客编号：RJ238546<input type="text" id="consu_id" onblur="consuValidate()" /></th>
	   			<td width="150px" id="consu_name"></td>
	   			<th align="center"><a href="javascript:void(0)" onclick="toWindow('balance')">结算</a></th>
	   			<th align="center"><a href="javascript:void(0)" onclick="decrease()">退货</a></th>
	   		</tr>
	   	</table>
	   	<table width="100%" class="listtable stripe">
	   		<tr>
	   			<th>编号</th>
		   		<th>商品名称</th>
		   		<th>商品库存</th>
		   		<th>单价(元)</th>
		   		<th>生产日期</th>
		   		<th>过期日期</th>
		   		<th>购买数量</th>
	   		</tr>
	   	</table>
	   	<table  id="tab" width="100%" class="listtable stripe">
	   	
	   	</table>
  </body>
</html>
