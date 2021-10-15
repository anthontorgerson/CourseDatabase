<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Lists</title>
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
<h1>All Lists</h1>
	<form method="post" action="ListNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Start Date: ${currentlist.startDate}</td>
				</tr>
				<tr>
					<td colspan="3">Student: ${currentlist.student.studentName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfCourses}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.courseName}, ${listVal.courseTeacher}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<br />
		<br />
		<input type="submit" value="edit" name="doThisToList"> 
		<input type="submit" value="delete" name="doThisToList"> 

	</form>
	<br />
	<br />
	<a href="AddCoursesForListServlet">Create a new List</a><br />
	<a href="index.html">Home</a>
</body>
</html>