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
    
    <title>今日特价</title>
    
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
		/**弹出页面处理**/
		function toWindow(room_id,bar_endDate){
			var path = art.dialog.data('homeDemoPath') || './';// 
			if($("#d").val()==""||$("#d").val()>bar_endDate){
				alert(" 请认真填写时间!");
				return 0;
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
			}else{
				art.dialog.open("bargainRoomStayAction.action?room.room_id="+room_id+"&quit_date="+$("#d").val(), {
					id: 'room_bar_win',
					title: '客房入住界面',
					width:600,
					height:450,
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
							if(retValue=="toBar"){
								window.parent.frames["main"].location.reload();  
							}
						}
						art.dialog.close();
					}
				},false);
			}
		}
	</script>
  </head>
  
  <body>
  	<form action="listBarRoomStayAction.action" method="post" name="roomForm">
  			<table class="maintable">
  				<tr>
  					<th>按时间查询:</th>
  					<td><input name="query.barDate" value='<s:date name="query.barDate" format="yyyy-MM-dd"/>' class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})"/></td>
  					<td><input type="submit" value="查 询" /></td>
  					<th>入住结束时间:</th>
  					<td><input id="d" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d+1}'})"/></td>
  				</tr>
	   		</table>
	   		<table class="listtable stripe">
	   			<tr>
	   				<th>房间类型</th>
	   				<th>房间名称</th>
	   				<th>房间地址</th>
	   				<th>房间容量</th>
	   				<th>房间价格</th>
	   				<th>优惠价格</th>
	   				<th>优惠起始时间</th>
	   				<th>优惠截止时间</th>
	   				<th>操作</th>
	   			</tr>
	   			<s:iterator value="roomList" var="room">
	   				<tr>
	   					<td align="center"><s:property value="#room.room_typeId.type_name"/></td>
	   					<td align="center"><s:property value="#room.room_name"/></td>
	   					<td align="center"><s:property value="#room.room_site"/></td>
	   					<td align="center"><s:property value="#room.room_capacity"/></td>
	   					<td align="center"><s:property value="#room.room_price"/></td>
	   					<td align="center"><font color="#9400D3"><s:property value="#room.room_barprice"/></font></td>
	   					<td align="center"><s:date name="#room.bar_startDate" format="yyyy-MM-dd" /></td>
	   					<td align="center"><s:date name="#room.bar_endDate" format="yyyy-MM-dd" /></td>
	   					<td align="center"><a href="javascript:void(0)" class="add" onclick="toWindow('<s:property value="#room.room_id"/>','<s:date name="#room.bar_endDate" format="yyyy-MM-dd" />')">入 住</a></td>
	   			</s:iterator>
	   		</table>
	   	</form>
    
  </body>
</html>
