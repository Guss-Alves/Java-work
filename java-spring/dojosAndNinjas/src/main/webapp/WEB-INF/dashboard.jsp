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
<title>display ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h1> <c:out value="${dojo.name}" /> Ninjas</h1>
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="eachDojo" items="${dojo.ninjas}">
  <tr>
    <td>${eachDojo.firstName}</td>
     <td>${eachDojo.lastName}</td>
     <td>${eachDojo.age}</td>
  </tr>  
</c:forEach>
  </tbody>
</table> 
	<a href="/"> <-- Go Back </a>
	</div>
	
</body>
</html>