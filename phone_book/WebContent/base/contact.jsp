<%@page import="org.scheming.dao.ClassDao"%>
<%@page import="org.scheming.dao.DaoFactory"%>
<%@page import="java.util.Set"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.scheming.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="org.scheming.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<link href="../css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<title>Contract</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI -->
<link href="../flat_ui/css/flat-ui.css" rel="stylesheet">
<link href="../css/mycontact.css" rel="stylesheet">
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,600,700,800,300'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<%
		String id = (String) request.getSession().getAttribute("user_id");
		UserDao dao = (UserDao) DaoFactory.getUserDaoInstance();
		List<User> lists = new ArrayList<User>();
		if (request.getParameter("data") == null) {
			ResultSet set = dao.queryClassData(id);

			while (set.next()) {
				lists.add(new User(set.getString("id"), set
						.getString("name"), null, set.getString("class"),
						set.getString("tel"), set.getString("qq"), set
								.getString("path"), set
								.getBoolean("ismaster")));
			}
			getServletContext().setAttribute("lists_" + id, lists);
			set.first();
		} else {
			lists = dao.queryByName(request.getParameter("data"));
		}

		ClassDao classDao = (ClassDao) DaoFactory.getClassDaoInstance();
	%>
	<div class="container-fluid">
		<div class="row-fluid">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapse-01">
					<span class="sr-only">Toggle navigation</span>
				</button>
				<a class="navbar-brand" href="#"><%=lists.get(0).getCla()%></a>
				<%
					if ((Boolean) request.getSession().getAttribute("ismaster")) {
				%>
				<a class="navbar-brand" href="addmember.jsp">添加成员</a>
				<%
					}
				%>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-01">
				<form role="search" class="navbar-form navbar-right"
					action="contact.jsp">
					<div class="form-group">
						<input type="text" placeholder="通过姓名搜索" class="form-control"
							name="data">
					</div>
					<button class="btn btn-default" type="submit">搜索</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a class="navbar-link" href="export.action">导出Excel表格</a></li>
					<li><a class="navbar-link" href="logout.action">登出</a></li>
				</ul>

			</div>
			</nav>

			<div class="col-md-2">
				<div class="span12">
					<form action="notice.action" method="post" class="alert">
						<div class="form-group">
							<h4>通知</h4>
							<%
								if ((Boolean) request.getSession().getAttribute("ismaster")) {
							%>
							<textarea class="form-control" rows="10" name="notice">
							<%=classDao.queryNotice(lists.get(0).getCla())%>
							</textarea>
							<%
								} else {
							%>
							<textarea class="form-control" rows="10" readonly="readonly"
								style="color: #0F0F0F;" name="notice">
							<%=classDao.queryNotice(lists.get(0).getCla())%>
							</textarea>
							<%
								}
							%>


						</div>
						<%
							if ((Boolean) request.getSession().getAttribute("ismaster")) {
						%>
						<button type="submit" class="btn btn-primary">修改</button>
						<%
							}
						%>
					</form>
				</div>

			</div>
			<div class="col-md-8">

				<!-- Table -->
				<table class="table contact_list table-hover">
					<thead>
						<tr>
							<th>头像</th>
							<th>姓名</th>
							<th>QQ号</th>
							<th>电话号码</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < lists.size(); i++) {

								User user = lists.get(i);
						%>
						<%
							if (user.getId().equals(id)) {
						%>
						<tr class="<%="danger"%>">
							<%
								} else {
							%>
						
						<tr>
							<%
								}
							%>

							<td><img class="user_head" alt=""
								src="<%="../user_head/" + user.getPath()%>"></td>
							<%
								if (user.getId().equals(id)
											|| (Boolean) request.getSession().getAttribute(
													"ismaster")) {
							%>
							<td><a
								href="<%="personal_info.jsp?user_id=" + user.getId()%>"><%=user.getName()%></a></td>
							<%
								} else {
							%>
							<td><%=user.getName()%></td>
							<%
								}
							%>
							<td><%=user.getQq()%></td>
							<td><%=user.getTel()%></td>
							<%
								if ((Boolean) request.getSession().getAttribute("ismaster")) {
							%>
							<td><a class="fa fa-trash-o"
								href=<%="delete.action?user_id=" + user.getId()%>></a></td>
							<%
								}
							%>
						</tr>
						<%
							}
							dao.close();
							classDao.close();
						%>
					</tbody>

				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

</body>

</html>