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
				loggerForm.submit();
			}
			
		</script>
		
	</head>
	<body>
		<!-- 如果页面有滚动条，或将来有可能出现滚动条，需要加上此div。*如果没有滚动条加上也无妨 -->
		<div class="div_bk">
			<!-- 标题、功能区域 -->
			<table id="pagehead" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="130"><h1>登录日志查询</h1></td>
				</tr>
			</table>
			<!-- 搜索区 -->
			<form action="findLoggerLoginAction.action" method="post" name="loggerForm">
				<!-- 赋值隐藏域 -->
				<!-- 赋值当前页数 【模型驱动】-->
				<s:hidden name="pageBean.offset" id="page_now"/>
				<s:hidden name="pageBean.size"/>
   			</form>
   			
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="100">序号</th>
   					<th width="120">帐号</th>
   					<th width="120">姓名</th>
   					<th width="120">登录ip</th>
   					<th width="120">登录时间</th>
   					<th width="300">登出时间</th>
   				</tr>
   				<s:iterator value="pageBean.datas" var="logger" status="st">
   				<tr>
   					<td align="center"><s:property value="#st.index+1"/></td>
   					<td align="center"><s:property value="#logger.account"/></td>
   					<td align="center"><s:property value="#logger.userName"/></td>
   					<td align="center"><s:property value="#logger.ipAddress"/></td>
   					<td align="center"><s:date name="#logger.loginTime" format="yyyy-MM-dd hh:mm:ss" /></td>
   					<td align="center"><s:date name="#logger.loginOutTime" format="yyyy-MM-dd hh:mm:ss" /></td>
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
