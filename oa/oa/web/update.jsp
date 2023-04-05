<%@ page import="com.school.software.oa.bean.Dept" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改页面</title>
	</head>
	<body>
		<h1 align="center">修改</h1>
		<hr>
		<%
		Object obj = request.getAttribute("update");
		Dept dept = (Dept) obj;
		%>
		<form align="center" action="/oa/dept/update" method="post">
			部门编号:<input type="text" name="dno" value=<%=dept.getDno()%>><br><br><br>
			部门名称:<input type="text" name="dname" value=<%=dept.getDname()%>><br><br><br>
			部门地址:<input type="text" name="dloc" value=<%=dept.getDloc()%>><br><br><br>
			<input type="submit" value="修改"/>
		</form>
		<hr>
	</body>
</html>