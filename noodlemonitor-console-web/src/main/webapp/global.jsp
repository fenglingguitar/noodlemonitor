<%@ page language="java" pageEncoding="UTF-8"%><%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	String commonPath = basePath + "/common";
	String sysTitle = "noodlemonitor";
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>