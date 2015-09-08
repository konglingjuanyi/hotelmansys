<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <base href="<%=basePath%>">
<title><s:property value="role.role_name"/>分配角色</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resource/select/style/select.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resource/common/jquery-1.8.3.js"></script>
<script type="text/javascript">
//下拉框交换JQuery
$(function(){
    //移到右边
    $('#add').click(function() {
    //获取选中的选项，删除并追加给对方
        $('#unselectedMenus option:selected').appendTo('#selectedMenus');
    });
    //移到左边
    $('#remove').click(function() {
        $('#selectedMenus option:selected').appendTo('#unselectedMenus');
    });
    //全部移到右边
    $('#add_all').click(function() {
        //获取全部的选项,删除并追加给对方
        $('#unselectedMenus option').appendTo('#selectedMenus');
    });
    //全部移到左边
    $('#remove_all').click(function() {
        $('#selectedMenus option').appendTo('#unselectedMenus');
    });
    //双击选项
    $('#unselectedMenus').dblclick(function(){ //绑定双击事件
        //获取全部的选项,删除并追加给对方
        $("option:selected",this).appendTo('#selectedMenus'); //追加给对方
    });
    //双击选项
    $('#selectedMenus').dblclick(function(){
       $("option:selected",this).appendTo('#unselectedMenus');
    });
});

/**提交之前需要使用onsubmit*/
function subMenus(){
	var selectedComs = document.getElementById("selectedMenus");  
	for(var i=0;i<selectedComs.length;i++){  
		selectedComs.options[i].selected = true;  
	}  
	updateMenusForm.submit();
	//art.dialog.close();

}


</script>

</head>

<body>
		<table width="700" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="300" height="40" align="center">未选择</td>
				<td>&nbsp;</td>
				<td width="300" align="center">已选择</td>
			</tr>
		</table>
		<form action="updateMenusByRoleIdRoleAction.action" method="post" name="updateMenusForm" >
		<s:hidden name="role.role_id"/>
		<table width="700" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="300" height="270" align="center" valign="top">
					<s:select name="unselectedMenus" id="unselectedMenus" list="#unselectedMenus" listKey="menu_id" listValue="menu_name" size="10" style="width:200px; border:1px solid #ccc;" multiple="true"/>
				</td>
				<td align="center" valign="top"><table width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td height="35" align="center">
							<input type="button" id="add" value="-->" class="btn1" />
							</td>
						</tr>
						<tr>
							<td height="35" align="center">
							<input type="button" id="add_all" value="->>" class="btn1" /></td>
							</td>
						</tr>
						<tr>
							<td height="35" align="center">
								<input type="button" id="remove" value="<--" class="btn1" /></td>
							</td>
						</tr>
						<tr>
							<td height="35" align="center">
								<input type="button" id="remove_all" value="<<-" class="btn1" /></td>
							</td>
						</tr>
					</table></td>
				<td width="300"  height="270" align="center" valign="top">
					<s:select name="selectedMenus" id="selectedMenus" list="#selectedMenus" listKey="menu_id" listValue="menu_name" size="10" style="width:200px; border:1px solid #ccc;"  multiple="true"/>
				</td>
			</tr>
		</table>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr align="center">
				<td>
					<input type="button" value="更新角色" onclick="subMenus()"/>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		</form>
</body>
</html>