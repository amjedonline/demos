<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User authentication</title>
</head>
<body>
	<%if(request.getUserPrincipal()!=null){ %>
	Hello
	<%= request.getUserPrincipal().getName().toString() %>
	You are able to view this page because you are authenticated user.
	<br /> You can logout by click
	<a href="<%=request.getContextPath()%>/protected/logout.jsp">here</a>here
	<%}else { %>
	You are not yet logged in, please click
	<a href="<%=request.getContextPath()%>/public/login.jsp">here</a> to
	login.
	<%} %>
</body>
</html>