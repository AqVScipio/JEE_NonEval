<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenue</title>
	<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
	<%@include file="commons/menu.jsp" %>
	
	<h1>Nouvel Utilisateur</h1>
  	
	<form action="users" method="post">
	
		<label for="username">Username :</label> <input type="text"  name="username">
		
		<input type="submit" value="Valider" />
	</form>
	
</div>
</body>
</html>