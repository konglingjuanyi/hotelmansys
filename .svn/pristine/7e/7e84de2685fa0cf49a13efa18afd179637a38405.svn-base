<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<title>左侧导航栏[固定]</title>
		<!-- 引入DTree的js文件 -->
		<script type="text/javascript"
			src="<%=path%>/resource/dtree/dtree-ck.compress.js">
</script>

	</head>

	<body>
		<script type="text/javascript">
		/*实例化dTree对象方法参数说明
		 new dTree(objName, rootDir, imgDir);
		 objName：dTree实例对象名称, 
		 rootDir：dTree根目录, 
		 imgDir：图标目录，相对于根目录
		 ./代表是根目录
		 */
		var d = new dTree('d', './resource/dtree/', 'images/menu/');
		
		/*添加节点方法完整参数说明
		 add(id, pid, name, url, title, target, open, icon, iconOpen)
		 id: 节点id（必须唯一，不能重复）, 
		 pid: 父级节点id, 
		 name: 节点名称 ,
		 url: 连接地址,
		 title: 工具提示文本,
		 target: 打开方式/窗口,
		 open: 打开（是：true/否：false）,
		 icon: 节点图标 ,
		 iconOpen: 节点打开时图标
		 */
		 /*
		d.add(0, -1, '系统菜单', "javascript:;", '提示');
		d.add(100, 0, '系统管理', "javascript:;", '所有系统管理功能');
		//以find方法开头都是分页查询
		d.add(500, 100, '用户管理', "findUserAction.action", '用户管理', 'main');
		d.add(600, 100, '角色管理', "listRoleAction.action", '角色管理', 'main');
		d.add(700, 100, '菜单管理', "listMenuAction.action", '菜单管理', 'main');
		d.add(800, 100, '部门管理', "listOrgAction.action", '部门管理', 'main');
		*/
		
		d.add(0, -1, '系统菜单', "javascript:;", '提示');
		
		<s:iterator value="#parentMenuList" var="parent" status="pst">
			d.add(<s:property value="#parent.menu_id"/>, 0, '<s:property value="#parent.menu_name"/>', "javascript:;", '所有系统管理功能');
			<s:iterator value="#nodeMenuList" var="node" status="st">
				<s:if test="#parent.menu_id==#node.parent_id">
				d.add(<s:property value="#node.menu_id"/>, <s:property value="#node.parent_id"/>, '<s:property value="#node.menu_name"/>', '<s:property value="#node.menu_url"/>', '<s:property value="#node.menu_name"/>', 'main');
			
				</s:if>
			</s:iterator>
		</s:iterator>
		
		
	
		document.write(d);
</script>


	</body>
</html>