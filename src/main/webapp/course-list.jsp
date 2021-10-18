<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
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
<h1>All Courses</h1>
<form method = "post" action = "CourseNavigationServlet">

<table>
<c:forEach items="${requestScope.allCourses}" var="currentcourse">
<tr>
 <td><input type="radio" name="id" value="${currentcourse.id}"></td>
 <td>${currentcourse.courseName}</td>
 <td>${currentcourse.courseTeacher}</td>
 </tr>
</c:forEach>
</table>


<br />
<br />

<input type = "submit" value = "edit" name="doThisToCourse">
<input type = "submit" value = "delete" name="doThisToCourse">

</form>
<a href = "index.html">Home</a>
</body>
</html>