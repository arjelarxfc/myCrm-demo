<%@page contentType="text/html"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<center>
		<h2>Hello World!</h2>
		<form action="user/userId" method="get"
			onsubmit="return confirmFun();">
			enter an id:<input id="userId" name="userId"> 
			<input type="submit" value="OK">
		</form>
		<a href="user/allUsers">查询所有</a> <a
			href="webPage/vcore/wedding/firstPage.html">跳转Vcore首页</a> <a
			href="crm/login">跳转CRM首页</a>
	</center>
</body>
<script type="text/javascript">
	function confirmFun() {
		var userId = document.getElementById("userId").value;
	//	alert(userId);
	}
</script>
</html>
