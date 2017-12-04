<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" 	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<%=request.getContextPath()%>/JSP/css/TopMenu2.css"	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/JSP/css/Accordian.css" 	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/JSP/css/AdminPageStyle.css" 	rel="stylesheet" type="text/css">
	
<title>Admin Page</title>
</head>
<body>

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
	<h5 style="float: right; font-size: 15px"><%=session.getAttribute("userName")%></h5>
</div>
	<button class="accordion" style="align:center">Professor</button>
	<div class="panel">
	
		<div id="page_container">

			<button type="button" class="button"  onclick="AddProf()" id="add_professor">Add Professor</button>

			<table class="datatable" id="table_companies">
				<thead>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Contact</th>
						<th>Email</th>					
						<th>Functions</th>
					</tr>
				</thead>
				<tbody>				
					<c:forEach var="prof" items="${profList}">
					<c:url var="templink" value="AdminServlet">
					 	<c:param name="profId" value="${prof.profId}"/> 
					 	<c:param name="command" value="LOADPROFESSOR"/> 
					 </c:url>
					 <c:url var="deletelink" value="AdminServlet">
					 	<c:param name="profId" value="${prof.profId}"/> 
					 	<c:param name="command" value="DELETEPROFESSOR"/> 
					 </c:url>
					 
						<tr>					
							<td class="text-left">${prof.profFirstName} </td>
							<td class="text-left">${prof.profLastName} </td>
							<td class="text-left">${prof.profContact} </td>
							<td class="text-left">${prof.profEmail} </td>	
							<td class="text-left">
							<form action="">								
							    <a href="${templink}" title="Click to update professor details."><i class="fa fa-pencil-square-o"></i></a> | 
							    <a href="${templink}" title="Click to add professor as an user of this app."><i class="fa fa-user-o"></i></a> |
								 <a href="${deletelink}" title="Click to delete professor."
								 onclick="if(!(confirm('Are you sure you want to delete this professo? All the courses registered and user profile will also be delete.'))) return false"
								 ><i class="fa fa-trash-o"></i></a>
							</form></td>			
							</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
</div>
	
		<button class="accordion">Student</button>
		<div class="panel">
			<div id="page_container">

			<button type="button" class="button" onclick="AddStudent()" id="add_student">Add
				Student</button>
			<table class="datatable" id="table_companies">
				<thead>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Contact</th>
						<th>Email</th>						
						<th>Functions</th>
					</tr>
				</thead>
				<tbody>
			
					<c:forEach var="stud" items="${studList}">
						<c:url var="templink" value="AdminServlet">
						 	<c:param name="studentId" value="${stud.studentId}"/> 
						 	<c:param name="command" value="LOADSTUDENT"/> 
					 	</c:url>	
					 	<c:url var="deletelink" value="AdminServlet">
						 	<c:param name="studentId" value="${stud.studentId}"/> 
						 	<c:param name="command" value="DELETESTUDENT"/> 
					 	</c:url>					 
						<tr>					
							<td class="text-left">${stud.studentFirstName} </td>
							<td class="text-left">${stud.studentLastName} </td>
							<td class="text-left">${stud.studentContact} </td>
							<td class="text-left">${stud.studentEmail} </td>	
							<td class="text-left">
							<form action="">								
							    <a href="${templink}" title="Click to update student details."><i class="fa fa-pencil-square-o"></i></a> |
							    <a href="${templink}" title="Click to add student as an user of this app."><i class="fa fa-user-o"></i></a> |
								<a href="${deletelink}" title="Click to delete student."
								onclick="if(!(confirm('Are you sure you want to delete this student? All the courses registered and user profile will also be delete.'))) return false"
								><i class="fa fa-trash-o"></i></a>
							</form></td>			
						</tr>
					</c:forEach>	
				</tbody>
			</table>

		</div>
		</div>

<button class="accordion">Course</button>
		<div class="panel">
			<div id="page_container">

			<button type="button" class="button" onclick="AddCourse()" id="add_course">Add
				Course</button>

			<table class="datatable" id="table_companies">
				<thead>
					<tr>
						<th>CourseCode</th>
						<th>CourseName</th>						
						<th>Location</th>
						<th>Functions</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="course" items="${courseList}">
						<c:url var="templink" value="AdminServlet">
						 	 <c:param name="courseId" value="${course.courseId}"/> 
						 	<c:param name="command" value="LOADCOURSE"/> 
					 	</c:url>	
					 	<c:url var="deletelink" value="AdminServlet">
						 	 <c:param name="courseId" value="${course.courseId}"/> 
						 	<c:param name="command" value="DELETECOURSE"/> 
					 	</c:url>						
						<tr>					
							<td class="text-left">${course.courseCode} </td>
							<td class="text-left">${course.courseName} </td>							
							<td class="text-left">${course.location} </td>	
							<td class="text-left">
							<form action="">								
								<a href="${templink}" title="Click to update course details."><i class="fa fa-pencil-square-o"></i></a>
								|
								<a href="${deletelink}" title="Click to delete course."
								onclick="if(!(confirm('Are you sure you want to delete this course? The course will be automatically removed for professor and student.'))) return false"
								><i class="fa fa-trash-o"></i></a>
							</form></td>			
							</tr>
					</c:forEach>	

				</tbody>
			</table>

		</div>
		</div>
		
		<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function(){
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
        } else {
            panel.style.display = "block";
        }
    }
}

function AddProf() {

	location.href = "<%=request.getContextPath()%>/JSP/AddProf.jsp";
}

function AddStudent() {

	location.href = "<%=request.getContextPath()%>/JSP/AddStudent.jsp";
}

function AddCourse() {

	location.href = "<%=request.getContextPath()%>/JSP/AddCourse.jsp";
}

</script>
</body>
</html>