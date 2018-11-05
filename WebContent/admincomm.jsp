<!-- 管理员管理商品列表详细信息 -->
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
<title>管理员管理商品的商品列表</title>

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
						<li><a href="admanage.html">用户的所有信息</a></li>
						<li class="active"><a href="admincomm.html">商品管理</a></li>
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
				<h1>商品列表</h1>
			</div>
			<form method="post" action="doCupdate.do">
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
						<%
							request.setCharacterEncoding("UTF-8");
							response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html;charset = UTF-8");
							List<commodity> list = DBUtils.doCQuery();
							for(int i=0;i<list.size();i++)
							{
								commodity c = list.get(i); 
						%>

						<tr>
						
							<td><input  name="cId" type="text"  required="required" value="<%=c.getcId() %>"></td>
							<td><input  name="cname" type="text" required="required" value="<%=c.getCname() %>"></td>
							<td><input  name="cate" type="text" required="required" value="<%=c.getCate() %>"></td>
							<td><input  name="price" type="text" required="required" value="<%=c.getPrice() %>"></td>
							<td><input  name="origin" type="text" required="required" value="<%=c.getWriter() %>"></td>
							<td><a href="doCDelete.do?cId=<%=c.getcId()%>">删除</a></td>
						</tr>
					<%
                  }
      		%>
      		
					</tbody>
				</table>
			</div>
			</form>
			<table><tr><td><button onclick="javascrtpt:window.location.href='addcomm.html?'">新增商品信息</button><td></tr></table>
			
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