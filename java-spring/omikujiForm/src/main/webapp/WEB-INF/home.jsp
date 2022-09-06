<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="text-center">Send an Omikuji !</h1>
	<div class="text-center mt-4 container border border-dark mb-4 p-4" style="width: 700px;">
	<form action="/process/form" method="POST">
	
		<div class="form-group mt-2">
			<label> Pick any number from 5 to 25 </label>
			<input class="form-control" type="number" id="year" name="year" />
		</div>
		<div class="form-group mt-3">
			<label> Enter the name of any city </label>
			<input class="form-control" type="text" id="city" name="city" />
		</div>
		<div class="form-group mt-3">
			<label> Enter the name of any real person </label>
			<input class="form-control" type="text" id="name" name="name" />
		</div>
		<div class="form-group mt-3">
			<label> Enter professional endeavor or hobby: </label>
			<input class="form-control" type="text" id="hobby" name="hobby" />
		</div>
		<div class="form-group mt-3">
			<label> Enter any type of living thing </label>
			<input class="form-control" type="text" id="livingThing" name="livingThing" />
		</div>
		<div class="form-group mt-3">
			<label> Say something nice to someone: </label><br>
			<textarea rows="3" cols="35" id="message" name="message"></textarea>
		</div>
		<div class="form-group mt-3 mb-3">
			<p> Send and show a friend  <p/>
		</div>
		<input class="btn btn-primary" type="submit" value="Send" />
	</form>
	</div>
</body>
</html>