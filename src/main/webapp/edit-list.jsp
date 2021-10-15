<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit An Existing List</title>
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
<h1>List Editor</h1>
<form action = "EditCourseDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
Start date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name="year" placeholder="yyyy" size="4" value= "${year}">
Student Name: <input type = "text" name = "studentName" value="${listToEdit.student.studentName}"><br />
Available Courses:<br />
<select name="allCoursesToAdd" multiple size="6">
<c:forEach items="${requestScope.allCourses}" var="currentcourse">
 <option value = "${currentcourse.id}">${currentcourse.courseName} |
${currentcourse.courseTeacher}</option>
</c:forEach>
</select>
<br /><br />
<input type = "submit" value="Confirm Edit">
</form>
<br />
<a href = "index.html">Home</a>
</body>
</html>