<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Bienvenue</title>
	<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
	<%@include file="commons/menu.jsp" %>
	
	<h3 style="text-decoration: underline;">Nouvel Utilisateur</h3>
  	
	<form action="users" method="post">
	
		<label class="w3-text-blue" for="username">Username :</label> <input class="w3-input w3-border" type="text"  name="username">
		
		<input type="submit" value="Valider" />
	</form>
	
</div>
</body>
</html>