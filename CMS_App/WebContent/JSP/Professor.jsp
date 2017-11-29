<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" 	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="<%=request.getContextPath()%>/JSP/css/TopMenu2.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/JSP/css/SideNav.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/JSP/css/CoursePageGrid.css" 	rel="stylesheet" type="text/css">

<title>Professor's Home Page</title>
</head>
<body>

	<div id="main">
		<ul id="topnav">
			<li><a href="<%=request.getContextPath()%>/ProfessorServlet">
			<i	class="material-icons">home</i></a></li>
			<li style="float: right">
			<a href="<%=request.getContextPath()%>/LogoutServlet">Logout
				<i	class="material-icons">login</i></a></li>
		</ul>

		<div class="w3-container w3-card-4" style="font-size: 15px">
			<h5 style="float: right; font-size: 15px">
				<%=session.getAttribute("userName")%></h5>

		</div>

		<div class="w3-container">

			<div class="w3-card-4" style="font-size: 15px">
				<!-- <header class="w3-container "> -->
				<h5 style="align: left; border-bottom: 2px solid #9ea7af">My
					Courses:</h5>
				<!-- </header> -->

				<div class="w3-container">

					<div id="course">
						<table id="courseList" class="table">
							<thead>

							</thead>
							<tbody>
								<c:forEach var="course" items="${courseList}">
									<c:url var="courseLink" value="CourseServlet">
										<c:param name="courseId" value="${course.courseId}"></c:param>
									</c:url>
									<tr>
										<td><a href="${courseLink}"> ${course.courseCode} :
												${course.courseName} </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>

				
			</div>
		</div>

	</div>
	

</body>

</html>



