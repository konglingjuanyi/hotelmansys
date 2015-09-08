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
<base target="_self">
<title><s:property value="role.role_name"/>分配角色</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        $('#unselectedRoles option:selected').appendTo('#selectedRoles');
    });
    //移到左边
    $('#remove').click(function() {
        $('#selectedRoles option:selected').appendTo('#unselectedRoles');
    });
    //全部移到右边
    $('#add_all').click(function() {
        //获取全部的选项,删除并追加给对方
        $('#unselectedRoles option').appendTo('#selectedRoles');
    });
    //全部移到左边
    $('#remove_all').click(function() {
        $('#selectedRoles option').appendTo('#unselectedRoles');
    });
    //双击选项
    $('#unselectedRoles').dblclick(function(){ //绑定双击事件
        //获取全部的选项,删除并追加给对方
        $("option:selected",this).appendTo('#selectedRoles'); //追加给对方
    });
    //双击选项
    $('#selectedRoles').dblclick(function(){
       $("option:selected",this).appendTo('#unselectedRoles');
    });
});

/**提交之前需要使用onsubmit*/
function selectAll(){
	var selectedComs = document.getElementById("selectedRoles");  
	for(var i=0;i<selectedComs.length;i++){  
		selectedComs.options[i].selected = true;  
	}  
	return true;  
	/*
	if(selectedComs.length==0){
		alert("请分配模块");
		return false;
	}else{
		
	}*/
}


</script>

</head>

<body>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="350" height="40" align="center">未选择</td>
				<td>&nbsp;</td>
				<td width="350" align="center">已选择</td>
			</tr>
		</table>
		<form action="updateRolesUserAction.action" method="post" name="updateModuleForm" onsubmit="return selectAll()">
		<s:hidden name="user.accountId"/>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="350" height="300" align="center" valign="top">
					<s:select name="unselectedRoles" id="unselectedRoles" list="#unselectedRoles" listKey="role_id" listValue="role_name" size="10" style="width:200px; border:1px solid #ccc;" multiple="true"/>
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
				<td width="350" align="center" valign="top">
					<s:select name="selectedRoles" id="selectedRoles" list="#selectedRoles" listKey="role_id" listValue="role_name" size="10" style="width:200px; border:1px solid #ccc;"  multiple="true"/>
				</td>
			</tr>
		</table>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr align="center">
				<td>
					<input type="submit" value="更新角色"/>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		</form>
</body>
</html>>