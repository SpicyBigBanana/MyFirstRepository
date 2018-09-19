<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<frameset rows="25%,*">
		<frame src="${pageContext.request.contextPath}/admin/top.jsp"/>
	<frameset cols="15%">
		<frame src="${pageContext.request.contextPath}/admin/left.jsp"/>	
		<frame src="${pageContext.request.contextPath}/admin/main.jsp"/>	
	</frameset>
	</frameset>
	
</body>
</html>