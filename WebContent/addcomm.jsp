<!-- 用户注册界面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>用户注册</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<style type="text/css">
      .modal-header{width:600px;height:150px;background-color:#FFFAF0;color:black;  }
         .modal-body{width:600px;height:720px;background-color:#FFFAF0;color:black; }
</style>
<script type="text/javascript">
	function Check(theform) {
		var m;
		
		if (Register.uId.value == "") {
			m = "请输入用户ID";
			alert(m);
		} else if (Register.uname.value == "") {
			m = "请输入用户名";
			alert(m);
		} else if (Register.upwd.value == "") {
			m = "请输入密码";
			alert(m);
		} else if (Register.pwdConfirm.value == "") {
			m = "请确认密码";
			alert(m);
		}else if(Register.upwd.value!=Register.pwdConfirm.value){
			m="两次输入的密码不一致";
			alert(m);
		}
		else {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<!--login modal-->
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h1 class="text-center">添加商品</h1>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block" name="Register"
						action="doAddcomm.do" method="post">
						<!-- enctype="application/x-www-form-urlencoded" -->
						<div class="form-group">
							<label>商品ID</label> <label style="font-size: 10px"></label>
							<input type="text" name="cId" class="form-control input-lg"
								placeholder="ID">
						</div>
						<div class="form-group">
							<label>商品名</label> <input type="text" name="cname"
								class="form-control input-lg" placeholder="商品名">
						</div>
						<div class="form-group">
							<label>商品类别</label>
							<div class="radio">
								<label> <input type="radio" name="cate" id="maleRadios"
									value="瑞士表" checked>瑞士表
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="cate"
									id="femaleReadios" value="电子表">电子表
								</label>
							</div>
						</div>
						<div class="form-group">
							<label>价格</label> <input type="text" name="price"
								class="form-control input-lg" placeholder="价格">
						</div>
						<div class="form-group">
							<label>作者</label> <input type="text" name="writer"
								class="form-control input-lg" placeholder="作者">
						</div>
						<div class="form-group">
							<label>照片</label> <input type="text" name="image"
								class="form-control input-lg" placeholder="照片">
						</div>
						<div class="btn-group pull-right">
							
							<button class="submit btn btn-primary">添加</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- script references -->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>
