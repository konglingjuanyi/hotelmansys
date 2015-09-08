<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
   <head>
		<base href="<%=basePath%>" />
		
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/base.css"/>
		<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
		<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
		<script src="<%=path %>/resource/common/tips.js"></script>
		<script src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
		<script src="<%=path %>/resource/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
			/**弹出页面处理**/
			function toWindow(type,stay_id,stay_days){
				var path = art.dialog.data('homeDemoPath') || './';// 
				switch(type){
					case 'exit':
						if(stay_days<=2){
							alert("不能退房!");
							break;
						}else{
					    	var path = art.dialog.data('homeDemoPath') || './';// 
							art.dialog.open('exitRoomRoomStayAction.action?roomStay.stay_id='+stay_id, {
								id: 'stay_exit_win',
								title: '入住退订界面',
								width:550,
								height:400,
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
										if(retValue=="toExit"){
											window.parent.frames["main"].location.reload();  
										}
									}
									art.dialog.close();
								}
							},false);
							break;
						}
				case 'conti':
						var path = art.dialog.data('homeDemoPath') || './';// 
							art.dialog.open('contiRoomRoomStayAction.action?roomStay.stay_id='+stay_id, {
								id: 'stay_conti_win',
								title: '续住房间界面',
								width:450,
								height:400,
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
										if(retValue=="toConti"){
											window.parent.frames["main"].location.reload();  
										}
									}
									art.dialog.close();
								}
							},false);
							break;
					
			}
		}
		</script>
	</head>
	<body>
		<!-- 如果页面有滚动条，或将来有可能出现滚动条，需要加上此div。*如果没有滚动条加上也无妨 -->
		<div class="div_bk">
			<!-- 标题、功能区域 -->
			<table id="pagehead" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="130"><h1>客房退订</h1></td>
				</tr>
			</table>
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="140">序号</th>
   					<th width="140">顾客姓名</th>
   					<th width="140">房间名称</th>
   					<th width="140">房间价格</th>
   					<th width="140">房间地址</th>
   					<th width="140">入住时间</th>
   					<th width="140">入住天数</th>
   					<th width="140">入住金额</th>
   					<th width="160">操作</th>
   				</tr>
   				<s:iterator value="roomStayList" var="stay" status="st">
   					<tr>
	   					<td align="center"><s:property value="#st.index+1"/></td>
	   					<td align="center"><s:property value="#stay.stay_consuId.consu_name"/></td>
	   					<td align="center"><s:property value="#stay.stay_roomId.room_name"/></td>
	   					<td align="center"><s:property value="#stay.stay_roomId.room_price"/></td>
	   					<td align="center"><s:property value="#stay.stay_roomId.room_site"/></td>
	   					<td align="center"><s:date name="#stay.stay_startDate" format="yyyy-MM-dd"/></td>
	   					<td align="center"><s:property value="#stay.stay_days"/></td>
	   					<td align="center"><s:property value="#stay.stay_money"/></td>
	   					<td align="center">
		   					<a href="javascript:void(0)" onclick="toWindow('conti','<s:property value="#stay.stay_id"/>')" class="edit">续房</a>
		   					<a href="javascript:void(0)" onclick="toWindow('exit','<s:property value="#stay.stay_id"/>','<s:property value="#stay.stay_days"/>')" class="edit">退房</a>
	   					</td>
   					</tr>
   				</s:iterator>
   			</table>
		</div>
	</body>
</html>
