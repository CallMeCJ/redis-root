<%@ page import="com.cjzheng.pojo.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%--你们可以看看 isELIgnored作用--%>
<html>
<head>
<title>Title</title>
</head>
<body>
	${cc }
	<br>
	<%
		User user = (User) session.getAttribute("u");
		out.println(user.getName()+" "+user.getPassword());
	%>
</body>
</html>
