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
	<h1>Save Travels</h1>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="eachExpense" items="${expenseList}">
    <tr>
      <td> <a href="/expense/show/${eachExpense.id}"> ${ eachExpense.expenseName } </a> </td>
      <td>${ eachExpense.vendor }</td>
      <td>${ eachExpense.amount }</td>
      <td> <div class="d-flex"> <a class="btn btn-primary me-1" href="/expense/${eachExpense.id}">Edit</a>
  		<form action="/expense/delete/${eachExpense.id}" method="POST" >
	  		<input type="hidden" name="_method" value="delete"/>
	  		<button class="btn btn-danger" type="submit" >Delete</button>
  		</form>	 
  		</div>    
       </td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<h2>Add an expense:</h2>
<form:form action="/expenses/new" method="POST" modelAttribute="expense">
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