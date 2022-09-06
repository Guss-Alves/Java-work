<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create dojos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1>New Dojo</h1>
		
		<form:form action="/" method="POST" modelAttribute="dojo">
			<div>
				<form:label path="name">Name:</form:label>
				<form:input type="text" path="name" />
				<form:errors class="text-danger" path="name"/>
			</div>
		<input class="btn btn-success btn-sm mt-2 mb-2" type="submit" value="Create" />
		</form:form>
		<a href="/ninja">Add a new ninja -></a>
		<h4 class="mt-5">View dojos</h4>
		<c:forEach var="eachDojo" items="${dojos}">
			<a href="/show/dojo/${eachDojo.id}"><c:out value="${eachDojo.name}" /></a><br>
		</c:forEach>
	</div>
	
	
</body>
</html>