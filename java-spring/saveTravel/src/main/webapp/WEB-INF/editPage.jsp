<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<div class="d-flex justify-content-between align-itens-center">
	<h2>Edit an expense:</h2>
	<a href="/" >Go Back</a>
</div>
<form:form action="/expense/${expense.id}" method="POST" modelAttribute="expense">
	<input type="hidden" name="_method" value="put"/>
	<div class="form-group">
		<form:label path="expenseName">Expense Name:</form:label>
		<form:input class="form-control" type="text" path="expenseName"/>
		<form:errors class="text-danger" path="expenseName"/>
	</div>
	<div class="form-group">
		<form:label path="vendor">vendor:</form:label>
		<form:input class="form-control" type="text" path="vendor"/>
		<form:errors class="text-danger" path="vendor"/>
	</div>
	<div class="form-group">
		<form:label path="amount">Amount:</form:label>
		<form:input class="form-control" type="number" path="amount"/>
		<form:errors class="text-danger" path="amount"/>
	</div>
	<div class="form-group">
		<form:label path="description">Description:</form:label><br/>
		<form:textarea cols="35" rows="3" path="description" /><br>
		<form:errors class="text-danger" path="description"/>
	</div>
	<div class="form-group">
		<input class="btn btn-primary" type="submit" value="Submit"/>
	</div>
</form:form>

</div>
</body>
</html>