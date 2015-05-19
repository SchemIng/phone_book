<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误</title>

<script type="text/javascript">
	function countDown(secs) {
		//alert(surl);     
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if (--secs > 0) {
			setTimeout("countDown(" + secs + ",'" + "')", 1000);
		} else {
			history.back();
		}
	}
</script>

</head>
<body>
	<h3>
		<%=request.getAttribute("error_msg")%>
	</h3>
	<div>
		<span> 浏览器在<span id="jumpTo">3</span>秒后跳转到登陆页面。如果浏览器没反应,<a
			href="#" onclick="history.back()">请点击这里</a>
		</span>
	</div>
	<script type="text/javascript">
		countDown(3);
	</script>

</body>
</html>