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
    
    <title>My JSP 'userAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/resource/common/upload.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/validate.js"></script>
	<script type="text/javascript" src="<%=path %>/resource/common/jquery-1.8.3.min.js"></script>
	<style type="text/css">
		tr { height: 50px;}
	</style>
	<script type="text/javascript">
		var msg = false;
		//用户账号验证
		function accountBlur(){
			var account = document.getElementById("account").value;
			var accountId = document.getElementById("accountId");
			if(account==""||account==null){
				accountId.innerHTML="<font color='red' size='-1'>&otimes;用户名不能为空</font>";
				return false;
			}
			if(!isRegisterUserName(account)){
				accountId.innerHTML="<font color='red' size='-2'>&otimes;用户名由数字、字母、下划线组成，字母开头，长度6-16之间</font>";
				return false;
			}		
			toJSONAjax();//验证账号是否存在			
			if(!msg){
				return false;
			}
			//accountId.innerHTML="<font color='green'>&radic;用户名正确</font>";//ajax验证存在还是可用
			return true;
		}
		function accountFocus(){
			document.getElementById("accountId").innerHTML="<font color='green' size='-2'>用户名由数字、字母、下划线组成，字母开头，长度6-16之间</font>";		
		}
		
		//身份证验证
		function idenFocus(){
			document.getElementById("identityId").innerHTML="";
		}
		function idenBlur(){
			var iden = document.getElementById("identity");
			var idenId = document.getElementById("identityId");
			if(iden.value==""||iden.value==null){
				idenId.innerHTML="<font color='red' size='-1'>&otimes;身份证号不能为空！</font>";
				return false;
			}		
			if((checkIdcard(iden.value)==true)){		
				return true;
			}else{
				var result = checkIdcard(iden.value);
				idenId.innerHTML="<font color='red' size='-1'>"+result+"</font>";//字符串拼接
				return false;
			}
			document.getElementById("identityId").innerHTML="<font color='green' size='-1'>&radic;</font>";
			return true;
		}
		
		//提交时防止出现两次中强弱提示
		function pswBlur_1(){
			var psw = document.getElementById("password");
			var pswId = document.getElementById("passwordId");
			if(psw.value==""||psw.value==null){
				pswId.innerHTML="<font color='red' size='-1'>&otimes;密码不能为空！！！</font>";
				return false;
			}
			if(psw.value.length<6||psw.value.length>15){
					pswId.innerHTML="<font color='red' size='-1'>&otimes;密码不能少于6位，最多不能超过15位</font>";
					return false;
			}
			return true;
		}
		//密码验证
		function pswFocus(){
			var psw = document.getElementById("passwordId");
			psw.innerHTML="";
		}
		function pswBlur(){
			var psw = document.getElementById("password");
			var pswId = document.getElementById("passwordId");
			if(psw.value==""||psw.value==null){
				pswId.innerHTML="<font color='red' size='-1'>&otimes;密码不能为空！！！</font>";
				return false;
			}
			if(psw.value.length<6||psw.value.length>15){
					pswId.innerHTML="<font color='red' size='-1'>&otimes;密码不能少于6位，最多不能超过15位</font>";
					return false;
			}else {
				var table = document.createElement("table");
				table.width="120px";
				table.cellSpacing="0";
				var tr = document.createElement("tr");
				var td1 = document.createElement("td");
				var td2 = document.createElement("td");
				var td3 = document.createElement("td");	
				td1.width="20px";
				td2.width="20px";
				td3.width="20px";
				td1.bgColor="#FFEC8B";
				td2.bgColor="#FFC125";
				td3.bgColor="#FF7F00";				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				table.appendChild(tr);
				pswId.appendChild(table);
				
				if(psw.value.length<=8){			
					td1.innerHTML="<font><center>弱</center></font>";
					return true;
				}
				if(psw.value.length>8&&psw.value.length<=12){
					td2.innerHTML="<font><center>中</center></font>";
					return true;
				}
				if(psw.value.length>12&&psw.value.length<=15){
					td3.innerHTML="<font><center>强</center></font>";
					return true;
				}
			} 							
			return true;
		}
		//邮箱验证
		function mailFocus(){
			document.getElementById("mailId").innerHTML="";
		}
		function mailBlur(){
			var mail = document.getElementById("mail");
			var mailId = document.getElementById("mailId");
			if(mail.value==""||mail.value==null){
				mailId.innerHTML="<font color='red' size='-1'>&nbsp;&otimes;邮箱不能为空!!!</font>"
				return false;
			}					
			if(!(mail.value).validateEmail()){
				mailId.innerHTML="<font color='red' size='-1'>&nbsp;&otimes;邮箱格式不正确!!!</font>";
				return false;
			}	
			mailId.innerHTML = "<font color='green'>&radic;</font>";
			return true;
		}
		//确认密码验证
		function pswQFocus(){
			document.getElementById("password1Id").innerHTML="";
		}
		function pswQBlur(){
			var psw = document.getElementById("password");
			var pswQ = document.getElementById("password1");
			var pswQId = document.getElementById("password1Id");
			if(psw.value==""||psw.value==null){
				pswQId.innerHTML = "<font color='red' size='-1'>&otimes;确认密码不能为空！！！</font>";
				return false;
			}
			if(pswQ.value != psw.value){
				pswQId.innerHTML = "<font color='red' size='-1'>&otimes;确认密码不正确！！！</font>";
				return false;
			}
			pswQId.innerHTML = "<font color='green'>&radic;</font>";
			return true;
		}
		//电话验证
		function phoneFocus(){
			document.getElementById("phoneId").innerHTML="";
		}
		function phoneBlur(){
			var phone = document.getElementById("phone");
			var phoneId = document.getElementById("phoneId");
			if(phone.value==""||phone.value==null){
				phoneId.innerHTML="<font color='red' size='-1'>&otimes;电话不能为空！！！</font>";
				return false;
			}
			if(!(phone.value.isMobile())){
				phoneId.innerHTML="<font color='red' size='-1'>&otimes;电话号码不正确！！！</font>";
				return false;
			}
			phoneId.innerHTML="<font color='green' size='-1'>&radic;</font>";
			return true;
		}
		//姓名验证
		function userNameFocus(){
			document.getElementById("userNameId").innerHTML="";
		}
		function userNameBlur(){
			var userName = document.getElementById("userName");
			var userNameId = document.getElementById("userNameId");
			if(userName.value==""||userName.value==null){
				userNameId.innerHTML="<font color='red' size='-1'>&otimes;姓名不能为空！！！</font>";
				return false;
			}
			if(!(userName.value.isChinese())){
				userNameId.innerHTML="<font color='red' size='-1'>&otimes;姓名只能为汉字！！！</font>";
				return false;
			}
			userNameId.innerHTML="<font color='green' size='-1'>&radic;</font>";
			return true;
		}
		function telFocus(){
			var telId = document.getElementById("telphoneId");
			telId.innerHTML="";
		}
		function telBlur(){
			var tel = document.getElementById("telphone");
			var telId = document.getElementById("telphoneId");
			
			if(tel.value==""||tel.value==null){
				telId.innerHTML="<font color='red' size='-1'>&otimes;手机号码不能为空！</font>";
				return false;
			}
			if(!tel.value.isTel){
				telId.innerHTML="<font color='red' size='-1'>&otimes;手机号码不正确！</font>";
				return false;
			}
			telId.innerHTML="<font color='green' size='-1'>&radic;</font>";
			return true;
		}
		//验证账号是否存在
		function toJSONAjax(){
			
  			var account = $("#account").val();
  			//JSON不能使用模型驱动
  			/**var params = {
  				user.account:account
  			}*/
  			//解决办法
  			var params = "user.account="+account;
  			$.ajax({
  				type:"post",
  				url :"showJSONStrutsJsonAjaxAction.action",
  				data:params,
  				dataType:"json",
  				success:function(data){//data是放回值
  					
  					if(data.flag=='error'){
  						$("#accountId").html("<font color='red' size='-1'>&otimes;账号已经存在！</font>");
  					}else{
  						$("#accountId").html("<font color='green'>&radic;</font>");
  						msg = true;
  					}
  				}
  				//error: function(data) { alert('Error loading TEXT document' + data); }// 请求失败时调用
  				
  			});
  		}
		//校验所有控件是否合法
		function validateAll(){
			var imgHeadPhoto = document.getElementById("imgHeadPhoto");
			var photoExist = document.getElementById("photoExist");
			if(imgHeadPhoto.src == ""||imgHeadPhoto.src==null){
				photoExist.innerHTML="<font color='red' >&otimes;请选择照片！！！</font>";
				return false;
			}else{
				photoExist.innerHTML="";
				return accountBlur()&&idenBlur()&&pswBlur_1()&&pswQBlur()&&mailBlur()&&phoneBlur()&&userNameBlur();
			}
		}
	</script>
  </head>

  <body>
   	<form name="myform" action="toAddUserAction.action" method="post" enctype="multipart/form-data" onsubmit="return validateAll()">
   		<center>
   		<table cellpadding="0" cellspacing="0" width="90%">
   			<caption><font color="green" size="5px"><b>用户信息添加</b></font></caption>
   			<tr >
   				<td colspan="3" rowspan="4" align="center">
   					<div id="divPreview" >
		    				<img id="imgHeadPhoto" style="width: 160px; height: 170px;" alt="无" />
		    		</div>
   				</td>
   				<td width="150px">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
   				<td width="200px"><input name="user.account" id="account" type="text" onfocus="accountFocus();" onblur="accountBlur();"></td>
   				<td width="250px" id="accountId">&nbsp;</td>
   			</tr>
 			<tr>
   				<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
   				<td><input name="user.userName" id="userName" type="text" onfocus="userNameFocus();" onblur="userNameBlur();"></td>
   				<td id="userNameId">&nbsp;</td>
   			</tr>
   			<tr>
   				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
   				<td><input name="user.password" id="password" type="password" onfocus="pswFocus();" onblur="pswBlur();" ></td>
   				<td id="passwordId">&nbsp;</td>
   			</tr>
   			<tr>
   				<td>确认密码：</td>
   				<td><input id="password1" type="password" onfocus="pswQFocus();" onblur="pswQBlur();"></td>
   				<td id="password1Id">&nbsp;</td>
   			</tr>
   			<tr>
   				<td colspan="2">
   					<input type="file" size="15px" name="photo" onchange="PreviewImage(this,'imgHeadPhoto','divPreview');" />
   				</td>
   				<td id="photoExist">&nbsp;</td>
   				<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
   				<td>
   					<s:radio list="#{'1':'男','2':'女'}" name="user.sex" value="1"></s:radio>
   				</td>
   				<td>&nbsp;</td>
   			</tr>
   			<tr>
   				<td >访问页面：</td>
   				<td colspan="2" width="170px"><input type="text" name="user.homePage" /></td>
   				<td >邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
   				<td><input name="user.email" id="mail" type="text" onfocus="mailFocus();" onBlur="mailBlur();"></td>
   				<td id="mailId">&nbsp;</td>
   			</tr>
   			<tr>
   				<td>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</td>
   				<td colspan="2"><input name="user.position" id="position" type="text"></td>
   				<td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
   				<td><input name="user.telphone" id="telphone" type="text" onfocus="telFocus();" onblur="telBlur();"></td>
   				<td id="telphoneId">&nbsp;</td>
   			</tr>
   			<tr>
   				<td>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：</td>
   				<td colspan="2">
   					<s:select list="#orgList" listKey="org_id" listValue="org_name" name="org_id" id="org"></s:select>  				
   				</td>
   				<td width="100px">身份证号：</td>
    			<td width="150px"><input type="text" name="user.identity" id="identity" onfocus="idenFocus();" onblur="idenBlur();" ></td>
   				<td id="identityId">&nbsp;</td>
   			</tr>
   	   </table></center>
   	   <br/>
   	   <br/>
   	   <center>
   	  	 <font color="red"><b><s:property value="message"/></b></font>
   	  	 <input value="提  交" type="submit" />
   	   </center>
   	</form>
  </body>
</html>
