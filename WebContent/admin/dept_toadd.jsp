<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>部门添加</h3>
	<form action="dodept.do" method="post" name="frmadd">
		部门名称:<input name="deptname" type="text"/><br/>
		部门介绍:<textarea rows="8" cols="40" name="deptinfo"></textarea>
		<br/>
		<input name="btnadd" type="submit" value="添加">
		<input name="btnreset" type="reset" value="重置">
	</form>
</body>
</html>