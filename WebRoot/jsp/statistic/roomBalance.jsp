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
 			var year = $("#year").val();
 			if(year==""){
 				return false;
 			}
 			//声明FunsionChar对象
 			var chart2D_1 = new FusionCharts("FunsionChar/swf/Column2D.swf", "myfist", "480", "380");
 			var chart2D_2 = new FusionCharts("FunsionChar/swf/Pareto2D.swf", "myfist", "480", "380");
			//chart.setDataURL(escape("column3DChart!initColumn3D.action"));
			$.ajax( {
				url : 'showRoomFunsionChartAction.action?year='+year,
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
  	请选择年份：
    <select id="year" onchange="showCharts()">
    	<option value="">请选择</option>
    	<option value="2010">2010年</option>
    	<option value="2011">2011年</option>
    	<option value="2012">2012年</option>
    	<option value="2013" selected="selected">2013年</option>
    	<option value="2014">2014年</option>
    	<option value="2015">2015年</option>
    	<option value="2016">2016年</option>
    	<option value="2017">2017年</option>
    	<option value="2018">2018年</option>
    	<option value="2019">2019年</option>
    	<option value="2020">2020年</option>
    </select><br /><br />
    
   
		<font color="blue" size="3px"><b>(1)2D柱状图</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<font color="blue" size="3px"><b>(2)排序图</b></font>
		<div>
		<div style="float:left;width:480px; height:380px;border:1px solid green" id="chartdiv2D_1"></div>
		
		<div style="float:left;width:480px; height:380px;border:1px solid green" id="chartdiv2D_2"></div>
		
		</div>
		<div style="clear:both;"></div>
  </body>
</html>
