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
<title>Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
	<div class="d-flex justify-content-between align-items-center">
		<h1><c:out value="${foundBook.title}"/></h1>
		<a href="/dashboard" >Go Back</a>
	</div>
	
	<h2 class=" mt-4" ><span class="text-danger" ><c:out value="${foundBook.user.userName}"/></span> read <span style="color: purple;"><c:out value="${foundBook.title}"/></span> by <span class="text-success"><c:out value="${foundBook.author}"/></span></h2>
	<h3 class=" mt-4" >Here are <c:out value="${foundBook.user.userName}"/>'s thoughts: </h3>
	
	<div class="card mt-3">
  		<div class="card-body">
    		<h5><c:out value="${foundBook.thoughts}"/></h5>
  		</div>
	</div>
	<c:if test="${userId == foundBook.user.id }">
		<a href="/book/edit/${foundBook.id}" class="btn btn-primary mt-2">Edit</a>
			
		<form class="mt-2" action="/book/delete/${foundBook.id}" method="POST">
			<input type="hidden" name="_method" value="delete"/>
			<button class="btn btn-danger" type="submit" >Delete</button>
		</form>
	</c:if>
	
</div>
</body>
</html>