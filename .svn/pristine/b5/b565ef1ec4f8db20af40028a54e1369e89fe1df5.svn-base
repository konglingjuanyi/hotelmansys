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
			function toPage(type){
				//当前页
				var pageNow = '<s:property value="pageBean.offset"/>';
				//总页数
				var totalPages = '<s:property value="pageBean.totalPages"/>';
				//去一下隐藏域中赋值
				var page_now = document.getElementById("page_now");
				if(type=='1'||type=='s'){
					page_now.value="1";
				}
				if(type=='2'){
					page_now.value=parseInt(pageNow)-1;
				}
				if(type=='3'){
					page_now.value=parseInt(pageNow)+1;
				}
				if(type=='4'){
					page_now.value=totalPages;
				}
				
				//手动提交表单
				consuQueryForm.submit();
			}
			
		</script>
		<script type="text/javascript">	
			/**弹出页面处理**/
			function toWin(type,consu_id,consu_status){
				switch(type){
					case 'mod':
						art.dialog.open('modConsuConsumerAction.action?consumer.consu_id='+consu_id, {
							id: 'consu_mod_win',
							title: '修改顾客界面',
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
									if(retValue=="toMod"){
										window.parent.frames["main"].location.reload();  
									}
								}
								art.dialog.close();
							}
						},false);
						break;
						
						case 'add':
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
							
						case 'del':
							if(consu_status=='2'){
								alert("该顾客已删除!");
								break;
							}
							var result = confirm("请确认删除吗?");
							if(result==true){
								art.dialog.open('delConsuConsumerAction.action?consumer.consu_id='+consu_id, {
										id: 'consu_del_win',
										title: '删除顾客界面',
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
					<td width="130"><h1>用户管理</h1></td>
				</tr>
			</table>
			<!-- 搜索区 -->
			<form action="findConsuConsumerAction.action" method="post" name="consuQueryForm">
				<!-- 赋值隐藏域 -->
				<!-- 赋值当前页数 【模型驱动】-->
				<s:hidden name="pageBean.offset" id="page_now"/>
				<s:hidden name="pageBean.size"/>
				<table class="maintable">
	   				<tr>
	   					<th>姓名</th>
	   					<td colspan="3" ><input type="text" class="text" name="query.consuName" value="<s:property value="query.consuName"/>"/></td>
	   					<th>会员卡</th>
	   					<td colspan="3" ><input type="text" class="text" name="query.vipName" value="<s:property value="query.vipName"/>"/></td>
	   				</tr>
	   				<tr align="center">
	   					<td colspan="4" >&nbsp;</td>
	   					<td colspan="4" ><input type="button" value="查询" onclick="toPage('s')"/></td>
	   				</tr>
	   			</table>
   			</form>
   			<!-- 顶部分页功能区 -->
   			<table class="toptable">
   				<tr>
   					<td>
	   					<a href="javascript:void(0)" class="add" onclick="toWin('add')">添加</a>
   					</td>
   				</tr>
   			</table>
   			
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="100">序号</th>
   					<th width="120">姓名</th>
   					<th width="140">电话</th>
   					<th width="140">身份证</th>
   					<th width="120">会员卡</th>
   					<th width="140">会员留言</th>
   					<th width="120">状态</th>
   					<th width="200">操作</th>
   				</tr>
   				<s:iterator value="pageBean.datas" var="consu" status="st">
   					<tr>
   					<td align="center"><s:property value="#st.index+1"/></td>
   					<td align="center"><s:property value="#consu.consu_name"/></td>
   					<td align="center"><s:property value="#consu.consu_telphone"/></td>
   					<td align="center"><s:property value="#consu.consu_identify"/></td>
   					<td align="center"><s:property value="#consu.consu_vipId.vip_name"/></td>
   					<td align="center"><s:property value="#consu.consu_say" default="暂无"/></td>
   					<td align="center" >
	   					<s:if test="#consu.consu_status==\"1\"">
	   							<strong><font color="green">正常</font></strong>
	   						</s:if>
	   						<s:else><strong><font color="red">黑名单</font></strong></s:else>
	   					</td>
   					<td align="center">
	   					<a href="javascript:void(0)" onclick="toWin('mod','<s:property value="#consu.consu_id"/>')" class="edit">编辑</a>
	   					<a href="javascript:void(0)" onclick="toWin('del','<s:property value="#consu.consu_id"/>','<s:property value="#consu.consu_status"/>')" class="delete">删除</a>
   					</td>
   				</tr>
   				</s:iterator>
   			</table>
   			
   			<!-- 底部分页功能区 -->
   			<table class="btmtable">
   				<tr>
   					<td>
						&nbsp;&nbsp;共有 <s:property value="pageBean.total"/> 条记录，当前第 <s:property value="pageBean.offset"/>/<s:property value="pageBean.totalPages"/> 页
   						&nbsp;&nbsp;&nbsp;&nbsp;
   						<s:if test="pageBean.offset==1">
   							首页
   						</s:if>
   						<s:else>
   							<a href="javascript:void(0)" onclick="toPage('1')">首页</a>&nbsp;&nbsp;
   						</s:else>
						<s:if test="pageBean.offset==1">
							上一页&nbsp;&nbsp;
						</s:if>
						<s:else>
							<a href="javascript:void(0)" onclick="toPage('2')">上一页</a>&nbsp;&nbsp;
						</s:else>
						<s:if test="pageBean.totalPages==pageBean.offset">
							下一页&nbsp;&nbsp;
						</s:if>
						<s:else>
							<a href="javascript:void(0)" onclick="toPage('3')">下一页</a>&nbsp;&nbsp;
						</s:else>
						<s:if test="pageBean.offset < pageBean.totalPages">
							<a href="javascript:void(0)" onclick="toPage('4')">尾页</a>&nbsp;&nbsp;
						</s:if>
						<s:else>
							尾页&nbsp;&nbsp;
						</s:else>
						
   					</td>
   				</tr>
   			</table>
		</div>
	</body>
</html>
