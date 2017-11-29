<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' 	rel='stylesheet' type='text/css'>
<link href="http://localhost:8080/CMS_App/JSP/css/LoginPageStyle.css" rel="stylesheet" type="text/css">
<title>Course Management Login</title>
</head>
<body>
	<%-- <jsp:include page="MyHeader.jsp" /> --%>
	<form name="form" action="<%=request.getContextPath()%>/LoginServlet" 		method="post">
		<div class="logo"></div>
		<div class="login-block">
			<h1>Login</h1>
			<input type="text" name="username" /> <input type="password"
				name="password" /> <span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
			<button name="submit" type="submit" value="Login">Submit</button>
		</div>
	</form>
	<jsp:include page="MyFooter.jsp" />
</body>
</html>

