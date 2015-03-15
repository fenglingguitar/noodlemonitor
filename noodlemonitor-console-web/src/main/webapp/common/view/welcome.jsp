<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>welcome</title>
       
    <link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/common/css/my.css" />
    
	<script src="<%=request.getContextPath()%>/common/tool/wijmo-open/development-bundle/external/jquery-1.8.2.min.js" type="text/javascript"></script>
  	<script src="<%=request.getContextPath()%>/common/js/common.js" type="text/javascript"></script>

    <script type="text/javascript">
    	
    	function callback(trnId, data, other) {
    	}
    	
    	function init() {
    	}
		
	</script>
  </head>

  <body onload="init();" >
	<div class="page-header">
	    <h2>Welcome</h2>
	</div>
	<div class="page-list">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<colgroup>
				<col width="15%" />
				<col width="15%" />
				<col width="85%" />
			</colgroup>					
		    <tr>
		    	<td valign="top">
			    	<ul>
						<li>1、常规监控
							<ul>
		                        <li><a href="#" onclick="javascript:top.addTab('mainframe_1_1_1', '超时次数', '<%=request.getContextPath()%>/view/monitor/server/overtime/overtime_chart.jsp');">超时次数</a></li>
		                        <li><a href="#" onclick="javascript:top.addTab('mainframe_1_1_2', '平均响应时间', '<%=request.getContextPath()%>/view/monitor/server/avgtime/avgtime_chart.jsp');">平均响应时间</a></li>
								<li><a href="#" onclick="javascript:top.addTab('mainframe_1_1_3', '失败次数', '<%=request.getContextPath()%>/view/monitor/server/success/success_chart.jsp');">错误次数</a></li>
							</ul>
						</li>
				    </ul>
		    	</td>
		    	<td valign="top">
		    	</td>
		    	<td valign="top">
		    	</td>
			</tr>
		</table>
  	</div>
  </body>
</html>
