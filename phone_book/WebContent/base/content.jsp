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
<meta name="description" content="">
<meta name="author" content="">

<title>班级通讯录--主页</title>

<link
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<%
		String id = request.getAttribute("id").toString();
		UserDAO dao = new UserDAO();
		ResultSet set = dao.queryClassData(id);
		
		List<User> lists = new ArrayList<User>();
		while (set.next()) {
			lists.add(new User(set.getString("id"), set.getString("name"),
					null, null, set.getString("tel"), set.getString("qq"),
					false));
		}
		set.first();
	%>

	<h3><%=set.getString("class")%></h3>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<table class="table">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>电话</th>
							<th>QQ</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < lists.size(); i++) {

								User user = lists.get(i);
						%>
						<tr>
							<td><%=user.getId()%></td>
							<td><%=user.getName()%></td>
							<td><%=user.getTel()%></td>
							<td><%=user.getQq()%></td>
							<%
								if (user.getId().equals(id)) {
							%>
							<td><a href="info.jsp?id=<%=id%>">编辑</a></td>
							<%
								} else {
							%>
							<td>不可编辑</td>
							<%
								}
							%>

						</tr>
						<%
							}
						dao.close();
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>