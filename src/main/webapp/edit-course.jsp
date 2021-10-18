<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
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
<h1>Edit Course:</h1>
<form action = "EditCourseServlet" method="post">
Course Name: <input type ="text" name = "courseName" value="${courseToEdit.courseName}">
Teacher Name: <input type ="text" name = "courseTeacher" value="${courseToEdit.courseTeacher}">
<input type = "hidden" name = "id" value="${courseToEdit.id}">
<input type = "submit" value="Save Edited Course">
</form>

</body>
</html>