<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>登录</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<style type="text/css">
		.modal-header{width:600px;height:150px;background-color:#FFFAF0;color:black;  }
         .modal-body{width:600px;height:300px;background-color:#FFFAF0;color:black; }
		</style>
		<script type="text/javascript">
	function Check(theform) {
		var m;
		if (Login.aId.value == "") {
			m = "请输入管理员ID";
			alert(m);
		} else if (Login.apwd.value == "") {
			m = "请输入密码";
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
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h1 class="text-center">管理员登录</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block" action="doadLogin.do" method="post" name="Login" onSubmit="return Check(this)" name="Login">
            <div class="form-group">
              <input type="text" name="aId" class="form-control input-lg" placeholder="管理员ID">
            </div>
            <div class="form-group">
              <input type="password" name="apwd" class="form-control input-lg" placeholder="密码">
            </div>
            <div class="checkbox">
        </div>
         <div class="btn-group pull-right">
         <a href="login.html" class="btn btn-primary">普通用户登录</a>
          <button class="submit btn btn-primary">登录</button>
		  </div>	
          </form>
      </div>
  </div>
  </div>
</div>
	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>

	</body>
</html>