<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">

<title>班级通讯录--注册</title>

<!-- Bootstrap core CSS -->
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/register.css" rel="stylesheet">

</head>
<body background="img/login_bg.jpg">
	<form class="form-signin" action="RegisterServlet" method="post"
		role="form">
		<h2 class="form-signin-heading" align="center">注册</h2>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">

			<span class="input-group-addon"><span
				class="glyphicon glyphicon-th-list"></span></span> <input type="text"
				name="input_id" class="form-control" placeholder="学号" required
				autofocus pattern="\d{8}" />
		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon"><span
				class="glyphicon glyphicon-user"></span></span> <input type="text"
				name="input_name" class="form-control" placeholder="姓名" required />

		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon"><span
				class="glyphicon glyphicon-lock"></span></span> <input type="password"
				name="input_pw" class="form-control" placeholder="密码" required />
		</div>


		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon"><span
				class="glyphicon glyphicon-lock"></span></span> <input type="password"
				class="form-control" id="input_repw" placeholder="再次输入密码" required />
		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon"><span
				class="glyphicon glyphicon-comment"></span></span> <input type="text"
				class="form-control" name="input_qq" placeholder="QQ" required
				pattern="[1-9][0-9]{4,14}" />
		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon"><span
				class="glyphicon glyphicon-earphone"></span></span> <input type="text"
				class="form-control" name="input_tel" placeholder="电话" required
				pattern="\d{11}" />
		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon"><span
				class="glyphicon glyphicon-home"></span></span> <select
				class="form-control" name="input_class">
				<option>软件1301</option>
				<option>软件1302</option>
			</select>
		</div>


		<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>

	</form>


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>