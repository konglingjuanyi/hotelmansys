<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>房间按年收入统计</title>
    <!-- 引用jquery的库 -->
    <script type="text/javascript" src="<%=path %>/resource/common/jquery-1.8.3.js"></script>
  	<!-- 引用FunsionCharts的支持 -->  
 	<script type="text/javascript" src="<%=path %>/FunsionChar/js/FusionCharts.js"></script>
 	 <link rel="stylesheet" href="<%=path %>/FunsionChar/prettify.css" type="text/css"></link>
 	<!-- 使用Ajax显示图 -->
 	<script type="text/javascript">
 		function showCharts(){
 			
 			if($("#year").val()==""||$("#year1").val()==""){
 				return false;
 			}
 			//声明FunsionChar对象
 			var chart2D_1 = new FusionCharts("FunsionChar/swf/MSColumn2D.swf", "myfist", "480", "380");
			var chart2D_2 = new FusionCharts("FunsionChar/swf/MSLine.swf", "myfist", "480", "380");
			$.ajax( {
				url : 'showRoom1FunsionChartAction.action?year='+$("#year").val()+"&year1="+$("#year1").val(),
				type : 'post',
				dataType : 'text',
				async : false,
				error : function() {
				},
				success : function(data) {
					chart2D_1.setDataXML(data);
					chart2D_2.setDataXML(data);
				}
			});
			chart2D_1.render("chartdiv2D_1");
			chart2D_2.render("chartdiv2D_2");
 		}
 		
 		$(function(){
 			showCharts();
 		})
 	
 	</script>
</head>
  
  <body>
  	请选择对比年份:
  	 <select id="year" onchange="showCharts()">
    	<option value="">请选择</option>
    	<option value="2010">2010年</option>
    	<option value="2011">2011年</option>
    	<option value="2012" selected="selected">2012年</option>
    	<option value="2013">2013年</option>
    	<option value="2014">2014年</option>
    	<option value="2015">2015年</option>
    </select>
    <select id="year1" onchange="showCharts()">
    	<option value="">请选择</option>
    	<option value="2010">2010年</option>
    	<option value="2011">2011年</option>
    	<option value="2012">2012年</option>
    	<option value="2013" selected="selected">2013年</option>
    	<option value="2014">2014年</option>
    	<option value="2015">2015年</option>
    </select><br /><br />
   <font color="blue" size="3px"><b>(1)柱状图</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<font color="blue" size="3px"><b>(2)折线图</b></font>
	<div>
    
		<div>
		<div style="float:left;width:480px; height:380px;border:1px solid green" id="chartdiv2D_1"></div>
		
		<div style="float:left;width:480px; height:380px;border:1px solid green" id="chartdiv2D_2"></div>
		
		</div>
		<div style="clear:both;"></div>
  </body>
</html>
