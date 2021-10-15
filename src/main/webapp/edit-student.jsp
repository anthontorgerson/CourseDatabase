<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:link {color: black;}
a:visited {color: black;}
a:hover {color: purple;}
body {background-color: rgb(198, 207, 221);}
</style>
</head>
<body>
<h1>Edit Student:</h1>
<form action = "EditStudentServlet" method="post">
Name: <input type ="text" name = "name" value="${studentToEdit.studentName}">
<input type = "hidden" name = "id" value="${studentToEdit.id}">
<input type = "submit" value="Save Edited Student">
</form>

</body>
</html>