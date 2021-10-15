<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:link {color: black;}
a:visited {color: black;}
a:hover {color: purple;}
body {background-color: #bce6df;}
</style>
</head>
<body>
<h1>All Students</h1>
<form method = "post" action = "NavigationServlet">

<table>
<c:forEach items="${requestScope.allStudents}" var="currentstudent">
<tr>
 <td><input type="radio" name="id" value="${currentstudent.id}"></td>
 <td>${currentstudent.studentName}</td>
 </tr>
</c:forEach>
</table>


<br />
<br />

<input type = "submit" value = "edit" name="doThisToStudent">
<input type = "submit" value = "delete" name="doThisToStudent">

</form>
<ul><li><a href = "index.html">Home</a></li></ul>
</body>
</html>