<%@page import="java.util.Set"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.scheming.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="org.scheming.db.UserDAO"%>
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
<link href="../css/mycontact.css" rel="stylesheet">
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,600,700,800,300'
	rel='stylesheet' type='text/css'>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap-modal.js"></script>
</head>
<body>
	<%
		String id = (String) request.getSession().getAttribute("user_id");
		UserDAO dao = new UserDAO();
		ResultSet set = dao.queryClassData(id);

		List<User> lists = new ArrayList<User>();
		while (set.next()) {
			lists.add(new User(set.getString("id"), set.getString("name"),
					null, set.getString("class"), set.getString("tel"), set
							.getString("qq"), false));
		}
		getServletContext().setAttribute("lists_" + id, lists);
		set.first();
	%>
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
			<div class="collapse navbar-collapse" id="navbar-collapse-01">
				<form role="search" class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="通过姓名搜索" class="form-control">
					</div>
					<button class="btn btn-default" type="submit">搜索</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a class="navbar-link" href="#">导出Excel表格</a></li>
				</ul>

			</div>
			</nav>
			<div class="col-md-2"></div>
			<div class="col-md-8">

				<!-- Table -->
				<table class="table contact_list table-hover">
					<thead>
						<tr>
							<th>序号</th>
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

							<td><%=i + 1%></td>
							<%
								if (user.getId().equals(id)) {
							%>
							<td><a href="<%="info.jsp"%>"><%=user.getName()%></a></td>
							<%
								} else {
							%>
							<td><%=user.getName()%></td>
							<%
								}
							%>
							<td><%=user.getQq()%></td>
							<td><%=user.getTel()%></td>
						</tr>
						<%
							}
						%>
					</tbody>

				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

</body>

</html>