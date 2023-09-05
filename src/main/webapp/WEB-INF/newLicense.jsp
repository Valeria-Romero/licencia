<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>License</title>
</head>
<body>
	<h1>New license</h1>
	<form:form action="/license/create" method="POST" modelAttribute="license">
		<div>
			<form:label path="person">Person: </form:label>
			<form:select path="person">
				<c:forEach items="${people}" var="person">			
					<form:option value="${person.id }">${person.name} ${person.lastName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="person"/>
		</div>
		<div>
			<form:label path="state">State: </form:label>
			<form:input path="state"/>
			<form:errors path="state"/>
		</div>
		<div>
			<form:label path="expirationDate">Expiration date: </form:label>
			<form:input path="expirationDate" type="date"/>
			<form:errors path="expirationDate"/>
		</div>
		<input type="submit" value="Save">
	</form:form>
</body>
</html>