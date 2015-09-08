<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exitStay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
	<script src="<%=path %>/resource/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function validate(){
			if($("#quit_date").val()==""){
				$("#a").html("请选择时间!");
				return false;
			}
			if($("#quit_date").val()>=$("#prep_id").val()){
				$("#a").html("时间冲突!");
				return false;
			}
		}
		
	</script>
  </head>
  
  <body><center>
    <form action="toContiRoomStayAction.action" method="post" onsubmit="return validate()" name="myForm">
    	<input type="hidden" name="roomStay.stay_id" value='<s:property value="#roomStay.stay_id" />' />
    	<label><font color="green"><b>续住房间</b></font></label><br/><br />
    	<s:iterator value="#list" var="l">
    		<input id="prep_id" value='<s:date name="#l.stay_startDate" format="yyyy-MM-dd" />' type="hidden" />
    		<font color="green"><b>该房间有预定,日期为:<s:date name="#l.stay_startDate" format="yyyy-MM-dd" /><b></font>
    	</s:iterator>
    	<br /><br />
    	<table>
	    	<tr>
	    		<th>入住时间：</th>
	    		<td><input id="start_date" value='<s:property value="#roomStay.stay_startDate" />' class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d}'})" disabled="disabled" /></td>
	    	</tr>
	    	<tr>
	    		<th>离开时间:</th>
	    		<td><input id="quit_date" name="roomStay.stay_quitDate" class="Wdate" type="text" onfocus="WdatePicker({minDate:'%y-%M-{%d+<s:property value="#roomStay.stay_days" />}'})" /></td>
	    	</tr>
	    	<tr>
	    		<td id="a">&nbsp;</td>
	    		<td><input value="提交" type="submit" /></td>
	    	</tr>
    	</table>
    </form></center>
  </body>
</html>
