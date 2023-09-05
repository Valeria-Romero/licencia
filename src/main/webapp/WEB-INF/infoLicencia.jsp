<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>License</title>
</head>
<body>
	<h1>Person list</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Last name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="person">
				<tr>
					<td>${person.name }</td>
					<td>${person.lastName }</td>
					<td><a href="/view/${person.id}">View complete info</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>