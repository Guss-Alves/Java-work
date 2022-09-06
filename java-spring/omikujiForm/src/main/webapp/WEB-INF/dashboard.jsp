<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="text-center">Here's Your Omikuji !</h1>

	<div class="text-center mt-4 container border border-dark mb-4 p-4 bg-primary p-4" style="width: 500px;">
		<h2 class="text-wrap">In <c:out value="${Year}"/> years, you will live by <c:out value="${City}"/> with <c:out value="${fName}"/> as your roommate, <c:out value="${Hobby}"/> for a living. The next time you see a <c:out value="${LivingThing}"/>, you will have good luck. Also, <c:out value="${Message}"/> </h2>
	</div>
	<div class="text-center" >
		<a href="/" >Go Back</a>
	</div>
</body>
</html>