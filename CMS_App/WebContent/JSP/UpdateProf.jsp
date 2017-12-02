<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<link href="<%=request.getContextPath()%>/JSP/css/AddForm.css"  rel="stylesheet" type="text/css">
	
<title>Update Professor</title>
</head>
<body>
 <form class="form-style-9" action="<%=request.getContextPath()%>/AdminServlet" >
	<input type="hidden" name="command" value="UPDATEPROFESSOR">
	<input type="hidden" name="profId" value="${prof.profId}">
<ul>
<li>
    <input type="text" name="professor_first_name" class="field-style field-split align-left" placeholder="FirstName"  value ="${prof.profFirstName}"/>
    <input type="text" name="professor_last_name" class="field-style field-split align-right" placeholder="LastName"  value ="${prof.profLastName}"/>
</li>
<li>
    <input type="text" name="professor_contact" class="field-style field-split align-left" placeholder="Contact"  value ="${prof.profContact}"/>
    <input type="text" name="professor_email" class="field-style field-split align-right" placeholder="Email"  value ="${prof.profEmail}"/>
</li>
<li>
	<input type="submit" value="Save" />	
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
