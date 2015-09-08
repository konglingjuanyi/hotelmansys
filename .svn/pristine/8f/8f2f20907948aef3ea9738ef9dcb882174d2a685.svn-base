<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addOrg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/resource/common/validate.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/upload.js"></script>
	<style type="text/css">
		tr { height: 50px;}
	</style>
	<script type="text/javascript">
		var msg = false;
		//验证账号是否存在
		function toJSONAjax(){
			
  			var roomType_name = $("#roomType_name").attr("value");
  			var roomType_id = '<s:property value="%{#roomType.type_id}" />';
  			//JSON不能使用模型驱动
  			//解决办法
  			var params = "roomType_name="+roomType_name+"&roomType.type_id="+roomType_id;
  			$.ajax({
  				type:"post",
  				url :"modRoomTypeJsonJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#roomType_name_id").html("<font color='red' size='-1'>&otimes;名称已经存在！</font>");
  						msg = false;
  					}else{
  						$("#roomType_name_id").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  			});
  		}
		function nameBlur(){
			if($("#roomType_name").attr("value")==""||$("#roomType_name").attr("value")==null){
				$("#roomType_name_id").html("<font color='red'><b>类型名称不能为空!</b></font>");
				return false;
			}
			toJSONAjax();
			if(!msg){
				return false;
			}
			return true;
		}
		function validate(){
			var imgHeadPhoto = document.getElementById("imgHeadPhoto");
			var photoExist = document.getElementById("photoExist");
			if(imgHeadPhoto.src == ""||imgHeadPhoto.src==null){
				photoExist.innerHTML="<font color='red' >&otimes;请选择照片！！！</font>";
				return false;
			}else{
				photoExist.innerHTML="";
				return nameBlur();
			}
		}
		
		
	</script>
  </head>
  
  <body>
    <form action="toModRoomTypeAction.action?roomType.type_id=<s:property value="#roomType.type_id" />" method="post" onsubmit="return validate()" enctype="multipart/form-data">
    	<center>
	    	<table cellpadding="0" cellspacing="0" width="90%">
	    		<thead>
	    			<tr align="center">
	    				<td colspan="3"><font color="green" size="4px"><b>修改类型</b></font></td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td>类型名称:</td>
	    				<td><input type="text" value='<s:property value="#roomType.type_name" />' name="roomType.type_name" id="roomType_name" onblur="nameBlur()" /></td>
	    				<td width="150px" id="roomType_name_id">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>类型状态:</td>
	    				<td>
	    					<s:radio list="#{'1':'可用','2':'布置'}" name="roomType.type_status" value="%{#roomType.type_status}" ></s:radio>
	    				</td>
	    				<td width="150px">&nbsp;</td>
	    			</tr>
	    			<tr>
	    				<td>照片示例:</td>
	    				<td>
	    					<div id="divPreview" >
		    					<img id="imgHeadPhoto" style="width: 160px; height: 170px;" alt="无" src="<%=path %>/upload/<s:property value="#roomType.type_photo" />" />
		    				</div>
		    			</td>
	    				<td>&nbsp;</td>
	    			</tr>
	    			<tr>
		    			<td colspan="2">
	   						<input type="file" size="15px" name="photo" onchange="PreviewImage(this,'imgHeadPhoto','divPreview');" />
	   					</td>
	   					<td id="photoExist" width="150px">&nbsp;</td>
   					</tr> 
	    		</tbody>
	    	</table>
	    	<br /><br />
	    	<input type="submit" value="提   交" />
    	</center>
    </form>
  </body>
</html>
