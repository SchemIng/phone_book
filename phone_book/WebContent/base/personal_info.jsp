<%@page import="org.scheming.dao.UserDao"%>
<%@page import="org.scheming.dao.ClassDao"%>
<%@page import="org.scheming.dao.DaoFactory"%>
<%@page import="org.scheming.model.ClassModel"%>
<%@page import="java.util.List"%>
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
<title>Contract</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI -->
<link href="../flat_ui/css/flat-ui.css" rel="stylesheet">
<link rel="shortcut icon" href="../flat_ui/img/favicon.ico">
<link href="../css/myinfo.css" rel="stylesheet">
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,600,700,800,300'
	rel='stylesheet' type='text/css'>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapse-01">
					<span class="sr-only">Toggle navigation</span>
				</button>
				<a class="navbar-brand" href="../index.html">Contact</a>
			</div>
			</nav>
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<%
					String id = (String) request.getParameter("user_id");
					UserDao dao = (UserDao) DaoFactory.getUserDaoInstance();
					User user = (User) dao.queryData(id);
				%>

				<form class="form-info" action="update.action" method="post"
					role="form">
					<div class="form-group">
						<div class="col-md-12">
							<label for="name" class="control-label">学号</label>
							<div class="templatemo-input-icon-container">
								<i class="fa fa-star"></i> <input type="text" pattern="\d{8}"
									value="<%=user.getId()%>" readonly="readonly"
									required="required" autofocus="autofocus" class="form-control"
									name="input_id" id="name" placeholder="">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<label for="email" class="control-label">姓名</label>
							<div class="templatemo-input-icon-container">
								<i class="fa fa-user"></i> <input type="text" name="input_name"
									value="<%=user.getName()%>" required="required"
									class="form-control" id="email" placeholder="">
							</div>
						</div>
					</div>
					<%
						if ((Boolean) request.getSession().getAttribute("ismaster")) {
					%>
					<div class="form-group">
						<div class="col-md-12">
							<label for="website" class="control-label">密码</label>
							<div class="templatemo-input-icon-container">
								<i class="fa fa-lock"></i> <input type="password"
									value="<%=user.getPw()%>" name="input_pw" required="required"
									class="form-control" id="website" placeholder="">
							</div>
						</div>
					</div>
					<%
						}
					%>

					<div class="form-group">
						<div class="col-md-12">
							<label for="subject" class="control-label">QQ</label>
							<div class="templatemo-input-icon-container">
								<i class="fa fa-qq"></i> <input type="text" class="form-control"
									value="<%=user.getQq()%>" name="input_qq"
									pattern="[1-9][0-9]{4,14}" required="required" id="subject"
									placeholder="">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<label for="subject" class="control-label">电话</label>
							<div class="templatemo-input-icon-container">
								<i class="fa fa-phone"></i> <input type="text"
									required="required" value="<%=user.getTel()%>" pattern="\d{11}"
									class="form-control" id="subject" name="input_tel"
									placeholder="">
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-12">
							<label for="subject" class="control-label">班级</label>
							<div class="templatemo-input-icon-container">
								<i class="fa fa-phone"></i> <select class="form-control"
									name="input_class">
									<%
										String cla = user.getCla();
										List<ClassModel> classModels = ((ClassDao) DaoFactory
												.getClassDaoInstance()).queryAll();
										for (ClassModel classModel : classModels) {
											if (cla.equals(classModel.getName())) {
									%>
									<option selected="selected"><%=classModel.getName()%></option>
									<%
										} else {
									%>
									<option><%=classModel.getName()%></option>
									<%
										}
									%>
									<%
										}
										dao.close();
									%>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-12 btn-g">
							<input type="submit" value="确认" class="btn btn-primary">
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>