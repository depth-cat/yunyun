<%@page import="domain.Users"%>
<%@page import="java.util.List"%>
<%@page import="repository.DBUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<style type="text/css"> 
   body{ background-image: url(image/e.jpg); }
   </style>
<title>用户列表</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="css/main1.css" rel="stylesheet">
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
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">用户信息</a></li>
						<li><a href="admincomm.html">商品管理页面</a></li>
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
				<h1>用户列表</h1>
			</div>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户名</th>
							<th>性别</th>
							<th>密码</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<%
							request.setCharacterEncoding("UTF-8");
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html;charset = UTF-8");
							List<Users> list = DBUtils.doUQuery();
							for(int i=0;i<list.size();i++)
							{
						%>
						<tr>
						 <% Users u = list.get(i); %>
							<td><%=u.getuId() %></td>
							<td><%=u.getUname() %></td>
							<td><%=u.getUsex()%></td>
							<td><%=u.getUpwd()%></td>
							<td><a href="Udetail.html?uId=<%=u.getuId()%>">详情</a>&nbsp;&nbsp;<a href="doUDelete.do?uId=<%=u.getuId()%>">删除</a></td>
						</tr>
					<%
                  }
      		%>
					</tbody>
				</table>
			</div>
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