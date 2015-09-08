<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
#all {margin-left:auto; margin-right:auto; text-align: center;width: 540px;}
body {text-align:center;}
#main {background:url(resource/images/login_mid.gif); height:240px; text-align:center;}
#title {height:66px;margin-top: 120px;}
#login { margin-top: 32px; width: 420px; margin-left: auto; margin-right:auto;}
#btm_left {background:url(resource/images/login_btm_left.gif) no-repeat; width:21px; float:left;}
#btm_mid {background:url(resource/images/login_btm_mid.gif); width:498px; float:left;}
#btm_right {background:url(resource/images/login_btm_right.gif) no-repeat; width:21px; float:left;}
body{background-color: #EBEBEB;}
</style>
<script type="text/javascript" language="javascript">

function reset_form()
{
	document.getElementById('account').value = '';
	document.getElementById('password').value = '';
	return false;
}
					 
</script>
</head>

<body>
<div id="all">
    <div id="title"><img src="resource/images/login_title.gif" /></div>
    <div id="main">
    	<form action="loginLoginAction.action" method="post" id="login_form">
        <table id="login">
        	<tr>
            	<td><font face="微软雅黑"><b>用 户 名:</b></font></td>
                <td><input type="text" name="user.account" id="account" size="32" style="background:url(resource/images/username_bg.gif) left no-repeat #FFF; border:1px #ccc solid;height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" /></td>
            </tr>
            <tr><td></td><td></td></tr>
            <tr><td></td><td></td></tr>
            <tr>
            	<td><font face="微软雅黑"><b>密 &nbsp;&nbsp;&nbsp;&nbsp;码:</b></font></td>
                <td><input type="password" name="user.password" id="password" size="32" style="background:url(resource/images/password_bg.gif) left no-repeat #FFF; border: 1px #ccc solid; height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" /></td>
            </tr>
            <tr>
            	<td></td>
            	<td style="text-align: left; padding-top: 32px;">
                	<img src="resource/images/login.gif"  onclick="javascript:document.getElementById('login_form').submit();" />&nbsp;&nbsp;&nbsp;
                    <img type="image" src="resource/images/cancel.gif" onclick="reset_form();" />
                </td>
            </tr>
        </table>
    </div>
    <div id="btm">
        <div id="btm_left"></div>
        <div id="btm_mid"></div>
        <div id="btm_right"></div>
    </div>
</div>
</body>
</html>