<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Nouvelle idée</title>
	<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
	<%@include file="commons/menu.jsp" %>
    	
  	<form action="idees?action=list" method="post">
		<label class="w3-text-blue" for="titre">Titre de l'Idée :</label> <input class="w3-input w3-border" type="text"  name="titre" />

		<label class="w3-text-blue" for="pitch">Pitch :</label> <textarea class="w3-input w3-border" rows="5" cols="20"  name="pitch" placeholder="Ecrire votre idée ici."></textarea>
		<input type="submit" value="Valider" />
	</form>
</div>
</body>
</html>