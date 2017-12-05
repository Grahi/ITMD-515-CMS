<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" import="java.util.*"%>


<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link href="<%=request.getContextPath()%>/JSP/css/TopMenu2.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/JSP/css/SideNav.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/JSP/css/TableStyle.css" 	rel="stylesheet" type="text/css">
	<title>Assignments</title>
</head>

</head>

<body>
<div id="mySidenav" class="sidenav">
		<a href="#" class="closebtn" onclick="closeNav()">&times;</a> 
		<a href="<%=request.getContextPath()%>/TAServlet">Teaching Assistant </a>
		<a href="<%=request.getContextPath()%>/ResourceServlet">Course Resources</a> 
		<a href="<%=request.getContextPath()%>/ScheduleServlet">Schedule</a>
		<a href="<%=request.getContextPath()%>/AssignmentServlet">Assignments</a>
	</div>

	<div id="main">
		<ul id="topnav">
			<li>
				<a href="<%=request.getContextPath()%>/<%=session.getAttribute("roleName")%>Servlet">
				<i	class="material-icons">home</i></a>
			</li>
			<li style="float: right">
				<a href="<%=request.getContextPath()%>/LogoutServlet">Logout
				<i	class="material-icons">login</i></a>
			</li>
		</ul>
	
		<div class="w3-container w3-card-4" style="font-size: 15px">
			<h5 style="float: right; font-size: 15px">
				<%=session.getAttribute("userName")%></h5>
			
			<h5 style="font-size: 15px">
				<input name="panelbtn" onclick="openNav()" type="button"
					value="&#9776;" /> Course : <%=session.getAttribute("courseName")%>
			</h5>
			
		</div>
		
		<div class="table-title">
			<h3 align=center>Assignments</h3>
		</div>
		<table class="table-fill">
			<thead>
				<tr>
					<th class="text-left">Assignment</th>
					<th class="text-left">Date Posted</th>
					<th class="text-left">Due Date</th>					
				</tr>
			</thead>
			<tbody class="table-hover">
				<c:forEach var="ta" items="${assmtList}">
				<tr>					
					<td class="text-left">${ta.assignmentText} </td>
					<td class="text-left">${ta.datePosted} </td>
					<td class="text-left">${ta.dueDate} </td>		
				</tr>
				</c:forEach>			
		
			</tbody>
		</table>
</div>
<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "200px";
			document.getElementById("main").style.marginLeft = "200px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";

		}
	</script>
</body>



</html>
