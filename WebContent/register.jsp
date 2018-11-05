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
					<h1 class="text-center">用户注册</h1>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block" name="Register"
						action="doRegister.do" method="post"
						onSubmit="return Check(this)">
						<!-- enctype="application/x-www-form-urlencoded" -->
						<div class="form-group">
							<label>用户ID</label> <label style="font-size: 10px"></label>
							<input type="text" name="uId" class="form-control input-lg"
								placeholder="用户ID">
						</div>
						<div class="form-group">
							<label>用户名</label> <input type="text" name="uname"
								class="form-control input-lg" placeholder="用户名">
						</div>
						<div class="form-group">
							<label>密码</label><label style="font-size: 10px"></label> <input type="password" name="upwd"
								class="form-control input-lg" placeholder="密码">
						</div>
						<div class="form-group">
							<label>密码确认</label> <input type="password" name="pwdConfirm"
								class="form-control input-lg" placeholder="密码确认">
						</div>
						<div class="form-group">
							<label>地址</label> <input type="text" name="uaddr"
								class="form-control input-lg" placeholder="地址">
						</div>
						<div class="form-group">
							<label>电话</label> <input type="password" name="ucon"
								class="form-control input-lg" placeholder="电话">
						</div>
						
						<div class="form-group">
							<label>性别</label>
							<div class="radio">
								<label> <input type="radio" name="usex" id="maleRadios"
									value="男" checked>男
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="usex"
									id="femaleReadios" value="女">女
								</label>
							</div>
						</div>


						<div class="btn-group pull-right">
							
							<button class="submit btn btn-primary">注册</button>
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
