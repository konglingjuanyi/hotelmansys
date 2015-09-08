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
		<script type="text/javascript">
			/**弹出页面处理**/
			function toWindow(type,type_id){
				var path = art.dialog.data('homeDemoPath') || './';// 
				switch(type){
					case 'mod':
						art.dialog.open('modRoomTypeRoomTypeAction.action?roomType.type_id='+type_id, {
							id: 'type_mod_win',
							title: '修改部门界面',
							width:500,
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
									if(retValue=="toMod"){
										window.parent.frames["main"].location.reload();  
									}
								}
								art.dialog.close();
							}
						},false);
						break;
						
						case 'add':
							art.dialog.open('addRoomTypeRoomTypeAction.action', {
								id: 'type_add_win',
								title: '添加类型界面',
								width:500,
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
							
						case 'del':
							var result = confirm("请确认删除吗?");
							if(result==true){
								art.dialog.open('delRoomTypeRoomTypeAction.action?roomType.type_id='+type_id, {
										id: 'type_del_win',
										title: '删除类型界面',
										width:500,
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
												if(retValue=="del"){
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
		<!-- 如果页面有滚动条，或将来有可能出现滚动条，需要加上此div。*如果没有滚动条加上也无妨 -->
		<div class="div_bk">
			<!-- 标题、功能区域 -->
			<table id="pagehead" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="130"><h1>客房管理</h1></td>
				</tr>
			</table>
			<!-- 搜索区 -->
			<form action="listRoomTypeRoomTypeAction.action" method="post" name="roomTypeQueryForm">
				<table class="maintable">
	   				<tr>
	   					<th>客房类型名称</th>
	   					<td colspan="3" ><input type="text" class="text" name="query.rtName" value="<s:property value="query.rtName" />" /></td>
	   				</tr>
	   				<tr align="center">
	   					<td colspan="4" ><input type="submit" value="查询" /></td>
	   				</tr>
	   			</table>
   			</form>
   			<!-- 顶部分页功能区 -->
   			<table class="toptable">
   				<tr>
   					<td>
	   					<a href="javascript:void(0)" class="add" onclick="toWindow('add')">添加</a>
   					</td>
   				</tr>
   			</table>
   			
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="140">序号</th>
   					<th width="140">类型名称</th>
   					<th width="140">示例照片</th>
   					<th width="140">类型状态</th>
   					<th width="160">操作</th>
   				</tr>
   				<s:iterator value="roomTypeList" var="type" status="st">
   					<tr>
	   					<td align="center"><s:property value="#st.index+1"/></td>
	   					<td align="center"><s:property value="#type.type_name"/></td>
	   					<td width="70" align="center">
	   					 	<img width="50px" height="30px" src="<%=path %>/upload/<s:property value="#type.type_photo"/>" alt="" />
	   					</td>
	   					<td align="center" >
	   						<s:if test="#type.type_status==\"1\"">
	   							<strong><font color="green">可用</font></strong>
	   						</s:if>
	   						<s:else>
	   							<strong><font color="red">禁用</font></strong>
	   						</s:else>
	   					</td>
	   					<td align="center">
		   					<a href="javascript:void(0)" onclick="toWindow('mod','<s:property value="#type.type_id"/>')" class="edit">编辑</a>
		   					<a href="javascript:void(0)" onclick="toWindow('del','<s:property value="#type.type_id"/>')" class="delete">删除</a>
	   					</td>
   					</tr>
   				</s:iterator>
   				
   			</table>
   			
		</div>
	</body>
</html>
