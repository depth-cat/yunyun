<!-- 登录页面 -->
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
		
		if (Login.uId.value == "") {
			m = "请输入您的ID";
			alert(m);
		} else if (Login.upwd.value == "") {
			m = "请输入密码";
			alert(m);
		} 
		else {
			return true;
		}
		return false;
	}
	function addCookie(sName,sValue,day) { 
		var expireDate = new Date(); 
		expireDate.setDate(expireDate.getDate()+day);; 
		//设置失效时间 
		document.cookie = escape(sName) + '=' + escape(sValue) +';expires=' + expireDate.toGMTString();6 //escape()汉字转成unicode编码,toGMTString() 把日期对象转成字符串 
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
          <h1 class="text-center">用户登录</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block" action="doLogin.do" method="post" name="Login" onSubmit="return Check(this)">
            <div class="form-group">
              <input type="text" name="uId" class="form-control input-lg" placeholder="用户ID">
            </div>
            <div class="form-group">
              <input type="password" name="upwd" class="form-control input-lg" placeholder="密码">
            </div>
            <div class="checkbox">
        </div>
         <div class="btn-group pull-right">
         
         <a href="register.html" class="btn btn-primary">注册</a>
          <a href="adminlogin.html" class="btn btn-primary">管理员登录</a>
          <button class="submit btn btn-primary" onClick="addCookie("uID",uId,1)">登录</button>
         
		  </div>	
          </form>
      </div>
      
  </div>
  </div>
</div>

	</body>
</html>