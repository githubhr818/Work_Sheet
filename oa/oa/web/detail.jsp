<%@ page import="com.school.software.oa.bean.Dept" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门详细</title>
	</head>
	<body>
		<h1 align="center">部门详细</h1>
		<hr>
		<table align="center" border="1px" width="200PX">
			<%
				Dept dept = (Dept) request.getAttribute("detail");

				int i = 1;
			%>
			<tr>
				<th>序号</th>
				<td><%=i%></td>
			</tr>
			<tr>
				<th>部门编号</th>
				<td><%=dept.getDno()%></td>
			</tr>
			<tr>
				<th>部门名称</th>
				<td><%=dept.getDname()%></td>
			</tr>
			<tr>
				<th>部门地址</th>
				<td><%=dept.getDloc()%></td>
			</tr>
		</table>
		<hr>
		<a href="/oa/dept/list" >退回</a>
	</body>
</html>