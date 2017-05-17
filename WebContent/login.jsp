<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- CSS -->
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/supersized.css">
        <link rel="stylesheet" href="css/style.css">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<title>登录页面</title>
</head>
<body>
<div class="page-container">
<h1>用户登录</h1>
<form action="login?pageNow=1&type=C"  method="post">
	<input type="text" name="username" value="" class="username" placeholder="用户名"/><br/>
	<input type="password" name="password"  value="" class="password" placeholder="密码"/><br/>
	<input type="submit" value="登录"/><br>
	<a href="Message?pageNow=1&type=C">游客登录</a>
	<a href="register.jsp">免费注册</a>
	<div class="error"><span>+</span></div>
</form>
</div>
<!-- Javascript -->
        <script src="js/jquery-1.8.2.min.js"></script>
        <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
        <script src="js/scripts.js"></script>
</body>
</html>