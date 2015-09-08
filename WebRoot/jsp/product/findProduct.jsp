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
				productQueryForm.submit();
			}
			
		</script>
		<script type="text/javascript">
			/**弹出页面处理**/
			function toWindow(type,product_id){
				var path = art.dialog.data('homeDemoPath') || './';// 
				switch(type){
					case 'mod':
						art.dialog.open('modProductProductAction.action?product.pro_id='+product_id, {
							id: 'product_mod_win',
							title: '修改商品界面',
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
							art.dialog.open('addProductProductAction.action', {
								id: 'product_add_win',
								title: '添加类型界面',
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
							var result = confirm("请确认删除吗?");
							if(result==true){
								art.dialog.open('delProductProductAction.action?product.pro_id='+product_id, {
										id: 'product_del_win',
										title: '删除类型界面',
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
					<td width="130"><h1>商品管理</h1></td>
				</tr>
			</table>
			<!-- 搜索区 -->
			<form action="findProductProductAction.action" method="post" name="productQueryForm">
				<!-- 赋值隐藏域 -->
				<!-- 赋值当前页数 【模型驱动】-->
				<s:hidden name="pageBean.offset" id="page_now"/>
				<s:hidden name="pageBean.size"/>
				<table class="maintable">
	   				<tr>
	   					<th>商品名称</th>
	   					<td colspan="3"><input type="text" class="text" name="query.proName" value="<s:property value="query.proName" />" /></td>
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
   					<th width="140">商品名称</th>
   					<th width="140">商品类型</th>
   					<th width="140">商品进价</th>
   					<th width="140">商品卖价</th>
   					<th width="140">商品库存</th>
   					<th width="100">商品单位</th>
   					<th width="140">商品生产日期</th>
   					<th width="140">商品过期日期</th>
   					<th width="180">操作</th>
   				</tr>
   				<s:iterator value="pageBean.datas" var="product" status="st">
   					<tr>
	   					<td align="center"><s:property value="#st.index+1"/></td>
	   					<td align="center"><s:property value="#product.pro_name"/></td>
	   					<td align="center"><s:property value="#product.pro_typeId.type_name"/></td>
	   					<td align="center"><s:property value="#product.pro_inprice"/></td>
	   					<td align="center"><s:property value="#product.pro_price"/></td>
	   					<td align="center"><s:property value="#product.pro_store"/></td>
	   					<td align="center"><s:property value="#product.pro_unit"/></td>
	   					<td align="center"><s:date name="#product.pro_startDate" format="yyyy-MM-dd"/></td>
	   					<td align="center"><s:date name="#product.pro_endDate" format="yyyy-MM-dd"/></td>
	   					<td align="center">
		   					<a href="javascript:void(0)" onclick="toWindow('mod','<s:property value="#product.pro_id"/>')" class="edit">编辑</a>
		   					<a href="javascript:void(0)" onclick="toWindow('del','<s:property value="#product.pro_id"/>')" class="delete">删除</a>
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
