<%
	request.getSession().invalidate();
	out.println("You have successfuly logged out. Thanks for visiting User Authentication!");
%>
Please click <a href="<%=request.getContextPath()%>/public/login.jsp">here</a> to login again.