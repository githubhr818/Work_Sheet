<%@ page import="com.school.software.oa.bean.Dept" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增部门</title>
	</head>
	<body>
		<h1 align="center">新增部门</h1>
		<hr>
		<table border="1Px" align="center" >
			<form action="/oa/dept/add" method="get">
				<tr>
					<th>部门编号：</th>
					<td><input type="text" name="dno" /></td>
				</tr>
				<tr>
					<th>部门名称：</th>
					<td><input type="text" name="dname" /></td>
				</tr>
				<tr>
					<th>部门地址：</th>
					<td><input type="text" name="dloc" /></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="添加" /></th>
				</tr>
			</form>
		</table>
	</body>
</html>