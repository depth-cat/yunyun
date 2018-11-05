<%@page import="domain.Users"%>
<%@page import="java.util.List"%>
<%@page import="repository.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>个人列表</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<style type="text/css"> 
   body{ background-image: url(image/e.jpg); }
   </style>
<link href="css/main1.css" rel="stylesheet">
<script type="text/javascript">
	function check(){
		alert("修改成功！");
	}
</script>
</head>
<body>
	<!-- Wrap all page content here -->
	<div id="wrap">

		<!-- Fixed navbar -->
		<!-- 导航栏 开始-->
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Project</a>
					
				</div>
				<%
							request.setCharacterEncoding("UTF-8");
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html;charset = UTF-8");
							String uId = (String)request.getAttribute("uId");
							Users users = UserDAO.doQP(uId);
							if(users!=null)
							{
						%><!-- 调用 doQP显示用户的所有信息-->
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">用户个人信息</a></li>
						<li><a href="Odetail.html?uId=<%=users.getuId() %>">个人订单管理</a></li>
						<li><a href="index.html?uId=<%=request.getParameter("uId")%>">浏览在线商品</a></li>
						<li><a href="checkout.html?uId=<%=(String)request.getParameter("uId")%>">购物车</a></li>
						<li><a href="login.html">退出</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
		<!-- 导航栏 结束-->
		<!-- Begin page content -->
		<div class="container">
			<div class="page-header">
				<h1>个人信息</h1>
			</div>
			<form method="post" action="doPupdate.do">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户名</th>
							<th>性别</th>
							<th>地址</th>
							<th>电话</th>
							<th>密码</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						

						<tr>
						 
							<td><input  name="uId" type="hidden"  value="<%=users.getuId() %>"><%=users.getuId() %></td>
							<td><input  name="uname" type="text" required="required" value="<%=users.getUname() %>"></td>
							<td><input  name="usex" type="text" required="required" value="<%=users.getUsex()%>"></td>
							<td><input  name="uaddr" type="text" required="required" value="<%=users.getUaddr()%>"></td>
							<td><input  name="ucon" type="text" required="required" value="<%=users.getUcon()%>"></td>
							<td><input  name="upwd" type="text" required="required" value="<%=users.getUpwd()%>"></td>
							<td><button class="but" type="submit" onClick="check()">修改</button>&nbsp;&nbsp;</td>
						</tr>
					<%
						}else
						{
							response.setHeader("refresh", "0;URL=login.html");
						}
					%>
      		
					</tbody>
				</table>
			</div>
			</form>
		</div>
	</div>

	<div id="footer">
		<div class="container">
			<p class="text-muted credit">用户信息表</p>
		</div>
	</div>
	<!-- script references -->
	<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
	<script type='text/javascript' src="js/bootstrap.min.js"></script>
</body>
</html>