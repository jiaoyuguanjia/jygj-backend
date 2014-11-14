<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery EasyUI</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jquery-easyui/themes/default/easyui.css">
<link href="${pageContext.request.contextPath}/resources/css/index.css" type="text/css" rel="stylesheet"/> 
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.7.1.min.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/resources/jquery-easyui/jquery.easyui.min.js" type="text/javascript" ></script>
	
</head>
<body class="easyui-layout">
	<div region="north" border="false" style="height:60px;background:#B3DFDA;font-size:36px;">
		欢迎来到教育管家后台管理系统
	</div>
	<div region="west" split="true" title="West" style="width:150px;padding:10px;">
		<%@include file="weat.jsp" %>
	</div>
	<div region="east" split="true" title="East" style="width:100px;padding:10px;"></div>
	<div region="south" border="false" style="height:50px;background:#A9FACD;padding:10px;font-size:29px;">
		<a href="http://www.teacher.im">www.teacher.im</a>@我们一直在努力
	</div>
	<div region="center" title="Main Title">
		<tiles:insertAttribute name="body"/>
	</div>
</body>
</html>