<%@ page import="com.school.software.oa.bean.Dept" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门列表</title>
		<script>
			function del(dno){
				var ok = window.confirm("亲 ！确认要删除数据嘛！");
				if(ok){
				document.location.href="/oa/dept/delete?dno="+dno;
				}
			}
		</script>
	</head>
	<body>

	欢迎${username}用户！
		<h1 align="center">部门列表</h1>
		<hr>
		<table border="1px" align="center" width="50%">
			<tr>
				<th>序号</th>
				<th>编号</th>
				<th>名称</th>
				<th>操作</th>
			</tr>
			<%
			Object obj = request.getAttribute("deptlist");
			List<Dept> list = (List<Dept>) obj;

			int index = 1;

			for(Dept value : list){
			%>

			<tr>
				<td><%= index++%></td>
				<td><%= value.getDno()%></td>
				<td><%= value.getDname()%></td>
				<td align="center">
					<a href="javascript:void(0)" onclick="del(<%=value.getDno()%>)">删除</a>
					<a href="/oa/dept/update?dno=<%=value.getDno()%>">修改</a>
					<a href="/oa/dept/detail?dno=<%=value.getDno()%>">详细</a>
				</td>
			</tr>

			<%}%>

		</table>
		<hr>
		<a href="/oa/addDept.jsp">新增部门</a>
	</body>
</html>