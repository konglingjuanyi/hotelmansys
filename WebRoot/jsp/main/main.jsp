<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<base href="<%=basePath%>">
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
			}
			html, body { height:100%; border:none 0; overflow:hidden}
			#iframe { width:100%; height:100%; border:none 0; }
		</style>
		
		</style>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台框架模板</title>
		<script src="<%=path %>/resource/artDialog4.1.7/artDialog.source.js?skin=default"></script>
		<script src="<%=path %>/resource/artDialog4.1.7/plugins/iframeTools.source.js"></script>
	</head>

	<body >
		
		<iframe id="iframe" src="<%=path %>/jsp/main/frameset.jsp" frameborder="0" ></iframe>
	</body>
</html>