<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 	pageEncoding="ISO-8859-1"%>
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
<link href="<%=request.getContextPath()%>/JSP/css/SideNav.css" 	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/JSP/css/CoursePageGrid.css"	rel="stylesheet" type="text/css">
<title>Course Details</title>

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
			<li><a href="<%=request.getContextPath()%>/ProfessorServlet">
			<i	class="material-icons">home</i></a></li>
			<li style="float: right"><a
				href="<%=request.getContextPath()%>/LogoutServlet">Logout
				<i	class="material-icons">login</i></a></li>
		</ul>

		<div class="w3-container w3-card-4" style="font-size: 15px">
			<h5 style="float: right; font-size: 15px">
				<%=session.getAttribute("userName")%></h5>			
			<h5 style="font-size: 15px">
				<input name="panelbtn" onclick="openNav()" type="button" title= "Click to open left menu bar"
					value="&#9776;" /> Course :
				<%=session.getAttribute("courseName")%>
			</h5>			
		</div>

		<div class="w3-container">
			<h3>Course Console</h3>

			<div class="row">
				<div class="column">
					<div class="w3-panel w3-card-4" style="width: 95%">
						<!-- <header class="w3-container"> -->
						<h4>Teaching Assistant</h4>
					<!-- 	</header> -->
						<div class="w3-container">
							<hr>
							<p><%=request.getAttribute("taName")%></p>
						</div>
					</div>

					<div class="w3-panel w3-card-4" style="width: 95%">
						<!-- <header class="w3-container" style="height: 50%"> -->
						<h4>What's Due</h4>
						<!-- </header> -->
						<div class="w3-container" style="font-size: 15px">
							<hr>
							<p>Nothing Due</p>
						</div>
					</div>

				</div>
				<div class="column">
					<div class="w3-panel w3-card-4" >
						<!-- <header class="w3-container w3-light-silver"> -->
						<h4>Resources:</h4>
						<!-- </header> -->
						<div class="w3-container">							
						   <hr>		 
							<ul>				    
							    	<c:forEach var="resource" items="${rscList}">							  	
							      	<li><c:out value="${resource.resourceName}"/></li>					               						            
							      </c:forEach>						       
							  </ul>	
						</div>
					</div>

					<div class="w3-panel w3-card-4" style="width: 95%">
						<!-- <header class="w3-container w3-light-silver"> -->
						<h4>New Assignments</h4>
						<!-- </header> -->
						<div class="w3-container">
							<hr>
							<!-- <p>Develop an online application using JEE (jsp and servlets)
								that responds to a user requests via on-line forms. Individual
								Assignment. Develop an online application using JEE (jsp and
								servlets) that responds to a user requests via on-line forms.
								Individual Assignment.</p> -->
								<p><%=request.getAttribute("assignmentName")%></p>
							<br>
						</div>

					</div>


				</div>
			</div>


			<!-- <p
				style="position: fixed; bottom: 0; width: 100%; color: #800000; text-align: left">
				*Check the course details from left menu bar by clicking on the
				courseNumber</p> -->

		</div>
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

