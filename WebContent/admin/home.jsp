<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员页面</title>
</head>
<body>


<%
	session.setAttribute("admin", "admin");
%>

<span><a href="Message?pageNow=1&type=C">留言管理</a><span>
<%if(request.getParameter("username").equals("root")){ %>
<span><a href="User?pageNow=1">用户管理</a></span>
<%} %>
<span><a href="logout">注销</a></span>
</body>
</html>