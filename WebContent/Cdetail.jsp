<!-- 商品列表 -->
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
<title>商品所有信息</title>

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
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">用户所有信息</a></li>
						<li><a href="admanage.html">主页</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
		<!-- 导航栏 结束-->
		<!-- Begin page content -->
		<div class="container">
			<div class="page-header">
			<%
							request.setCharacterEncoding("UTF-8");
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html;charset = UTF-8");
							Users users = DBUtils.doUQ(request.getParameter("cId"));
							if(users!=null){
						%>
				<h1><%=users.getUname() %>所有信息</h1>
			</div>
			<form method="post" action="doUupdate.do">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>商品ID</th>
							<th>商品名</th>
							<th>商品类别</th>
							<th>商品价格</th>
							<th>作者</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						

						<tr height="80px">
						
							<td><input  name="uId" type="hidden"  value="<%=users.getuId() %>"><%=users.getuId() %></td>
							<td><input  name="uname" type="text" required="required" value="<%=users.getUname() %>"></td>
							<td><input  name="usex" type="text" required="required" value="<%=users.getUsex()%>"></td>
							<td><input  name="uaddr" type="text" required="required" value="<%=users.getUaddr()%>"></td>
							<td><input  name="ucon" type="text" required="required" value="<%=users.getUcon()%>"></td>
							<td><input  name="upwd" type="text" required="required" value="<%=users.getUpwd()%>"></td>
							<td><button class="but" type="submit" onClick="check()">确认修改</button>&nbsp;&nbsp;<input type="button" value="删除商品" onclick="javascrtpt:window.location.href='Orders.html?uId=<%=users.getuId()%>'"></td>
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
			<p class="text-muted credit">商品信息表</p>
		</div>
	</div>

	<!-- script references -->
	<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
	<script type='text/javascript' src="js/bootstrap.min.js"></script>
</body>
</html>