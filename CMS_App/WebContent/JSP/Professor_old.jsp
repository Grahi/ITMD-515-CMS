<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath() %>/JSP/css/TopMenu.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/JSP/css/SideNav.css" rel="stylesheet" type="text/css">
<title>Professor's Home Page</title>
</head>
<body>

	<div id="main">		
		<ul id="topnav">		
			<li style="float: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
		</ul>		
		<h4 style="float: left">Hello!  <%=session.getAttribute("userName")%></h4>
		<br/>
		<br/>
		<br/>
		<div id="course">
			<table id="courseList" class="table">
				<thead>
					<tr>
						<th><strong>Course Registered :</strong></th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${courseList}">
						<c:url var="courseLink" value="CourseServlet">							
							<c:param name="courseId" value="${course.courseId}"></c:param>
						</c:url>
						<tr>
							<td> <a href="${courseLink}">  ${course.courseCode} :  ${course.courseName} </a></td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		
		
	</div>


</body>

</html>



