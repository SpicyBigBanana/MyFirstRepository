<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>名称</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.depts }" var="dept">
			<tr>
				<td>${dept.deptname }</td>
				<td>
					<a href="dpdept.do?op=del&id=${dept.deptid }">删除</a>
					<a href="dpdept.do?op=toedit&id=${dept.deptid }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>