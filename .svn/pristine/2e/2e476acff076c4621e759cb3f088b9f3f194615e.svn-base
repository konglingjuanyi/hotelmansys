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
			function toWindow(type,vip_id){
				var path = art.dialog.data('homeDemoPath') || './';// 
				switch(type){
					case 'mod':
						art.dialog.open('modVipCardVipCardAction.action?vipCard.vip_id='+vip_id, {
							id: 'org_mod_win',
							title: '修改会员卡界面',
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
						
						case 'add':
							art.dialog.open('addVipCardVipCardAction.action', {
								id: 'vip_add_win',
								title: '添加部门界面',
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
							
						case 'del':
							var result = confirm("请确认删除吗？");
							if(result==true){
								art.dialog.open('delVipCardVipCardAction.action?vipCard.vip_id='+vip_id, {
										id: 'vip_del_win',
										title: '删除会员卡界面',
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
					<td width="130"><h1>会员卡管理</h1></td>
				</tr>
			</table>
			<!-- 搜索区 -->
			<form action="listVipCardVipCardAction.action" method="post" name="vipCardQueryForm">
				<table class="maintable">
	   				<tr>
	   					<th>部门名称</th>
	   					<td colspan="3" ><input type="text" class="text" name="query.vipCardName" value="<s:property value="query.vipCardName" />" /></td>
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
   					<th width="140">会员卡名称</th>
   					<th width="140">会员卡折扣率</th>
   					<th width="140">操作</th>
   				</tr>
   				<s:iterator value="vipCardList" var="vip" status="st">
   					<tr>
   					<td align="center"><s:property value="#st.index+1"/></td>
   					<td align="center"><s:property value="#vip.vip_name"/></td>
   					<td align="center"><s:property value="#vip.vip_discount"/></td>
   					<td align="center">
	   					<a href="javascript:void(0)" onclick="toWindow('mod','<s:property value="#vip.vip_id"/>')" class="edit">编辑</a>
	   					<a href="javascript:void(0)" onclick="toWindow('del','<s:property value="#vip.vip_id"/>')" class="delete">删除</a>
   					</td>
   				</tr>
   				</s:iterator>
   			</table>
		</div>
	</body>
</html>
