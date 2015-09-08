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
		<title>头部导航信息</title>
		<style type="text/css">
body {
	background: #A2B5CD;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	margin: 0px;
	margin-bottom: 2px;
	border-bottom: 1px #ccc solid;
}

h1 {
	color: #FFF;
}

a {
	color: #FFF;
	text-decoration: none; /*防止滤镜下链接失效*/
	position: relative;
}

ul {
	list-style: none;
}

#all {
	width: 100%;
}

#banner {
	margin-top: 8px;
	margin-left: 32px;
}

#main {
	width: 100%;
	margin-bottom: 2px;
	background: #eeeeee;
	margin-left: 0px;
	margin-right: 0px;
	height: 30px;
	color: #000;
	line-height: 2.4;
	overflow: auto;
}

#main a {
	color: #000;
}

#welcome {
	float: left;
	width: 40%;
	font-weight: 800;
	padding-left: 8px;
	position: relative;
}

#adminop {
	float: left;
	width: 59%;
	position: relative;
	text-align: right;
	line-height: 1; *
	line-height: 2.2;
}

#adminop ul li {
	float: right;
	width: 80px;
}

#nav {
	width: 100%;
	clear: both;
}

#nav ul li {
	float: right;
	width: 82px;
	height: 25px;
	line-height: 2.1;
	text-align: center;
}

.inactive {
	background-image /**/: url(../../resource/images/admin/nav_bg_inactive2.png) !important
		;
	background: none;
	margin-left: 2px;
	margin-right: 2px;
	filter: progid : DXImageTransform.Microsoft.AlphaImageLoader ( src =
		../../resource/images/ admin/ nav_bg_inactive2.png );
}

.inactive a {
	color: #000;
}

.active {
	background: url(../../resource/images/admin/nav_bg_active2.png) !important;
	background: none;
	margin-left: 2px;
	margin-right: 2px;
	filter: progid : DXImageTransform.Microsoft.AlphaImageLoader ( src =
		../../resource/images/ admin/ nav_bg_active2.png );
}

.active a {
	color: #fff;
}

.blankgray {
	background: #bbb;
	height: 2px;
	width: 100%;
	margin: 0;
	padding: 0;
	clear: both;
	font-size: 2px;
}
</style>
		<script type="text/javascript" language="javascript"
			src="<%=path %>/resource/common/jquery-1.8.3.js">
</script>
		<script type="text/javascript">
var oplist = new Array('about', 'user', 'news', 'mars', 'jielong', 'box',
		'school', 'config', 'other');
$(document).ready(function() {
	$('#nav').find("a").click(function() {
		var id = $(this).attr('id');
		$.each(oplist, function(i, n) {
			$('#' + n).attr('class', 'inactive');
		});
		$(this).parents("li").attr('class', 'active');
	});
});
</script>
	</head>

	<body>
		<div id="all">
			<div id="banner">
				<h1>
					如家宾馆管理系统
				</h1>
			</div>
			<!--  
			<div id="nav">
				<ul>
					<li class="inactive" id="other">
						<a href="menu.html" target="menu">管理操作</a>
					</li>
					<li class="inactive" id="about">
						<a href="menu.html" target="menu">管理操作</a>
					</li>
					<li class="inactive" id="user">
						<a href="menu.html" target="menu">管理操作</a>
					</li>
					<li class="inactive" id="news">
						<a href="menu.html" target="menu">管理操作</a>
					</li>
					<li class="inactive" id="mars">
						<a href="menu.html" target="menu">管理操作</a>
					</li>
					<li class="inactive" id="jielong">
						<a href="menu.html" target="menu">管理操作</a>
					</li>
					<li class="inactive" id="box">
						<a href="menu.html" target="menu">管理操作</a>
					</li>
					<li class="inactive" id="school">
						<a href="menu.html" target="menu">火柴学堂</a>
					</li>
					<li class="active" id="config">
						<a href="menu.html" target="menu">站点设置</a>
					</li>
				</ul>
			</div>
			-->
			<div id="main">
				<div id="welcome">
					欢迎你回来,Admin!
					<img src="resource/images/clock.gif" />
					现在时间: <%=new Date().toLocaleString() %>
				</div>
				<div id="adminop">
					<ul>
						<li>
							<a href="javascript:top.location='exitExitAction.action'">退出管理</a>
						</li>
						<li>
							<a href="<%=path %>/jsp/main/content.jsp" target="main">站点首页</a>
						</li>
						<li>
							<a href="javascript:window.parent.location.reload();">刷新</a>
						</li>
						<li>
							<a href="javascript:history.go(-1);">后退</a>
						</li>
						<li>
							<a href="javascript:history.go(1);">前进</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>

