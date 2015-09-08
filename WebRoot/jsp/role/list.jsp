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
			function toWindow(type,role_id,status,num){
				var path = art.dialog.data('homeDemoPath') || './';// 
				switch(type){
					case 'menus':
						art.dialog.open('showMenusJspRoleAction.action?role.role_id='+role_id, {
							id: 'user_selected_win',
							title: '选择菜单界面',
							width:800,
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
									if(retValue=="toMenus"){
										window.parent.frames["menu"].location.reload();  
									}
								}
								art.dialog.close();
							}
						},false);
						break;
					case 'add':
						art.dialog.open('addRoleRoleAction.action', {
							id: 'role_add_win',
							title: '添加角色界面',
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
									if(retValue=="add"){
										window.parent.frames["main"].location.reload();  
									}
								}
								art.dialog.close();
							}
						},false);
						break;
					case 'mod':
						art.dialog.open('modRoleRoleAction.action?role.role_id='+role_id, {
							id: 'role_mod_win',
							title: '修改角色界面',
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
									if(retValue=="toMod"){
										window.parent.frames["main"].location.reload();  
									}
								}
								art.dialog.close();
							}
						},false);
						break;
					case 'del':
							if(status=='1'&&num=='0'){
								var result = confirm("请确认删除吗？");
								if(result==true){
									art.dialog.open('delRoleRoleAction.action?role.role_id='+role_id, {
										id: 'role_del_win',
										title: '删除角色界面',
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
												if(retValue=="del"){
													window.parent.frames["main"].location.reload();  
												}
											}
											art.dialog.close();
										}
									},false);
									break;
								}else{
									break;
								}
								
							}else{
								alert("不能删除!");
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
					<td width="130"><h1>角色管理</h1></td>
				</tr>
			</table>
			<!-- 搜索区 -->
			<form action="listRoleAction.action" method="post" name="roleQueryForm">
				<table class="maintable">
	   				<tr>
	   					<th>角色名称</th>
	   					<td colspan="3" ><input type="text" class="text" name="query.roleName" value="<s:property value="query.roleName"/>"/></td>
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
	   					<a href="javascript:void(0)" class="add" onclick="toWindow('add','0','0','0')">添加</a>
   					</td>
   				</tr>
   			</table>
   			
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="100">序号</th>
   					<th width="120">角色名称</th>
   					<th width="120">角色人数</th>
   					<th width="180">角色描述</th>
   					<th width="120">状态</th>
   					<th width="300">操作</th>
   				</tr>
   				<s:iterator value="roleList" var="role" status="st">
   					<tr>
   					<td align="center"><s:property value="#st.index+1"/></td>
   					<td align="center"><s:property value="#role.role_name"/></td>
   					<td align="center">
   						<s:property value="#role.userSet.size()" />人 
   					</td>
   					<td align="center">
   						<s:if test="#role.role_desc.length()>6">
   							<s:property value="#role.role_desc.substring(0,6)" />...
   						</s:if>
   					</td>
   					<td align="center">
   						<s:if test="#role.role_status==\"1\"">
   							<strong><font color="green">激活</font></strong>
   						</s:if>
   						<s:else>
   							<strong><font color="green">禁用</font></strong>
   						</s:else>
   					</td>
   					
   					<td align="center">
	   					<a href="javascript:void(0)" onclick="toWindow('mod','<s:property value="#role.role_id"/>','0','0')" class="edit">编辑</a>
	   					<a href="javascript:void(0)" onclick="toWindow('del','<s:property value="#role.role_id"/>','<s:property value="#role.role_status" />','<s:property value="#role.userSet.size()" />')" class="delete">删除</a>
	   					<a href="javascript:void(0)" onclick="toWindow('menus','<s:property value="#role.role_id"/>','0','0')" class="edit">分配菜单</a>
   					</td>
   				</tr>
   				</s:iterator>
   				
   			</table>
   			
   		
		</div>
	</body>
</html>
