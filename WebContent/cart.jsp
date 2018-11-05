<!-- 购物车页面 -->
<%@page import="domain.scart"%>
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
<title>购物车商品列表</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="css/main1.css" rel="stylesheet">
<style type="text/css"> 
   body{ background-image: url(image/e.jpg); }
   </style>

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
						<li><a href="Odetail.jsp?uId=<%=(String)request.getParameter("uId")%>">个人订单管理</a></li>
						<li ><a href="index.jsp?uId=<%=(String)request.getParameter("uId")%>">浏览在线商品</a></li>
						<li class="active"><a href="#">购物车</a></li>
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
				<h1>已选商品</h1>
			</div>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>商品ID</th>
							<th>商品名</th>
							<th>商品类别</th>
							
							<th>商品产地</th>
							<th>已选数量</th>
							<th>商品单价</th>
							<th>总价</th>
							<th>操作</th>
						</tr>
					</thead>
					<%
							request.setCharacterEncoding("UTF-8");
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html;charset = UTF-8");
							String uId = (String)request.getParameter("uId");
							List<scart> list = DBUtils.doQcart(uId);
							float m = 0;
							for(int i=0;i<list.size();i++)
							{
								scart s = list.get(i); 
								%>

					<tbody>
						

						<tr>
						 
							<td><%=s.getcId() %></td>
							<td><%=s.getCname() %></td>
							<td><%=s.getCate() %></td>
							
							<td><%=s.getWriter() %></td>
							<td><%=s.getNum() %></td>
							<td><%=s.getPrice() %></td>
							<td><%=s.getPrice()*s.getNum() %></td>
							<%m=m+s.getPrice()*s.getNum();%>
							<td><input type="button" value="删除" onclick="javascrtpt:window.location.href='doDelCart.do?uId=<%=uId%>&cId=<%=s.getcId()%>'"></td>
							<td><input type="button" value="添加到订单" onclick="javascrtpt:window.location.href='doMoveCart.do?uId=<%=uId%>&cId=<%=s.getcId()%>'"></td>
						</tr>
					<%
                  }	
      		%>
      		<tr>
      		<td>您的购物车目前总价：<%=m %></td>
      		</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="footer">
		<div class="container">
			<p class="text-muted credit">已选商品信息表</p>
		</div>
	</div>

	<!-- script references -->
	<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
	<script type='text/javascript' src="js/bootstrap.min.js"></script>
</body>
</html>