<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>后台框架模板</title>
	</head>

	<frameset cols="*" rows="136, *" id="frame_main" border="0">
		<frame src="<%=path %>/jsp/main/header.jsp" noresize="noresize" name="header">

		<frameset cols="240, *">
			<frame src="<%=path %>/showNavMenuAction.action" name="menu" />
			<frame src="<%=path %>/jsp/main/content.jsp" name="main">
		</frameset>
	</frameset>

	<noframes>
		<body>
		</body>
	</noframes>
</html>