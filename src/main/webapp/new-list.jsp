<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Creator</title>
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

<h1>Create a new List</h1>
<form action = "CreateNewListServlet" method="post">

List Name: <input type ="text" name = "listName"><br />
Start date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
Student Name: <input type = "text" name = "studentName"><br />
Available Courses:<br />

<select name="allCoursesToAdd" multiple size="6">
<c:forEach items="${requestScope.allCourses}" var="currentcourse">
	<option value = "${currentcourse.id}">${currentcourse.courseName} | ${currentcourse.courseTeacher}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Courses">
</form>
<a href = "index.html">Go add new courses instead.</a>
</body>
</html>