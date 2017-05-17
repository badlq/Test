<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
  <%@ page import="cn.cslg.wcs.dao.*,java.util.*,cn.cslg.wcs.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>普通主页面</title>
<Link rel="stylesheet" type="text/css" href="css/mainhome.css" />
</head>
<body>
<center>
<h1>计算机技术交流留言板</h1>
	<span class="login">
	<%
        String username=(String)session.getAttribute("name");
        if(username==null){
    %>
	您尚未　<a href="login.jsp">登录</a>
	<%
        }else{
	%>
		欢迎&nbsp;<%=username %> &nbsp;
		<a href="user/updatePwd.jsp">修改密码</a>
        <a href="logout">注销</a>
	<%} %>
   </span>
	<%
	int row=0;
	if(session.getAttribute("row")!=null)
		row=(int)session.getAttribute("row");
	int pageNow=Integer.parseInt(request.getParameter("pageNow"));

	%>
    
    
    <div class="select">
                    <span class="mune"><a href="Message?pageNow=1&type=C">C语言</a></span>
                    <span class="mune"><a href="Message?pageNow=1&type=Java">Java技术</a></span>
                 <span class="mune"> <a href="Message?pageNow=1&type=PHP">PHP学习</a></span>
                 <br />
            </div>
            
	
   <div class="allconts">
    <c:forEach var="message" items="${sessionScope.mbs}">
    	<span class="name-ip">${message.name} &nbsp;${message.ip}<br/></span>
        <span class="conts">${message.content}</span>
        <br />
        <hr size="1" width="%60" color="#d4eff7">
		</c:forEach>
	</div>
	<%if(row>=1){ 
			if(pageNow>1){
	%>
		<div class="page">
        	<a href="Message?pageNow=1&type=${param.type}">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="Message?pageNow=${Integer.parseInt(param.pageNow)-1}&type=${param.type}" >上一页</a>
			<%} %>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:forEach var="i" begin="1" end="${sessionScope.row}">&nbsp;&nbsp;
				<a href="Message?pageNow=${i}&type=${param.type}" >${i}</a>	
			</c:forEach>&nbsp;&nbsp;&nbsp;&nbsp;
			<% if(pageNow<row){%>
			<a href="Message?pageNow=${Integer.parseInt(param.pageNow)+1}&type=${param.type}" >下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="Message?pageNow=${sessionScope.row}&type=${param.type}">末页</a>
			<%	
				}
			}
		
			%>
    	</div>
	<div clsaa="reply">
		<form action="MessageAdd?pageNow=${Integer.parseInt(param.pageNow)}&type=${param.type}"  method="post">
			<textarea rows="5" cols="100"  name="content"></textarea>
			<input class="rebo" type="submit" value="回复">
			
		</form>
     </div>
     </center>
</body>
</html>