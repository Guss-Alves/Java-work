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
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1> Welcome, <c:out value="${userName}" /> ! </h1>
			<a href="/logout" >Logout</a>
		</div>
		<div class="d-flex justify-content-between align-items-center mt-3">
			<h4> Books of everyone's shelves </h4>
			<a href="/book/new" >+ add a new book</a>
		</div>
		
		<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Posted By</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="eachBook" items="${books}">
    <tr>
      <th scope="row"><c:out value="${eachBook.id}" /></th>
      <td> <a href="book/show/${eachBook.id}"> <c:out value=" ${eachBook.title}" /> </a> </td>
      <td> <c:out value="${eachBook.author}" /></td>
      <td> <c:out value="${eachBook.user.userName}" /></td>
     
    </tr>
  </c:forEach>
  </tbody>
</table>
		
	</div>
</body>
</html>