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
<title>create ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1>New Ninja</h1>
		
		<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
			<label>Select a dojo:</label>
			<form:select path="dojo">
        		<c:forEach var="eachDojo" items="${dojo}">
        			 <form:option value="${eachDojo.id}">${eachDojo.name}</form:option>
        		</c:forEach>
   			</form:select>
			<div>
				<form:label path="firstName">First Name:</form:label>
				<form:input type="text" path="firstName" />
				<form:errors class="text-danger" path="firstName"/>
			</div>
			<div>
				<form:label path="lastName">Last Name:</form:label>
				<form:input type="text" path="lastName" />
				<form:errors class="text-danger" path="lastName"/>
			</div>
			<div>
				<form:label path="age">Age:</form:label>
				<form:input type="number" path="age" />
				<form:errors class="text-danger" path="age"/>
			</div>
		<input class="btn btn-success btn-sm mt-2 mb-2" type="submit" value="Create" />
		</form:form>
		
	<a href="/">Go Back</a>
	</div>
	
</body>
</html>