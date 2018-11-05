<!-- 用户所看到的商品列表详细信息 -->
<%@page import="domain.commodity"%>
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
<title>在线商品列表</title>

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
						<li><a href="doDispaturetomain.do?uId=<%=(String)request.getParameter("uId")%>">用户个人信息</a></li>
						<li><a href="Odetail.html?uId=<%=(String)request.getParameter("uId")%>">个人订单管理</a></li>
						<li class="active"><a href="#">浏览在线商品</a></li>
						<li><a href="cart.html?uId=<%=(String)request.getParameter("uId")%>">购物车</a></li>
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
				<h1>卖闲置小说专辑</h1>
			</div>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>商品ID</th>
							<th>商品名</th>
							<th>商品类别</th>
							<th>商品价格</th>
							<th>作者</th>
							<th>操作1</th>
							<th>操作2</th>
						</tr>
					</thead>
					<tbody>
						<%
							request.setCharacterEncoding("UTF-8");
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html;charset = UTF-8");
							String uId = request.getParameter("uId");
							List<commodity> list = DBUtils.doCQuery();
							for(int i=0;i<list.size();i++)
							{
						%>

						<tr>
						 <% commodity c = list.get(i); %>
							<td><%=c.getcId() %></td>
							<td><%=c.getCname() %></td>
							<td><%=c.getCate() %></td>
							<td><%=c.getPrice() %></td>
							<td><%=c.getWriter() %></td>
		                    <td><input type="button" value="商品详情" onclick="javascrtpt:window.location.href='images.html'"></td>
							<td><input type="button" value="加入购物车" onclick="javascrtpt:window.location.href='doAddtocart.do?cId=<%=c.getcId()%>&uId=<%=uId%>'"></td>
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
			<p class="text-muted credit">商品信息表</p>
		</div>
	</div>

	<!-- script references -->
	<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
	<script type='text/javascript' src="js/bootstrap.min.js"></script>
</body>
</html>