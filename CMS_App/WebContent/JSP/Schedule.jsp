<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="ScheduleBeanId" class="com.bean.Schedule" scope="session"></jsp:useBean>
<jsp:setProperty name="ScheduleBeanId" property="*" />


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Resources</title>

<link rel="stylesheet" href="https://www.w3schools.com/html/styles.css">

<style>
div {
    border: 1px solid powderblue;
   
}
</style>
</head>
<body>

	<form method="post" >
		<br /> <br /> <br />
		<h1>
			Schedule for:
			<%=request.getAttribute("courseName")%></h1>
		<br /> 
		
		<table  bgcolor=white border="2">
			<tr>
				<th>TITLE</th>
				<th>DATE ASSIGNED</th>
				<th>DATE DUE</th>
				<th>LOCATION</th>
				
			</tr>
			<%
				String title = ScheduleBeanId.getScheduleTitle();
				String date_assigned = ScheduleBeanId.getStartTime().toString();
				String date_due = ScheduleBeanId.getEndTime().toString();
				String location = ScheduleBeanId.getLocation();				
			%>

			<tr>
				<td>Textbook</td>
				<td>JEE</td>				
			</tr>

			<tr>
				<td>Textbook</td>
				<td>Python, Author: </td>				
			</tr>
		</table>

	</form>

</body>
</html>
