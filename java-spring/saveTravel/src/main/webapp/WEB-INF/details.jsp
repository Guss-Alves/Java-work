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
	<div class="container mt-5 ">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Expense Details </h1>
			<a href="/" >Go Back</a>
		</div>
		<div class="border mt-4 p-4">
		<h3>Expense Name: <c:out value="${oneExpense.expenseName}"/> </h3>
		<h3>Expense Description: <c:out value="${oneExpense.description}"/> </h3>
		<h3>Expense vendor: <c:out value="${oneExpense.vendor}"/> </h3>
		<h3>Amount Spent: $<c:out value="${oneExpense.amount}"/> </h3>
		</div>
	</div>
</body>
</html>