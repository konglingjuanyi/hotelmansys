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
				userQueryForm.submit();
			}
			
		</script>
		<script type="text/javascript">	
			/**弹出页面处理**/
			function toWin(type,user_id,num){
				switch(type){
						
					case 'role':
						var options = new Object();
						options.width="800px";
						options.height="400px";
						options.url ="showRoleJSPUserAction.action?user.accountId="+user_id;
						var objectReturn = openModelPage(options);
						break;
				
					case 'add':
						var options = new Object();
						options.width="900px";
						options.height="600px";
						options.url ="addUserUserAction.action";
						var objectReturn = openModelPage(options);
						break;
					case 'mod':
						var options = new Object();
						options.width = "900px";
						options.height = "600px";
						options.url = "modUserUserAction.action?user.accountId="+user_id;
						var objectReturn = openModelPage(options);
						break;
						
					case 'del':
						var path = art.dialog.data('homeDemoPaht') || './';
						//alert(num=='0');
						if(num=='0'){
							
						}else{
							alert("不能删除!");
							return 0;
						}
						var result = confirm("确认删除吗?");
						if(result==true){
							art.dialog.open('delUserUserAction.action?user.accountId='+user_id,{
								id:'user_del_win',
								title:'删除用户',
								width:600,
								height:300,
								lock:true,
								fixed:true,
								resize:false,
								init:function(){
									var iframe = this.iframe.contentWindow;
									var top = art.dialog.top;
								},
								close:function(){
									var retValue = art.dialog.data('retValue');
									if(retValue!=undefined){
										if(retValue=='del'){
											window.parent.frames["main"].location.reload();
										}
									}
								}
							},false);
							break;
					   }
				}
				
				if(objectReturn.flag=='toRole'){
					window.parent.frames["menu"].location.reload(); 
					window.location="findUserAction.action";  
					return false;
				};
				if(objectReturn.flag=='add'){
					window.parent.frames["main"].location.reload();  
					return false;
				};
				if(objectReturn.flag=='toMod'){
					window.parent.frames["main"].location.reload();
					return false;
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
			<form action="findUserAction.action" method="post" name="userQueryForm">
				<!-- 赋值隐藏域 -->
				<!-- 赋值当前页数 【模型驱动】-->
				<s:hidden name="pageBean.offset" id="page_now"/>
				<s:hidden name="pageBean.size"/>
				<table class="maintable">
	   				<tr>
	   					<th>姓名</th>
	   					<td colspan="3" ><input type="text" class="text" name="query.userName" value="<s:property value="query.userName"/>"/></td>
	   				</tr>
	   				<tr align="center">
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
   					<th width="120">帐号</th>
   					<th width="120">性别</th>
   					<th width="120">联系电话</th>
   					<th width="120">部门</th>
   					<th width="120">角色数</th>
   					<th width="300">操作</th>
   				</tr>
   				<s:iterator value="pageBean.datas" var="user" status="st">
   					<tr>
   					<td align="center"><s:property value="#st.index+1"/></td>
   					<td align="center"><s:property value="#user.userName"/></td>
   					<td align="center"><s:property value="#user.account"/></td>
   					<td align="center">
   						<s:if test="%{#user.sex==\"1\"}">
   							男
   						</s:if>
   						<s:else>
   							女
   						</s:else>
   					</td>
   					<td align="center"><s:property value="#user.telphone" default="暂无"/></td>
   					<td align="center"><s:property value="#user.org.org_name" default="暂无"/></td>
   					<td align="center"><s:property value="#user.roleSet.size()"/></td>
   					<td align="center">
	   					<a href="javascript:void(0)" onclick="toWin('mod','<s:property value="#user.accountId"/>','0')" class="edit">编辑</a>
	   					<a href="javascript:void(0)" onclick="toWin('del','<s:property value="#user.accountId"/>','<s:property value="#user.roleSet.size()"/>')" class="delete">删除</a>
	   					<a href="javascript:void(0)" onclick="toWin('role','<s:property value="#user.accountId"/>','0')" class="edit">分配角色</a>
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
