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
<title>Login and Reg form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
	<h1 class="text-success" >Welcome</h1>
	<p> Join our growing community </p>
	
	<h2 class="mt-5">Register</h2>
	<form:form action="/register" method="POST" modelAttribute="newUser">
	<div class="form-group">
		<form:label path="userName">User Name:</form:label>
		<form:input class="form-control" type="text" path="userName"/>
		<form:errors class="text-danger" path="userName"/>
	</div>
	<div class="form-group">
		<form:label path="email">Email:</form:label>
		<form:input class="form-control" type="text" path="email"/>
		<form:errors class="text-danger" path="email"/>
	</div>
	<div class="form-group">
		<form:label path="password">Password:</form:label>
		<form:input class="form-control" type="password" path="password"/>
		<form:errors class="text-danger" path="password"/>
	</div>
	<div class="form-group">
		<form:label path="confirm">Confirm Password:</form:label><br/>
		<form:input class="form-control" type="password" path="confirm"/>
		<form:errors class="text-danger" path="confirm"/>
	</div>
	<div class="form-group mt-2">
		<input class="btn btn-primary" type="submit" value="Register"/>
	</div>
</form:form>
	
	<h2 class="mt-5">Login</h2>
	<form:form action="/login" method="POST" modelAttribute="newLogin">
	<div class="form-group">
		<form:label path="email">Email:</form:label>
		<form:input class="form-control" type="text" path="email"/>
		<form:errors class="text-danger" path="email"/>
	</div>
	<div class="form-group">
		<form:label path="password">Password:</form:label>
		<form:input class="form-control" type="password" path="password"/>
		<form:errors class="text-danger" path="password"/>
	</div>
	<div class="form-group mt-2">
		<input class="btn btn-primary" type="submit" value="Login"/>
	</div>
</form:form>




</div>
</body>
</html>