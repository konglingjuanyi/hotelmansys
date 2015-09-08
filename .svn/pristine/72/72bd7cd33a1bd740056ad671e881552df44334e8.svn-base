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
    
    <title>My JSP 'listRoom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/base.css"/>
	<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
	<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
	<script src="<%=path %>/resource/common/tips.js"></script>
	<script src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
	<script src="<%=path %>/resource/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		//得到 房间
		function typeChange(){
  			var type_id = $("#type_id").val();
  			if(type_id==""){
  				$("#room_id").html("");
  					var option = document.createElement("option");
					option.value ="";
					option.text = "请选择房间";
					$("#room_id").append(option);
  				return false;
  			}
  			
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "roomType.type_id="+type_id;
  			$.ajax({
  				type:"get",
  				url :"typeChangeJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					//$("#room_id").val()=data;
  					$("#room_id").html("");
  					var option = document.createElement("option");
					option.value ="";
					option.text = "请选择房间";
					$("#room_id").append(option);
  					for(var i = 0 ;i<data.length;i++){
  						option = document.createElement("option");
						option.value = data[i].room_id;
						option.text = data[i].room_name;
						$("#room_id").append(option);
  					} 
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		//得到房间价格 和 房间容量
		function roomChange(){
			var room_id = $("#room_id").val();
  			if(room_id==""){
  				$("#price").html("");
  				$("#capacity").html("");
  				return false;
  			}
  			
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "room.room_id="+room_id;
  			$.ajax({
  				type:"get",
  				url :"roomChangeJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					$("#price").html("");
  					$("#price").html(data.room_price);
  					$("#capacity").html("");
					$("#capacity").html(data.room_capacity);
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
		}
	</script>
	<script type="text/javascript">
			/**弹出页面处理**/
			function toWindow(type){
				var path = art.dialog.data('homeDemoPath') || './';// 
				switch(type){
					case 'prep':
						if($("#a").val()==""||$("#b").val()==""||$("#a").val()>=$("#b").val()){
							alert(" 请认真填写时间!");
							break;
						}
						art.dialog.open('prepRoomRoomStayAction.action?roomStay.stay_startDate='+$("#a").val()+'&roomStay.stay_quitDate='+$("#b").val(), {
							id: 'room_prep_win',
							title: '房间预订界面',
							width:770,
							height:500,
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
									if(retValue=="toPrep"){
										window.parent.frames["main"].location.reload();  
									}
								}
								art.dialog.close();
							}
						},false);
						break;
						
						case 'stay':
							if($("#c").val()==""||$("#d").val()==""||$("#c").val()>=$("#d").val()){
								alert(" 请认真填写时间!");
								break;
							}
							var result = confirm("新顾客请点击确定，添加详细信息!");
							if(result==true){
								art.dialog.open('addConsuConsumerAction.action', {
									id: 'consu_add_win',
									title: '添加顾客界面',
									width:600,
									height:500,
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
											if(retValue=="add"){
												window.parent.frames["main"].location.reload();  
											}
										}
										art.dialog.close();
									}
								},false);
								break;
							}else{
								art.dialog.open('stayRoomRoomStayAction.action?roomStay.stay_startDate='+$("#c").val()+'&roomStay.stay_quitDate='+$("#d").val(), {
									id: 'room_stay_win',
									title: '客房入住界面',
									width:770,
									height:550,
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
											if(retValue=="toStay"){
												window.parent.frames["main"].location.reload();  
											}
										}
										art.dialog.close();
									}
								},false);
								break;
							}
				}
			}
	</script>
  </head>
  
  <body>
  	<form action="" method="post" name="roomForm">
  			<table class="maintable">
	   			<tr>
	   				<th width="80px">客房类型:</th>
	   				<td width="80px">
	   					<s:select id="type_id" list="#roomTypeList" listKey="type_id" listValue="type_name" name="type_id" headerKey="" headerValue="请选择房间类型" onchange="typeChange()"></s:select>
	   				</td>
	   				<th width="80px">客房名称:</th>
	   				<td width="80px">
	   					<select id="room_id" name="room_id" onchange="roomChange()">
	   						<option value="">请选择房间</option>
	   					</select>
	   				</td>
	   				<th width="80px">房间价格:</th>
	   				<td width="80px" id="price">&nbsp;</td>
	   				<th width="80px">房间容量:</th>
	   				<td width="80px" id="capacity">&nbsp;</td>
	   			</tr>
	   			<tr>
  					<th>预订起始时间:</th>
  					<td><input id="a" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})"/></td>
  					<th>预订结束时间:</th>
  					<td><input id="b" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})"/></td>
  					<th colspan="4"><a href="javascript:void(0)" class="add" onclick="toWindow('prep')">预  订</a></th>
  				</tr>
  				<tr>
  					<th>入住起始时间:</th>
  					<td><input id="c" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})"/></td>
  					<th>入住结束时间:</th>
  					<td><input id="d" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d+1}'})"/></td>
  					<th colspan="4"><a href="javascript:void(0)" class="add" onclick="toWindow('stay')">入 住</a></th>
  				</tr>
	   		</table>
	   	</form>
    <table>
    	<tr>
    		<s:iterator value="roomTypeList" var="type" status="st">
    			<td><img width="300" height="300" src="<%=path %>/upload/<s:property value="#type.type_photo"/>" /></td>
    			<td><font color="green" size="5" face="楷体"><b><s:property value="#type.type_name"/></b></font></td>
    			<s:if test="(#st.index+1)%3==0">
    		</tr>
    			</s:if>
    		</s:iterator>
    </table>
  </body>
</html>
