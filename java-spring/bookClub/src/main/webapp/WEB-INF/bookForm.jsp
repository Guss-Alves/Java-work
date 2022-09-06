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
<title>Book form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
	<div class="d-flex justify-content-between align-items-center mt-5">
			<h1>Add new book</h1>
			<a href="/dashboard" >Go Back</a>
		</div>
	
	
<form:form action="/book/new" method="POST"  modelAttribute="book">
	<div class="form-group">
		<form:label path="title">Title:</form:label>
		<form:input class="form-control" type="text" path="title"/>
		<form:errors class="text-danger" path="title"/>
	</div>
	<div class="form-group">
		<form:label path="author">Author:</form:label>
		<form:input class="form-control" type="text" path="author"/>
		<form:errors class="text-danger" path="author"/>
	</div>
		<div class="form-group">
		<form:label path="thoughts">My thoughts:</form:label><br>
		<form:textarea cols="70" rows="4" path="thoughts" /><br>
		<form:errors class="text-danger" path="thoughts"/>
	</div>
	<div class="form-group mt-2">
	<form:hidden path="user" value="${userId}" />
		<input class="btn btn-primary" type="submit" value="Add"/>
	</div>
</form:form>


</div>
</body>
</html>