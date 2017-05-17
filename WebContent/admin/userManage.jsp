<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
  <%@ page import="cn.cslg.wcs.dao.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
</head>
<body>
<h1>用户管理</h1>
<span><a href="logout">注销</a></span>
<%
int row=0;
if(session.getAttribute("row")!=null)
	row=(int)session.getAttribute("row");
int pageNow=Integer.parseInt(request.getParameter("pageNow"));

%>
<div>

	<div><table>
		<th>姓名</th>
		<th>密码</th>
		<th>管理</th>
	
		<c:forEach var="user" items="${sessionScope.users}">
		<tr>
			<td>${user.name}</td>
			<td>${user.pwd}</td>
			<td><a hrff="">修改</a></td>
			<td><a href="UserDel?pageNow=${param.pageNow}&id=${user.id}">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<%if(row>=1){ 
			if(pageNow>1){
	%>
		<a href="User?pageNow=1">首页</a>
		<a href="User?pageNow=${Integer.parseInt(param.pageNow)-1}" >上一页</a>
	<%} %>
	<c:forEach var="i" begin="1" end="${sessionScope.row}">
		<a href="User?pageNow=${i}" >${i}</a>	
	</c:forEach>
	<% if(pageNow<row){%>
	<a href="User?pageNow=${Integer.parseInt(param.pageNow)+1}" >下一页</a>
	<a href="User?pageNow=${sessionScope.row}">末页</a>
	<%	
	}
}	
	%>
</div>
</body>
</html>