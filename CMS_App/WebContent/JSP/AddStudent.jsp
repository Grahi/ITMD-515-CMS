<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<link href="<%=request.getContextPath()%>/JSP/css/AddForm.css"
	rel="stylesheet" type="text/css">
	
<title>Add Student</title>
</head>
<body>
 <form class="form-style-9">
<ul>
<li>
    <input type="text" name="student_first_name" class="field-style field-split align-left" placeholder="FirstName" />
    <input type="text" name="student_last_name" class="field-style field-split align-right" placeholder="LastName" />

</li>
<li>
    <input type="text" name="student_contact" class="field-style field-split align-left" placeholder="Contact" />
    <input type="text" name="student_email" class="field-style field-split align-right" placeholder="Email" />
</li>
<!-- <li>
<input type="text" name="student_password" class="field-style field-full align-none" placeholder="Password" />
</li> -->
<li>
<input type="submit" value="Add" />
</li>
</ul>
</form>

  

  </body>
</html>
