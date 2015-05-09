<%@page import="org.scheming.model.User"%>
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

<title>班级通讯录--主页</title>

<link
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<title>班级通讯录--个人信息</title>
<link href="../css/info.css" rel="stylesheet">
</head>
<body background="../img/login_bg.jpg">

	<%
		String id = request.getParameter("id");
		User user = (User) getServletContext().getAttribute(id);
	%>

	<form class="form-info" action="UpdateServlet" method="post"
		role="form">
		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon">学号</span> <input type="text"
				name="input_id" value="<%=user.getId()%>" readonly="readonly"
				class="form-control" />
		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon">姓名</span> <input type="text"
				name="input_name" class="form-control" placeholder="姓名" required
				value="<%=user.getName()%>" disabled="disabled" />

		</div>
		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon">班级</span> <input type="text"
				value="<%=user.getCla()%>" name="input_cla" class="form-control"
				disabled="disabled" placeholder="班级" required />

		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon">电话</span> <input type="text"
				pattern="\d{11}" value="<%=user.getTel()%>" name="input_tel"
				class="form-control" placeholder="电话" required />
		</div>

		<div class="input-group input-group-lg" style="padding-bottom: 20px">
			<span class="input-group-addon">QQ</span></span> <input type="text"
				class="form-control" name="input_qq" placeholder="QQ" required
				value="<%=user.getQq()%>" pattern="[1-9][0-9]{4,14}" />
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">确定</button>
	</form>
</body>
</html>