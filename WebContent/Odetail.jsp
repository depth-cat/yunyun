<!--本页面是指的 订单的详细信息 -->
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
<title>用户订单信息</title>

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
		alert("删除成功！");
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
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
					
						<li><a href="doDispaturetomain.do?uId=<%=(String)request.getParameter("uId")%>">用户个人信息</a></li>
						<li class="active"><a href="#">个人订单管理</a></li>
						<li><a href="index.html?uId=<%=(String)request.getParameter("uId")%>">浏览在线商品</a></li>
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
			<h1>订单详细信息</h1>
			
				
			</div>
			<form method="post" action="doPOdelete.do">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>商品ID</th>
							<th>商品名</th>
							<th>商品类别</th>
							<th>作者</th>
							<th>已选数量</th>
							<th>商品单价</th>
							<th>商品总价</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						

						<tr >
						 <%
							request.setCharacterEncoding("UTF-8");
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html;charset = UTF-8");
							
							String uId = (String)request.getParameter("uId");
							System.out.println("uId"+uId);
							List<Users> userlist = DBUtils.doQO(request.getParameter("uId"));
							
						
						
						for(int i= 0; i<userlist.size();i++)
						{
							Users users = userlist.get(i);
								%>
							<td><input  name="uId" type="hidden"  value="<%=users.getuId() %>"><%=users.getuId() %></td>
							
							<td><input  name="cId" type="hidden" value="<%=users.getcId()%>"><%=users.getcId()%></td>
							<td><%=users.getCname()%></td>
							<td><%=users.getCate()%></td>
							<td><%=users.getWriter()%></td>
							<td><%=users.getNum()%></td>
							<td><%=users.getPrice()%></td>
							<td><%=users.getPrice()*users.getNum()%></td>
							<td><button class="but" type="submit" onClick="check()">删除</button></td>
						</tr>
					<%
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
			<p class="text-muted credit">用户订单表</p>
		</div>
	</div>

	<!-- script references -->
	<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
	<script type='text/javascript' src="js/bootstrap.min.js"></script>
</body>
</html>