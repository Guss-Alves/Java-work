<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="mt-3 ms-5 me-5" >
<h1 style="color:pink;">Fruit Store</h1>
<table class="table w-50" style="border:15px solid pink;" >
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="fruits" items="${fruits}">
    <tr>
      <td> ${fruits.name} </td>
      <td> <c:out value="${fruits.price}"></c:out> </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
</body>
</html>