<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>menutree</title>
       
    <link href="<%=request.getContextPath()%>/common/tool/wijmo-open/development-bundle/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/common/tool/wijmo-pro/Wijmo/wijcheckbox/jquery.wijmo.wijcheckbox.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/common/tool/wijmo-pro/Wijmo/wijtree/jquery.wijmo.wijtree-my.css" rel="stylesheet" type="text/css" />

	<script src="<%=request.getContextPath()%>/common/tool/wijmo-pro/Wijmo/external/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/common/tool/wijmo-pro/Wijmo/external/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
		
	<script src="<%=request.getContextPath()%>/common/tool/wijmo-pro/Wijmo/wijutil/jquery.wijmo.wijutil.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/common/tool/wijmo-pro/Wijmo/Base/jquery.wijmo.widget.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/common/tool/wijmo-pro/Wijmo/wijtree/jquery.wijmo.wijtree.js" type="text/javascript"></script>
	
	<style type="text/css">
    	html
    	{
			margin:0; 
			padding:0;
		}
		*{
			margin:0;
			padding:0;
		}
		body
		{
			margin:0;
			padding:0;
			height: 100%;
			width: 100%;
			background: #ffffff;
		}
		.container
		{
			margin:0;
			padding:0;
		}
		.ui-widget 
		{ 
			font-size: 0.8em; 
		}
		.ui-widget-content 
		{
			background: #ffffff;
		}
		.wijmo-wijtree .wijmo-wijtree-list .wijmo-wijtree-node {
		    float: none;
		}
	</style>
    <script type="text/javascript">
    	 $(document).ready(function () {
             $("#tree").wijtree();
         });
	</script>
  </head>

  <body>
  	<div class="container">
		<ul id="tree">
	        <li><a href="#">常规监控</a>
	            <ul>
					<li><a href="#" onclick="javascript:top.addTab('mainframe_1_1_1', '超时次数', '<%=request.getContextPath()%>/view/monitor/server/overtime/overtime_chart.jsp');">超时次数</a></li>
					<li><a href="#" onclick="javascript:top.addTab('mainframe_1_1_2', '平均响应时间', '<%=request.getContextPath()%>/view/monitor/server/avgtime/avgtime_chart.jsp');">平均响应时间</a></li>
					<li><a href="#" onclick="javascript:top.addTab('mainframe_1_1_3', '失败次数', '<%=request.getContextPath()%>/view/monitor/server/success/success_chart.jsp');">错误次数</a></li>
	           </ul>
	        </li>
	    </ul>
	</div>
  </body>
</html>
