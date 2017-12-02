<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" 	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="<%=request.getContextPath()%>/JSP/css/AddForm.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/JSP/css/TopMenu2.css"	rel="stylesheet" type="text/css">

<title>Add Course</title>
</head>
<body>
<ul id="topnav">					
		<li style="float: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout 
		<i class="material-icons">login</i></a>
		</li>
</ul>
<div class="w3-container w3-card-4" style="font-size: 15px">
	<h5 style="float: right; font-size: 15px"><%=session.getAttribute("userName")%></h5>
</div>

 <form class="form-style-9" action="<%=request.getContextPath()%>/AdminServlet" >
 	<input type="hidden" name="command" value="ADDCOURSE">
<h2 align="center">Add Course</h2>
<ul>
<li>
    <input type="text" name="course_code" class="field-style field-split align-left" placeholder="CourseCode" />
    <input type="text" name="course_name" class="field-style field-split align-right" placeholder="CourseName" />

</li>
<li>
    <input type="text" name="location" class="field-style field-split align-left" placeholder="CourseLocation" />    
</li>
<!-- <li>
	<textarea name="syllabus" class="field-style" placeholder="Message"></textarea>
</li> -->
<li>
	<input type="submit" value="Add" />
</li>
<li>
	 <p>
	 	<a href="<%=request.getContextPath()%>/AdminServlet">Back to Admin Page.</a>
	 </p>
</li>
</ul>
</form>

  

  </body>
</html>