<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
  <%@ page import="cn.cslg.wcs.dao.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>普通主页面</title>
</head>
<body>
<h1>操你妈逼的狗屁留言板程序一群智障 滚犊子</h1>
<%
int row=0;
if(session.getAttribute("row")!=null)
	row=(int)session.getAttribute("row");
int pageNow=Integer.parseInt(request.getParameter("pageNow"));

%>
<span><a href="logout">注销</a></span>
<div>
	<div>
		<span><a href="Message?pageNow=1&type=C">C</a></span>&nbsp;&nbsp;
		<span><a href="Message?pageNow=1&type=Java">Java</a></span>&nbsp;&nbsp;
		<span><a href="Message?pageNow=1&type=PHP">PHP</a></span>&nbsp;&nbsp;
	</div>
	<div><table>
		<th>姓名</th>
		<th>ip</th>
		<th>内容</th>
		<th>管理</th>
	
		<c:forEach var="message" items="${sessionScope.mbs}">
		<tr>
			<td>${message.name}</td>
			<td>${message.ip}</td>
			<td>${message.content}</td>
			<td><a href="MessageDel?pageNow=${param.pageNow}&type=${param.type}&id=${message.id}">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<%if(row>=1){ 
			if(pageNow>1){
	%>
		<a href="Message?pageNow=1&type=${param.type}">首页</a>
		<a href="Message?pageNow=${Integer.parseInt(param.pageNow)-1}&type=${param.type}" >上一页</a>
	<%} %>
	<c:forEach var="i" begin="1" end="${sessionScope.row}">
		<a href="Message?pageNow=${i}&type=${param.type}" >${i}</a>	
	</c:forEach>
	<% if(pageNow<row){%>
	<a href="Message?pageNow=${Integer.parseInt(param.pageNow)+1}&type=${param.type}" >下一页</a>
	<a href="Message?pageNow=${sessionScope.row}&type=${param.type}">末页</a>
	<%	
	}
}	
	%>
</div>
</body>
</html>